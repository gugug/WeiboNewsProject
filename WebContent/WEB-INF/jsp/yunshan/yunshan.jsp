<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="content-type" content="text/html" charset="utf-8"/>
    <title>云山舆情</title>
    <link rel="stylesheet" href="../public/css/yunshan.css" type="text/css"/>
    <script src="../public/lib/jquery-1.11.1.min.js" type="text/javascript"></script>
  	<script type="text/javascript" src="../public/lib/jquery-2.1.1.js"></script>   
    
</head>

<body>
<div id="top_logo">云山舆情</div>
<div id="main_body">
    <div id="menu">
        <ul>
            <li class="on">微博平台分析</li>
            <li>微博新闻</li>
            <li>微博传播链</li>
            <li>阅读观众基本属性</li>
            <li>阅读观众地域分布</li>
            <li>评论话题挖掘</li>
        </ul>
    </div>
    <div id="analyse">  

        <div id="news_intro">
             <ul>
                <li>事件：${eventByEid.eventTitle }</li>
                <li>爆发时间：${eventByEid.explosionTime }</li>
<%--                 <li>关键词：${eventByEid.keyWord }</li>
 --%>                <li>点赞量：${eventByEid.totalLikeNum }</li>
                <li>评论量：${eventByEid.totalCommentNum }</li>
                <li>转发量：${eventByEid.totalRepostNum }</li>
                <li>
                 <a href="../event/showStatistics.action?eid=${eventId }">查看统计结果</a>
                 </li>
            </ul> 
        </div>
        
        <div id="detail">
		<c:forEach items="${weiboList }" var="weibo">
           
            <ul class="news">
                <div class="news">
                <li>
                    <div class="subtitle">
                        <ul>
                            <li class="lt">新闻标题：${weibo.newsTitle }</li>
                            <li class="rt">发表源：${weibo.origin }</li>
                            <li class="rst">发表时间：${weibo.releaseTime }</li>
                        </ul>
                    </div>
                    <div class="content">
                        新闻正文：${weibo.content }
                        <a href="http://www.baidu.com">More</a>
                    </div>
                    <div class="statistics">
                        <ul >
                            <li>点赞量：${weibo.likeNum }</li>
                            <li>评论量：${weibo.commentNum }</li>
                            <li>转发量：${weibo.repostNum }</li>
                        </ul>
                    </div>
                </li>
                </div>
            </ul> 
                </c:forEach>
          
        </div>
    </div>

</div>
<footer id="footer">
    CopyRight@广东外语外贸大学数据挖掘实验室
</footer>
</body>
</html>