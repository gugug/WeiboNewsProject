<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html lang="en" style="height: 100%"><head>
    <meta charset="utf-8">
    <title>数据挖掘作业展示</title>
    <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,700' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" type="text/css" href="../public/lib/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" href="../public/lib/font-awesome/css/font-awesome.css">

    <script src="../public/lib/jquery-1.11.1.min.js" type="text/javascript"></script>
  	<script type="text/javascript" src="../public/lib/jquery-2.1.1.js"></script>   

    <script src="../public/lib/jQuery-Knob/js/jquery.knob.js" type="text/javascript"></script>
    <script type="text/javascript">
        $(function() {
            $(".knob").knob();
        });
    </script>
    
   


    <link rel="stylesheet" type="text/css" href="../public/stylesheets/theme.css">
    <link rel="stylesheet" type="text/css" href="../public/stylesheets/premium.css">

</head>
<body class=" theme-blue">
       <div id="container" style="height: 100%"></div>

    <!-- Demo page code -->

    <script type="text/javascript">
        $(function() {
            var match = document.cookie.match(new RegExp('color=([^;]+)'));
            if(match) var color = match[1];
            if(color) {
                $('body').removeClass(function (index, css) {
                    return (css.match (/\btheme-\S+/g) || []).join(' ')
                })
                $('body').addClass('theme-' + color);
            }

            $('[data-popover="true"]').popover({html: true});
            
        });
    </script>
    <style type="text/css">
        #line-chart {
            height:300px;
            width:800px;
            margin: 0px auto;
            margin-top: 1em;
        }
        .navbar-default .navbar-brand, .navbar-default .navbar-brand:hover { 
            color: #fff;
        }
    </style>

	<style type="text/css">
	.FGH {
	 height:auto !important;
	 height:344px;
	 min-height:344px;
	 }
	</style>

    <script type="text/javascript">
        $(function() {
            var uls = $('.sidebar-nav > ul > *').clone();
            uls.addClass('visible-xs');
            $('#main-menu').append(uls.clone());
        });
    </script>
    
    <!-- 获取事件列表 -->
<script type="text/javascript">  
	$(function() {  
		getEventsList();
	}); 
	
 function getEventsList(){  
        $.ajax({  
        type:"GET",  //使用GET方法访问后台
        dataType: 'json',  //返回json格式的数据  可选XML ,Json jsonp script html text等
        //cache: false,  
        async: false,
        /*
      	  对于此方法调用之后会一直返回undefined，原因是Jquery的ajax是异步的，所以大多时候没执行完AJAX就return htmlcontent了，所以会一直返回undefined, 
	解决方法：添加async: false,即修改此方法为同步
        */
        url:"${pageContext.request.contextPath }/index/showEventsList.action",  //要访问的后台地址  
        error:function(data){  
            alert("出错了！！:"+data);  
        },  
        success:function(data){
        	var content = "<ul>";
        	//alert("success"+data[0].id);
            for(var i=0;i<data.length;i++){      
                // alert(data[i].id+" "+data[i].title);  
                content+="<li><a href=\"${pageContext.request.contextPath}/index/details.action?id="+data[i].id+"\" data-target=\".dashboard-menu\" class=\"nav-header\" data-toggle=\"collapse\"><i class=\"fa fa-fw fa-dashboard\"></i> "+data[i].title+"</a></li>";
                
             }
            content+="</ul>";
            $("#eventsListId").html(content);
            
        }  
        });  
    }  
</script>

    <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

    <!-- Le fav and touch icons -->
    <link rel="shortcut icon" href="../assets/ico/favicon.ico">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="../assets/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="../assets/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="../assets/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="../assets/ico/apple-touch-icon-57-precomposed.png">
  

  <!--[if lt IE 7 ]> <body class="ie ie6"> <![endif]-->
  <!--[if IE 7 ]> <body class="ie ie7 "> <![endif]-->
  <!--[if IE 8 ]> <body class="ie ie8 "> <![endif]-->
  <!--[if IE 9 ]> <body class="ie ie9 "> <![endif]-->
  <!--[if (gt IE 9)|!(IE)]><!--> 
   
  <!--<![endif]-->

    <div class="navbar navbar-default" role="navigation" style="color:#000">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
      </div>
    </div>
    
    	<!-- 左边事件的列表 -->
    <div id="eventsListId" class="sidebar-nav" style="height:200%; overflow:auto;"></div>
    
    
    <div class="content">
    	<!-- 右边上半部分 -->
        <div id="eventHeaderId" class="header">
 			<h1 class="page-title">${firstEvent.title }</h1>
                    
        </div>
        
  	<!-- 获取新闻的列表 -->
  <script type="application/javascript">
   $(function() {  
	    var eid = "${eventId }";
		getNewsList(eid);
	}); 
	
	function getNewsList(eid){  
       $.ajax({  
       type:"GET",  //使用GET方法访问后台
       dataType: 'json',  //返回json格式的数据  可选XML ,Json jsonp script html text等
       //cache: false,
       async: false,
       /*
     	  对于此方法调用之后会一直返回undefined，原因是Jquery的ajax是异步的，所以大多时候没执行完AJAX就return htmlcontent了，所以会一直返回undefined, 
	解决方法：添加async: false,即修改此方法为同步
       */
       url:"${pageContext.request.contextPath }/index/showNewsList.action?id="+eid,  //要访问的后台地址  
       error:function(data){  
           alert("出错了！！:"+data);  
       },  
       success:function(data){
       	//alert("success"+data[0].id);
       	var content = "  <table class=\"table list\">";
       	for(var i=0;i<data.length;i++){   
       		
       		content+="<tr><td>";
       		content+=" <a href=\"${pageContext.request.contextPath}/index/showComments.action?id="+data[i].id+"\"><p class=\"title\">"+data[i].title+"</p></a>";
       		content+="<p class=\"info\">"+data[i].news+"</p>";
       		content+="</td></tr>";
         }
       	content+="</table>";
       	$("#newsListId").html(content);
       	$("#eventHeaderId").append("<li>报道量"+data.length+"</li>");

       }  
       });  
   }  
	</script>