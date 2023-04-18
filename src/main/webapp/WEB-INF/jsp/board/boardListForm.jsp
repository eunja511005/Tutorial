<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="_csrf" content="${_csrf.token}"/>
<meta name="_csrf_header" content="${_csrf.headerName}"/>
	
<title>Insert title here</title>
    <!-- Favicon-->
    <link rel="icon" type="image/x-icon" href="/assets/myfavicon.ico" />
    
	<!-- Required dataTable -->
	<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.11.3/css/jquery.dataTables.min.css">

		
    <!-- Required jquery -->
    <script type="text/javascript" language="javascript" src="https://code.jquery.com/jquery-3.5.1.js"></script>
    <script type="text/javascript" language="javascript" src="https://code.jquery.com/ui/1.12.0/jquery-ui.min.js"></script>

	<!-- Required bootstrap -->
	<!--<link href="/assets/dist/css/bootstrap.min.css" rel="stylesheet">-->
	
	<link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
  	<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

	<!-- Required summernote -->
  	<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
  	<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>

</head>
<body>
<div class="container-fluid my-3">
    <div class="row align-items-center">
        <div class="col col-9">
            <h2 class="ml-3">Board Lists</h2>
        </div>
        <div class="col col-3">
            <a href="/board/saveForm" role="button" class="btn btn-primary btn-sm ml-3">NEW</a>
        </div>
    </div>
</div>
<hr>

<div class="container-fluid ml-3">
    <table id="example" class="display" style="width:100%">
        <thead>
        <tr>
            <th>Title</th>
            <th>User</th>
            <th>Time</th>
            <th>Contents</th>
            <th>Delete</th>
        </tr>
        </thead>
        <tbody>
        </tbody>
    </table>
</div>



<!-- Modal -->
<div class="modal fade" id="contentModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h1 class="modal-title fs-5" id="exampleModalLabel">Board Detail</h1>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <textarea class="form-control" id="summernote" name="content" rows="10"></textarea>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>



<script type="text/javascript" language="javascript" src="https://cdn.datatables.net/1.11.3/js/jquery.dataTables.min.js"></script>

<!-- Required bootstrap -->
<!--<script type="text/javascript" language="javascript" src="/assets/dist/js/bootstrap.bundle.min.js"></script> -->

<script>
			var nowPage = 1;
			var pageSize = 1;
			
			var csrfheader = $("meta[name='_csrf_header']").attr("content");
	    	var csrftoken = $("meta[name='_csrf']").attr("content");
	    	
            $(document).ready(function() {
            	
            	debugger;
                var aParams = {
                		nowPage : nowPage,
                		pageSize : pageSize
                    };
            	
            	
                $('#example').DataTable({
                   lengthMenu: [10,20,30,40,50],
                   displayLength: 20,
                   scrollX: true,
                   ajax: {
                       url: '/board/list',
                	   type: 'POST',
                	   data: aParams,
	               	   beforeSend: function(xhr) {
	            	   		xhr.setRequestHeader(csrfheader, csrftoken);
	            	   },
                       dataSrc: 'boardList'
                   },
                   columns: [
                       { data: 'title'},
                       { data: 'updateId'},
                       { data: 'updateTime', 
                    	   "render": function(data, type, row, meta){
                    		   data = data;
                    		   return data;
                    	   }
                       },
                       { data: 'content',
                    	   "render": function(data, type, row, meta){
                    		   debugger;
                    		   return '<button type="button" class="btn btn-primary">View Content</button>';
                    	   }                       
                       },
                       { data: 'boardId',
                    	   "render": function(data, type, row, meta){
                               return '<button type="button" class="btn btn-danger">Delete</button>';
                           }
                       }
                   ],
	               columnDefs: [
	            	   //{ targets: 0, visible: false }
	            	],
                   order: [ [2, 'desc'] ]
                });
                
            } );
            
            // Bind click event to delete button
            $('#example').on('click', '.btn-danger', function() {
            	debugger;
                // Get the row data
                var data = $('#example').DataTable().row($(this).parents('tr')).data();
                
                var id = data.boardId;
                
                $.ajax({
                    url: '/board/delete/'+ id,
                    type: 'DELETE',
                    data : data,
                    //contentType : 'application/json; charset=utf-8',
                    processData: false,
                    beforeSend : function(xhr){   
        				xhr.setRequestHeader(csrfheader, csrftoken);
                    },
                    success: function(response) {
                    	debugger;
                    	
                    	if(response.redirectUrl != undefined && response.redirectUrl != ""){
                    		window.location.href = response.redirectUrl;
                    	}
                    },
                    error: function(response) {
                    	debugger;
                        alert(response.responseText);
                    }
                });
                
                
                
                // Call the delete function with the row data
                //deleteRow(data);
            });
            
            function deleteRow(data) {
                // Get the datatable
                var table = $('#example').DataTable();

                // Find the row with the matching data and remove it
                table.rows().eq(0).each(function(index) {
                    var row = table.row(index);
                    var rowData = row.data();
                    if (rowData === data) {
                        row.remove().draw();
                    }
                });
            }
            
            $(document).on('click', '.btn-primary', function(){ 
                var $btn=$(this);
                var $tr=$btn.closest('tr');
                var dataTableRow=$("#example").DataTable().row($tr[0]); // get the DT row so we can use the API on it
                var rowData=dataTableRow.data();
				
                $('#summernote').summernote('code', rowData.content);
		        $('#contentModal').modal('show');
        	});
            
            $(document).on('click', '.btn-secondary', function(){ 
            	$('#contentModal').modal('hide');
        	});
            
            /**
            $("#example").on('click', 'tbody tr button', function () {
                var row = $("#example").DataTable().row($(this)).data();
                console.log(row);
                
                //$('#contentModal .modal-body').html(row.content);
                
		        $('#summernote').summernote({
		            placeholder: 'write your idea',
		            tabsize: 2,
		            height: 300,                 // set editor height
		            minHeight: null,             // set minimum height of editor
		            maxHeight: null,             // set maximum height of editor
		            focus: true                  // set focus to editable area after initializing summernote
		        });    
		        
		        //$('#summernote').summernote('destroy');
		        //$('#summernote').summernote('reset');
		        //$('#summernote').summernote('pasteHTML', row.content);
		        $('#summernote').summernote('code', row.content);
		        //$('#summernote').summernote('pasteHTML', row.content);
		        //$('#summernote').summernote('disable');
                
                $('#contentModal').modal('show');
                
            });
            */

</script>

</body>
</html>