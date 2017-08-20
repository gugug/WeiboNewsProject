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

地区: ${queryByIDArea }<br />
年龄: ${queryByIDAge }<br />
性别: ${queryByIDSex }<br />
girl: ${queryByIDSex.girl }<br />


<footer id="footer">
    CopyRight@广东外语外贸大学数据挖掘实验室
</footer>
</body>
</html>