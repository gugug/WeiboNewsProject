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
		url:"${pageContext.request.contextPath }/news/newsIndex.action",
		success:function(data){
			alert(data.length);
		},
		 error: function(data){
			 alert("error");
		 }
	}
	);
}

function newsNews(){
	$.ajax({
		type:"GET",
		dataType: 'json', 
		url:"${pageContext.request.contextPath }/news/newsNews.action?tid=0",
		success:function(data){
			alert(data.length);
		},
		 error: function(data){
			 alert("error");
		 }
	}
	);
}

function newsTopic(){
	$.ajax({
		type:"GET",
		dataType: 'json', 
		url:"${pageContext.request.contextPath }/news/newsTopic.action?eid=0",
		success:function(data){
			alert(data.length);
		},
		 error: function(data){
			 alert("error");
		 }
	}
	);
}

function newsNewsEmoDetail(){
	$.ajax({
		type:"GET",
		dataType: 'json', 
		url:"${pageContext.request.contextPath }/news/newsNewsEmoDetail.action?tid=0&emoid=0",
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
<input type="button" onclick="newsNews()" value="newsNews"  />
<input type="button" onclick="newsTopic()" value="newsTopic"  />
<input type="button" onclick="newsNewsEmoDetail()" value="newsNewsEmoDetail"  />
<br /><br /><br />
<a href="${pageContext.request.contextPath }/news/newsIndex.action"> <input type="button"  value="tonewsIndex"  /> </a>
<a href="${pageContext.request.contextPath }/news/newsTopic.action?eid=0"> <input type="button"  value="tonewsTopic"  /> </a>

<a href="${pageContext.request.contextPath }/news/newsNews.action?tid=0"> <input type="button"  value="tonewsNews"  /> </a>
<a href="${pageContext.request.contextPath }/news/newsNewsEmoDetail.action?tid=0&emoid=0"> <input type="button"  value="tonewsNewsEmoDetail"  /> </a>





</body>
</html>