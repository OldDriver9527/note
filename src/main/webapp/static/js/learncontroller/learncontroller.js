$(function(){
	$("#learnController").click(function(){
		/*$.ajax({
			type: "GET",
			url: "/note/learnRequestParam?learnRequestParam=learnRequestParam&currentPage=1",
			success:function(data){
				alert("ok");
			}
		});*/
		
		$.ajax({
			type: "POST",
			url: "/note/learnRequestParam",
			data:"learnRequestParam=learnRequestParam&currentPage=1",
			success:function(data){
				alert("ok");
			}
		});
	});
})