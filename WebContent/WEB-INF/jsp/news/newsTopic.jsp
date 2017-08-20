<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!doctype html>
<html>
<title>话题列表</title>

<div class="main-content">

					
					<div>
					<c:forEach items="${topicList }" var="topic">
					<a href="${pageContext.request.contextPath }/news1/newsNews.action?tid=${topic.topicId }">${topic.topicId }</a>
							话题:	   ${topic.topicName }<br/>
							时间	: ${topic.topicDatetime } <br/>
							热度	: ${topic.topicHotWeight } <br/>
							热否	: ${topic.isHot } <br/>
					        摘要:   ${topic.topicSummary } <br/><br/>
     		      </c:forEach>		
     		      
     		      各媒体对应数量:<br />
     		      <c:forEach items="${allWebNum }" var="web">
     		          ${web.name } ---
     		      ${web.y }<br />
     		      </c:forEach>
     		      <br />
     		      各情绪数值:<br />
     		      <c:forEach items="${allCommentNum }" var="comm">
     		      ${comm.name }--- ${comm.y }<br />
     		      </c:forEach>
     		      
     		      <br />
     		      关键词: <br />
     		      
     		    word:   ${keyWordList.wordsList } <br />
     		     weight: ${keyWordList.weightList } <br /><br />
     		      
					</div>
	</div>

</html>