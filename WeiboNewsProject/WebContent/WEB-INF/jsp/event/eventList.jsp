<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!doctype html>
<html>

   
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
        url:"${pageContext.request.contextPath }/index/showEvent.action",  //要访问的后台地址  
        error:function(data){  
            alert("出错了！！:"+data);  
        },  
        success:function(data){
        	var content = "<ul>";
        	//alert("success"+data[0].id);
            for(var i=0;i<data.length;i++){      
                // alert(data[i].id+" "+data[i].title);  
                content+="<li><a href=\"${pageContext.request.contextPath}/index/details.action?id="+data[i].eventId +"-------"+data[i].keyWord+"</a></li>";
                
             }
            content+="</ul>";
            $("#eventsListId").html(content);
        }  
        });  
    }  
</script>



<div class="main-content">

	<div class="row">
		<div class="col-sm-6 col-md-6" style="width: 100%">
			<div class="panel panel-default">
				<div class="panel-heading no-collapse">事件列表</div>
				
				${eventInfoList } <br/>
		<c:forEach items="${eventInfoList }" var="event">
		    ${event.eventId }<br/>
   		   ${event.keyWord }<br/>
			${event.totalLikeNum }<br/>
           ${event.totalCommentNum }<br/>
            ${event.totalRepostNum } <br/><br/>
           </c:forEach>		
			</div>
		</div>
	</div>
					<div id="eventsListId" style="height: 280px; overflow: auto"></div>
	
	</div>

</html>