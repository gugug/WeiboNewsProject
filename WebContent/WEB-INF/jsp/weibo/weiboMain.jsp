<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>YUNSHAN</title>
    <script src="../public/javascript/jquery-3.1.1.min.js"></script>
    <link rel="stylesheet" href="../public/css/main.css" type="text/css"/>
</head>
<body>

<!-- 公用的左边 -->
<%@include file="../publicJsp/weiboPublicLeft.jsp" %>

   <div id="right">
    <div id="banner_tabs" class="flexslider">
        <ul class="slides">
        
        		<c:forEach items="${eventList }" var="event" varStatus="statusIndex">
        		 	<li>
					  <a href="../weibo/weiboNews.action?eid=${event.eventId }">
					  <c:set var="icount" value="${statusIndex.index }" />
					 <img src="../public/images/${imageList[icount] }" >
				  	  <p class="news_name">${event.eventTitle }</p>
				  	  
				 	 </a>
				    </li>
     		      </c:forEach>		
     		      
     		 <li>
                <a href="../weibo/weiboNews.action?eid=1">
                    <img src="../public/images/sky.jpg" >
                    <p class="news_name">更多热点</p>
                </a>
            </li>
            
        </ul>
        
        <div id="event_show">
            <a href="news.html">
                <img src="../public/images/bubble.png" width="100%"></a>
                <div id="event_name">
                    <p id="en">事件</p>
                    <ol id="bannerCtrl" class="flex-control-nav flex-control-paging">
                      
                      <li><a>0</a></li>
                      
                      <c:forEach items="${eventList }" var="event" varStatus="statusIndex">
                      <li><a>${statusIndex.count }</a></li>
                       </c:forEach>
                        
                    </ol>
                                        <p id="start"><a href="../weibo/weiboNews.action?eid=1">START</a></p>
                    
                </div>
        </div>
        
        <ul class="flex-direction-nav">
            <li>
                <a class="flex-prev">Previous</a>
            </li>
            <li>
                <a class="flex-next" >Next</a>
            </li>
        </ul>
        <div id="footer">
            <p>copyright@广东外语外贸大学数据挖掘实验室</p>
        </div>
    </div>
    <script src="../public/javascript/slider.js"></script>
    <script src="../public/javascript/main.js"></script>
</div>
</body>
</html>