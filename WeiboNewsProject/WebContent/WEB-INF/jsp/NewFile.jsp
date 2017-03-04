<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

 <!-- 获取事件 -->
<script type="text/javascript">  
	$(function() {  
		var eid = "${eventId }";
		//alert(eid);
		getEventsList(eid);
		getWeiboList(eid);
	}); 
	
 function getEventsList(eid){  
        $.ajax({  
        type:"GET", 
        dataType: 'json',  
        async: false,
        url:"${pageContext.request.contextPath }/event/showEventByEid.action?eid="+eid,  //要访问的后台地址  
        error:function(data){  
            alert("出错了！！:"+data);  
        },  
        success:function(data){
        	var content = "<ul>";
        	content+= "<li>事件:"+data.eventTitle+"</li>";
        	content+= "<li>关键词:"+data.keyWord+"</li>";
        	content+= "<li>爆发时间:"+data.explosionTime+"</li>";
        	content+= "<li>点赞量:"+data.totalLikeNum+"</li>";
        	content+= "<li>评论量:"+data.totalCommentNum+"</li>";
        	content+= "<li>转发量:"+data.totalRepostNum+"</li> </ul>";
            $("#news_intro").html(content);
        }  
        });  
    }  

 function getWeiboList(eid){  
        $.ajax({  
        type:"GET", 
        dataType: 'json',  
        async: false,
        url:"${pageContext.request.contextPath }/weibo/showWeiboByEid.action?eid="+eid,  //要访问的后台地址  
        error:function(data){  
            alert("出错了！！:"+data);  
        },  
        success:function(data){
        	var content = "";
        	for(var i=0;i<data.length;i++){    
        		content+="<ul class=\"news\"> <li>   <div class=\"subtitle\"><ul><li class=\"lt\">新闻标题："+data[i].newsTitle+"</li>";	
        		content+=" <li class=\"rt\"> 发表源："+data[i].origin;
        		content+="<li class=\"rst\"> 发表时间："+data[i].releaseTime+"</li></ul></div>";
        		content+=" <div class=\"content\"> 新闻正文："+data[i].content;
        		content+="<a href=\"http://www.baidu.com\">More</a></div>"
        		content+="<div class=\"statistics\"><ul >"
        		content+= "<li>点赞量:"+data[i].likeNum+"</li>";
            	content+= "<li>评论量:"+data[i].commentNum+"</li>";
            	content+= "<li>转发量:"+data[i].repostNum+"</li> </ul></div></li></ul>";     
            	}
        	
            $("#detail").html(content);
        }  
        });  
    }  
</script>

</body>
</html>