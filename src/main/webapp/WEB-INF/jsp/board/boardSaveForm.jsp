<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="_csrf" content="${_csrf.token}"/>
<meta name="_csrf_header" content="${_csrf.headerName}"/>

<title>Board Save Form</title>

  <link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>

</head>
<body>

<div class="container my-4">
	<p class="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4">Board</p>
	<form id="boardForm">
		  <div class="row my-4">
		    <div class="col-md-12">
		      <div>
		        <label for="title" class="form-label">Title</label>
		        <input type="text" class="form-control" id="title" name="title" placeholder="title">
		      </div>
		    </div>
		  </div>
		  <div class="row">
		    <div class="col-md-12">
		      <div>
		        <label for="content" class="form-label">Content</label>
		        <textarea class="form-control" id="summernote" name="content" rows="10"></textarea>
		      </div>  
		    </div>
		  </div>
		  <button type="submit" class="btn btn-primary" id="submitButton">Upload</button>
	</form>
</div>

<script>
    $(document).ready(function() {
        $('#summernote').summernote({
            placeholder: 'write your idea',
            tabsize: 2,
            height: 300,                 // set editor height
            minHeight: null,             // set minimum height of editor
            maxHeight: null,             // set maximum height of editor
            focus: true                  // set focus to editable area after initializing summernote
        });
    });
</script>

<script type="text/javascript" src="/js/board/boardSaveForm.js"></script>

</body>
</html>


