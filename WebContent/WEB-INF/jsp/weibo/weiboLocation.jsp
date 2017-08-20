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
    <script src="../public/javascript/china.js"></script>
    <script src="../public/javascript/jquery-3.1.1.min.js"></script>
    <link rel="stylesheet" href="../public/css/location.css" type="text/css"/>
</head>
<body>
<!-- 公用的左边 -->
<%@include file="../publicJsp/weiboPublicLeft.jsp" %>
<div id="right">
    <div id="ban">
        <div id="pur_org">
            <div id="lpurple"></div>
        </div>
   <!--      <div id="gai">
            <p>事件&nbsp;&nbsp;林丹出轨&nbsp;&nbsp;&nbsp;&nbsp;爆发时间&nbsp;&nbsp;&nbsp;&nbsp;2016-11-01&nbsp;&nbsp;&nbsp;&nbsp;评论量&nbsp;&nbsp;100000&nbsp;&nbsp;&nbsp;&nbsp;转发量&nbsp;&nbsp;100000&nbsp;&nbsp;&nbsp;&nbsp;点赞量&nbsp;&nbsp;&nbsp;&nbsp;100000</p>
        </div> -->
           <!-- --右边的上部 -->
			<%@include file="../publicJsp/weiboPublicRightHeader.jsp" %>
        <div id="org_pur">
            <div id="orange"></div>
            <div id="purple"></div>
        </div>
    </div>
    <div id="location">
        <script src="../public/javascript/location.js"></script>
                
        <script type="text/javascript">
        $(function() {  
        	var eid = "${eid }";
        	
        	   $.ajax({  
        	        type:"GET", 
        	        dataType: 'json',  
        	        async: false,
        	        url:"${pageContext.request.contextPath }/weibo/weiboLocation.action?eid="+eid,  //要访问的后台地址  
        	        error:function(data){  
        	            alert("对应事件没有地域分布");  
        	        },  
        	        success:function(data){
        	        	//alert(data[0].name);
        	        	getAreaCharacter(data);
        	        }  
        	        });  
    	}); 
        
        </script>
        
    </div>
    <div id="footer">
        <p>copyright@广东外语外贸大学数据挖掘实验室</p>
    </div>
</div>
</body>
</html>
