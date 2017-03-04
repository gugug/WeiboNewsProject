<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!doctype html>
<html>
<title>具体新闻列表</title>

<div class="main-content">

	<div>
			<a href="${pageContext.request.contextPath }/news1/newsNewsDetail.action?nid=${news.newsId }">${news.newsId }</a>
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

	</div>
</div>

</html>