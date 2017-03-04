<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!doctype html>

<html>

	<div class="row">
	
		<div class="panel-heading no-collapse">微博列表</div>
		<c:forEach items="${weiboList }" var="weibo">
         事件id：  ${weibo.eventId }<br/>
          新闻id： ${weibo.newId }<br/>
          微博源： ${weibo.origin }<br/>
           微博内容：${weibo.content }<br/>
            微博发表时间：${weibo.releaseTime }<br/>
            微博点赞数：${weibo.likeNum }<br/>
            微博评论数：${weibo.commentNum }<br/>
            微博转发数：${weibo.repostNum }<br/>
            微博评论路径：${weibo.commentPath }<br/>
            微博用户路径：${weibo.userPath }<br/>
           微博转发路径： ${weibo.repostPath }<br/>
           
           </c:forEach>
		
	</div>
	</html>