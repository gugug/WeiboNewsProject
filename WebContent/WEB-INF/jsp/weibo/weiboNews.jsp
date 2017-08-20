<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>YUNSHAN</title>
    <link rel="stylesheet" href="../public/css/news.css" type="text/css"/>
    <script src="../public/javascript/jquery-3.1.1.min.js"></script>
</head>
<body>

<!-- 公用的左边 -->
<%@include file="../publicJsp/weiboPublicLeft.jsp" %>


<div id="right">
    <div id="ban">
        <div id="pur_org">
            <div id="lpurple"></div>
        </div>
			<%@include file="../publicJsp/weiboPublicRightHeader.jsp" %>
        
        <div id="org_pur">
            <div id="orange"></div>
            <div id="purple"></div>
        </div>
    </div>
    
    
    <div id="content">
            <ul id="content_box">
            
            <c:forEach items="${weiboList }" var="weibo">
                 <li class="content_item">
                    <div class="items">
                        <div class="title">
                            <div class="title_left">
                                <p>标题&nbsp;&nbsp;<b>${weibo.newsTitle }</b></p>
                            </div>
                            <div class="time">
                                <p>时间&nbsp;&nbsp;<b>${weibo.releaseTime }</b></p>
                            </div>
                        </div>
                        <div class="source">
                            <p>来源&nbsp;&nbsp;<b>${weibo.origin }</b></p>
                            <p class="zhengwen">&nbsp;&nbsp;&nbsp;
                            ${weibo.content }
                            </p>
                        </div>
                        <div class="count">
                            <div class="count_left">
                                <ul class="count_left">
                                    <li class="count_img">
                                        <img  src="../public/images/like.png" />${weibo.likeNum }
                                    </li>
                                    <li class="count_img">
                                        <img  src="../public/images/comment.png"/>${weibo.commentNum }
                                    </li>
                                    <li class="count_img">
                                        <img  src="../public/images/forward.png"/>${weibo.repostNum }
                                    </li>
                                </ul>
                            </div>
                            <div class="count_right">
                                <img src="../public/images/more.png">
                            </div>
                        </div>
                    </div>
                </li>
            </c:forEach>
            
            </ul>
    </div>
    <div id="footer">
            <p>©2016广东外语外贸大学 智能信息处理研究所 数据挖掘实验室 保留所有权利 关于我们</p>
    </div>
</div>
</body>
</html>