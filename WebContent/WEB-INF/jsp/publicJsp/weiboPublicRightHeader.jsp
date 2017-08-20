<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!doctype html>
<html>
        <div id="gai">
            <p>事件&nbsp;&nbsp;${event.eventTitle }&nbsp;&nbsp;&nbsp;&nbsp;
            爆发时间&nbsp;&nbsp;&nbsp;&nbsp;${event.explosionTime }&nbsp;&nbsp;&nbsp;&nbsp;
            评论量&nbsp;&nbsp;${event.totalCommentNum }&nbsp;&nbsp;&nbsp;&nbsp;
            转发量&nbsp;&nbsp;${event.totalRepostNum }&nbsp;&nbsp;&nbsp;&nbsp;
            点赞量&nbsp;&nbsp;&nbsp;&nbsp;${event.totalLikeNum }</p>
        </div>
</html>