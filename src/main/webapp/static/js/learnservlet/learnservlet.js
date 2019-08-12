$(function(){
	$("button").click(function(){
		/*
		get 方法发送中文请求参数
		var name=encodeURI("老司机");
		$.ajax({
			   type: "GET",
			   url: "/note/LearnServlet?name="+name,
			   success: function(msg){
			     alert( "Data Saved: " + msg );
			   }
		});
		*/
		
		/*
		 * post方法发送中文请求参数
		   $.ajax({
			   type: "POST",
			   url: "/note/LearnServlet",
			   data:"name=老司机",
			   success: function(msg){
			     alert( "Data Saved: " + msg );
			   }
		});
		*/
		
	});
	
})