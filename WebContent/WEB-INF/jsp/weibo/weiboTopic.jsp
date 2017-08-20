<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>YUNSHAN</title>
    <link rel="stylesheet" href="../public/css/topic.css" type="text/css"/>
</head>
<body>

<!-- 公用的左边 -->
<%@include file="../publicJsp/weiboPublicLeft.jsp" %>

<div id="right">
    <div id="ban">
        <div id="pur_org">
            <div id="lpurple"></div>
        </div>
           <!-- --右边的上部 -->
			<%@include file="../publicJsp/weiboPublicRightHeader.jsp" %>
			
        <div id="org_pur">
            <div id="orange"></div>
            <div id="purple"></div>
        </div>
    </div>
    <div id="topic">
        <svg width="600" height="600"></svg>
        <div id="artical">
            <ul id="sortable">
            <c:forEach items="${topicList }" var="topic">
              <li class="right_text">
                    <p>${topic } </p>
                </li>
                <br />
            </c:forEach>
            
            </ul>
        </div>
    </div>
    <div id="footer">
        <p>copyright@广东外语外贸大学数据挖掘实验室</p>
    </div>
</div>
<script src="../public/javascript/jquery-3.1.1.min.js"></script>
<script src="../public/javascript/d3.v4.min.js"></script>
<script src="../public/javascript/topic.js"></script>
<script type="text/javascript">
$(function() {  
	//alert("go!");
	var jsonPath = '${topicJsonPath }';
	//alert(jsonPath);
	getTopic(jsonPath);
}); 
</script>
</body>
</html>
