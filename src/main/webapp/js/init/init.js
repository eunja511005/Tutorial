 var nowPage = 1;
 var pageSize = 1;
 
$(document).ready(function() {
	
    var csrfheader = $("meta[name='_csrf_header']").attr("content");
    var csrftoken = $("meta[name='_csrf']").attr("content");	
	
	var params = {
		"nowPage" : nowPage,
		"pageSize" : pageSize
	};
	
	$.ajax({
		url: '/getUserProfile',
		type: 'POST',
		data: params,
		contentType: false,
		processData: false,
		beforeSend: function(xhr) {
			xhr.setRequestHeader(csrfheader, csrftoken);
		},
		success: function(response) {
			debugger;

			if (response.redirectUrl != undefined && response.redirectUrl != "") {
				window.location.href = response.redirectUrl;
			}
			
			callBackInit(response);
		},
		error: function(response) {
			debugger;
			alert(response.responseText);
		}
	});
	

	  
}); 

function callBackInit(response){
	$('#userProfileImg').attr('src', response.userProfileImg);
	$('#userSpan').text(response.userName);
}