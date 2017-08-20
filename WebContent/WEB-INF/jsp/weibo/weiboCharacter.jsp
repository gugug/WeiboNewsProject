<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>YUNSHAN</title>
    <script src="../public/javascript/echarts.js"></script>
    <script src="../public/javascript/jquery-3.1.1.min.js"></script>
    <link rel="stylesheet" href="../public/css/character.css" type="text/css"/>
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
    <div id="characters">
        <div id="age">
        </div>
        <div id="gender"></div>
        <script src="../public/javascript/age.js"></script>
        <script src="../public/javascript/gender.js"></script>
        <script type="text/javascript">
    	$(function() {  
    		getAgeCharacter("${queryByIDAge.a79 }","${queryByIDAge.a80 }","${queryByIDAge.a90 }","${queryByIDAge.a95 }","${queryByIDAge.anull }");
    		getSexCharacter("${queryByIDSex.girl }","${queryByIDSex.boy }");
    	}); 
        </script>

    </div>
    <div id="footer">
            <p>©2016广东外语外贸大学 智能信息处理研究所 数据挖掘实验室 保留所有权利 关于我们</p>
    </div>
</div>
</body>
</html>


