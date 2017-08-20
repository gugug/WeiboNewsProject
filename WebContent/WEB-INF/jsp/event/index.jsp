<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!doctype html>
<html>
<title>事件列表</title>

    <script src="../public/lib/jquery-1.11.1.min.js" type="text/javascript"></script>
  	<script type="text/javascript" src="../public/lib/jquery-2.1.1.js"></script>   
  	
<!--     获取事件列表
<script type="text/javascript">  
	$(function() {  
		getEventsList();
	}); 
	
 function getEventsList(){  
        $.ajax({  
        type:"GET",  //使用GET方法访问后台
        dataType: 'json',  //返回json格式的数据  可选XML ,Json jsonp script html text等
        async: false,
        /*
      	  对于此方法调用之后会一直返回undefined，原因是Jquery的ajax是异步的，所以大多时候没执行完AJAX就return htmlcontent了，所以会一直返回undefined, 
	解决方法：添加async: false,即修改此方法为同步
        */
        url:"${pageContext.request.contextPath }/event/showEvent.action",  //要访问的后台地址  
        error:function(data){  
            alert("出错了！！:"+data);  
        },  
        success:function(data){
        	//alert("success"+data.length);
        	var content = "<ul>";
            for(var i=0;i<data.length;i++){      
            	content+="<li><a href=\"${pageContext.request.contextPath}/weibo/weiboMain.action?eid="+data[i].eventId+" \"> "+data[i].eventTitle+"</a>";
            	content+="	关键词	"+data[i].keyWord;
            	content+="	爆发时间	"+data[i].explosionTime;
            	content+="	点赞量	"+data[i].totalLikeNum;
            	content+="	评论量	"+data[i].totalCommentNum;
            	content+="	转发量	"+data[i].totalRepostNum+"</li>";
            }
            content+="</ul>";
            $("#eventsListId").html(content);
        }  
        });  
    }  
</script> -->


<div class="main-content">
<!-- 					<div id="eventsListId" style="height: 280px; overflow: auto">
					</div> -->
					
					<div>
					<c:forEach items="${eventList }" var="event">
					<a href="${pageContext.request.contextPath }/weibo/weiboMain.action?eid=${event.eventId }">${event.eventId }</a>
							标题:	   ${event.eventTitle }<br/>
						  	关键词:	   ${event.keyWord }<br/>
							爆发时间	: ${event.explosionTime } 
							点赞量: 	${event.totalLikeNum }<br/>
					        评论量:      ${event.totalCommentNum }<br/>
					       转发量:   ${event.totalRepostNum } <br/><br/>
     		      </c:forEach>		
										
					</div>
	</div>

</html>