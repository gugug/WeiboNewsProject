<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!doctype html>
<html>
<title>事件列表</title>

<div class="main-content">

					
					<div>
					<c:forEach items="${eventList }" var="event">
					<a href="${pageContext.request.contextPath }/news1/newsTopic.action?eid=${event.eventId }">${event.eventId }</a>
							事件:	   ${event.eventName }<br/>
							类型:	   ${event.generalName }<br/>
							爆发时间	: ${event.eventDatetime } <br/>
					       摘要:   ${event.eventSummary } <br/><br/>
     		      </c:forEach>		
										
					</div>
	</div>

</html>