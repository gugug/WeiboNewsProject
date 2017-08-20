<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>YUNSHAN</title>
<link rel="stylesheet" href="../public/css/weibo_main.css">
<link rel="stylesheet" href="../public/css/carousel.css">
</head>
<body>

	<!-- 共用的头部 -->
	<%@include file="../publicJsp/weibo2PublicHeader.jsp"%>

	<div id="container">

		<!-- <img class="images" src="../public/images/lindan.png" /> -->

		<c:forEach items="${imageList }" var="img">
			<img class="images" src="../public/images/${img }" />
		</c:forEach>


		<button class="arrow" id="prev">&lt;</button>
		<button class="arrow" id="next">&gt;</button>

		<div class="dot">
			<c:forEach items="${eventList }" var="event">
				<span></span> 
			</c:forEach>
		</div>
		
		
		<c:forEach items="${eventList }" var="event">
			<div class="event_intro" index="${event.eventId }">
				<p>${event.eventTitle }</p>
				<p>${event.explosionTime }</p>
				<p>${event.keyWord }</p>
				<p>点赞数：${event.totalLikeNum }</p>
				<p>评论数：${event.totalCommentNum }</p>
				<p>转发数：${event.totalRepostNum }</p>
			</div>
     	</c:forEach>		

	</div>
	<footer>&copy;2016广东外语外贸大学 智能信息处理研究所 数据挖掘实验室 保留所有权利 关于我们</footer>
	<script src="../public/javascript/carousel.js"></script>
</body>
</html>