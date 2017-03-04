<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  	<script type="text/javascript" src="../public/javascript/jquery-3.1.1.min.js"></script>   

<title>Insert title here</title>
<script type="text/javascript">
function newsIndex(){
	
	$.ajax({
		
		type:"GET",
		dataType: 'json', 
		url:"${pageContext.request.contextPath }/news/newsIndex.action?text=马鱼",
		success:function(data){
			alert(data.length);
		},
		 error: function(data){
			 alert("error");
		 }
		
	}
			
	
	);
	
}

</script>

</head>
<body>

<input type="button" onclick="newsIndex()" value="newsIndex"  />

</body>
</html>