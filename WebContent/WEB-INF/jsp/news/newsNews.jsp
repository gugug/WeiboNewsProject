<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!doctype html>
<html>
<title>新闻列表</title>

<div class="main-content">

	<div>
	显示前三个 <br />
		<c:forEach items="${newsList }" var="news" end="2">
			<a
				href="${pageContext.request.contextPath }/news1/newsNewsDetail.action?nid=${news.newsId }">${news.newsId }</a>
							newsWebId:	   ${news.newsWebId }<br />
							newsWebType:	   ${news.newsWebType }<br />
							newsUrl:	   ${news.newsUrl }<br />
							newsTitle:	   ${news.newsTitle }<br />
							newsContent:	   ${news.newsContent }<br />
							newsDatetime	: ${news.newsDatetime } <br />
							newsSource	: ${news.newsSource } <br />
							newsSourceUrl	: ${news.newsSourceUrl } <br />
							newsImageUrl	: ${news.newsImageUrl } <br />
							newsAuthor	: ${news.newsAuthor } <br />
							newsArgs	: ${news.newsArgs } <br />
			<br />
		</c:forEach>
		
		立场测试<br />
		<c:forEach items="${evaluEvaluList }" var="evaluEvalu">
		evaluationObjectId: ${evaluEvalu.evaluationObjectId }<br />
		evaluationObjectName: ${evaluEvalu.evaluationObjectName }<br />
		pasitiveNum: ${evaluEvalu.pasitiveNum }<br />
		negativeNum: ${evaluEvalu.negativeNum }<br /><br />
		
		</c:forEach>
		
		评论数量<br />
		<c:forEach items="${comNumList }" var="commnum">
		${commnum.name } -- ${commnum.y }<br />
		</c:forEach>
		<br/><br/>
		
		情绪数值<br />
		<c:forEach items="${comNumList }" var="emotion" varStatus="status">
			<a href="${pageContext.request.contextPath }/news1/newsNewsEmoDetail.action?tid=${tid }&emoid=${status.index }">
			emo${status.index }</a>
				: ${emotion.name } --  ${emotion.y } <br />
		</c:forEach>


	</div>
</div>

</html>