<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="../public/lib/jquery-2.1.1.js"></script>   

    <meta charset="utf-8">
	<title> 评论内容</title>
	
	<script type="text/javascript">  
	$(function() {  
		var nid = "${id }";
		
		
	    getComments(nid);  

	});  
	
	String.prototype.replaceAll  = function(s1,s2){     
	    return this.replace(new RegExp(s1,"gm"),s2);     
	} 
	
    function getComments(nid){  
        $.ajax({  
        type:"GET",  //使用GET方法访问后台
        dataType: 'json',  //返回json格式的数据  可选XML ,Json jsonp script html text等
        //cache: false,  
        async: false,
        /*
      	  对于此方法调用之后会一直返回undefined，原因是Jquery的ajax是异步的，所以大多时候没执行完AJAX就return htmlcontent了，所以会一直返回undefined, 
	解决方法：添加async: false,即修改此方法为同步
        */
        url:"${pageContext.request.contextPath }/index/comments.action?id="+nid,  //要访问的后台地址  
        error:function(data){  
            alert("出错了！！:"+data.title);  
        },  
        success:function(data){
        	//alert("success"+data.title);
        	var commentContent = data.comment;
        	commentContent += " <table class=\"table list\"><td>";
        	var strs=commentContent.split("\n"); //字符分割
        	
        	for (i=0;i<strs.length ;i++ ) 
        	{ 
        		strs[i] = strs[i].replaceAll("<br>","");
        		commentContent+=strs[i]+"<br/><br/>";
        	}
        	commentContent+="</td></table>"
        	$("#commentId").html(commentContent) ;  
        	$("#titleId").append( "<h1 class=\"page-title\">"+data.title+"</h1>");
        	$("#titleId").append("<a href='javascript:history.go(-1)'>返回上一页</a>")

        }  
        });  
    }  
</script> 
	
    <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,700' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" type="text/css" href="../public/lib/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" href="../public/lib/font-awesome/css/font-awesome.css">

    <script src="../public/lib/jquery-1.11.1.min.js" type="text/javascript"></script>

    <script src="../public/lib/jQuery-Knob/js/jquery.knob.js" type="text/javascript"></script>

    <link rel="stylesheet" type="text/css" href="../public/stylesheets/theme.css">
    <link rel="stylesheet" type="text/css" href="../public/stylesheets/premium.css">
<body>

<div class="row">
    <div class="col-sm-6 col-md-6" style="width:100%">
        <div class="panel panel-default"> 
         
            <div id="titleId" class="panel-heading no-collapse">
            </div>
            
           	<div id="commentId" style="height:600px; overflow:auto" ></div>
         
        </div>
    </div>
</div>
</body>
</html>