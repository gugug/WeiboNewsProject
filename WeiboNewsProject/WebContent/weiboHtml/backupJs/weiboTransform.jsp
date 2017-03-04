<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>YUNSHAN</title>
    <script src="../public/javascript/navigation.js"></script>
    <link rel="stylesheet" href="../public/css/transform.css" type="text/css"/>
</head>
<body>

<div id="right">
    <div id="ban">
        <div id="pur_org">
            <div id="lpurple"></div>
        </div>
	     <!-- --右边的上部 -->
  
        <div id="org_pur">
            <div id="orange"></div>
            <div id="purple"></div>
        </div>
    </div>
    <div id="transform_diagram"></div>
    <div id="footer">
        <p>copyright@广东外语外贸大学数据挖掘实验室</p>
    </div>
</div>
<script src="../public/javascript/echarts.js"></script>
<script src="../public/javascript/jquery-3.1.1.min.js"></script>
<script src="../public/javascript/transformer.js"></script>
   <script type="text/javascript">
    	$(function() {  
    		alert("go!");
    		getTransform('../public/data/product1.json');
    	}); 
    </script>
	

</body>
</html>

  
        


