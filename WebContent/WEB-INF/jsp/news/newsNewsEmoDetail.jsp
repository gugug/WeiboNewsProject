<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!doctype html>
<html>
<title>具体新闻列表</title>

<div class="main-content">

	<div>
		<c:forEach items="${topCommList }" var="topComm">
							commentId:			${topComm.commentId }<br />
							newsId:	   ${topComm.newsId }<br />
							commentContent:	   ${topComm.commentContent }<br />
							commentDatetime:	   ${topComm.commentDatetime }<br />
							commenGoodNum:	   ${topComm.commenGoodNum }<br />
							emotionId:	   ${topComm.emotionId }<br />
						<br />
			<br />
		</c:forEach>

	</div>
</div>

</html>