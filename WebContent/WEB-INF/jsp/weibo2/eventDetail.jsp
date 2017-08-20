<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>YUNSHAN</title>
    <link rel="stylesheet" href="../public/css/weibo_main.css">
    <link rel="stylesheet" href="../public/css/detail.css">
    <link rel="stylesheet" href="../public/css/news.css">
    <link rel="stylesheet" href="../public/css/translation.css">
    <link rel="stylesheet" href="../public/css/characters.css">
    <link rel="stylesheet" href="../public/css/topic.css">
    <script src="../public/javascript/jquery-3.1.1.min.js"></script>
</head>
<body>

	<!-- 共用的头部 -->
	<%@include file="../publicJsp/weibo2PublicHeader.jsp"%>

<div id="main_event" style="background:url(../public/images/lindan.png)">
    <div id="jelly"></div>
    
    
    <div class="event_intro">
    
    	<p>${event.eventTitle }</p>
		<p>${event.explosionTime }</p>
		<p>${event.keyWord }</p>
		
      <!--   <p>林丹出轨</p>
        <p>2016-11-18</p>
        <p>羽球奥运冠军林丹[微博]与神秘女子幽会的消息昨日在网络上流传 而“出轨门的”女主角则是一名娱乐圈内的演员兼模特 昨日上午，网络上惊爆林丹出轨，并附上林丹与一女子在一起，并有亲密动作的照片，认为两人超过了一般朋友的界限, 就在本月5日，林丹还在微博晒出自己和谢杏芳爱子出生的幸福照，两人的孩子是在北京出生,仅过了十多天之后，林丹与陌生女子的暧昧的照片就被曝光,据爆料人称，今年9月中旬一天，林丹与一身材火辣的女子及两位男士出现在北京霄云路，其间该女子自然地挽上了林丹的臂,林丹表示：“作为一个男人我不会为自己做更多的辩解，但是我的行为伤害了我的家人，在这里我向我的家人道歉，对不起</p>
    -->
    </div>
    
    
    <ul>
        <li>
            <img src="../public/images/write.png"/>
            <span>评论量</span>
            <span>${event.totalCommentNum }</span>
        </li>
        <li>
            <img src="../public/images/forward.png"/>
            <span>转发量</span>
            <span>${event.totalRepostNum }</span>
        </li>
        <li>
            <img src="../public/images/like.png"/>
            <span>点赞量</span>
            <span>${event.totalLikeNum }</span>
        </li>
    </ul>
</div>
<div id="detail">
    <section id="news">
        <header>
            <img src="../public/images/news.png"/>
            <span>微博新闻</span>
        </header>
        <ul>
          <c:forEach items="${weiboList }" var="weibo">
          
            <li>
                <table>
                    <tr>
                        <td>
                            <span class="sub_title">标题</span>
                            <span class="sub_content">${weibo.newsTitle }</span>
                        </td>
                        <td>
                            <span class="sub_title">时间</span>
                            <span class="sub_content">${weibo.releaseTime }</span>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <span class="sub_title">来源</span>
                            <span class="sub_content">${weibo.origin }</span>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <p>
								${weibo.content }
                            </p>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <ul>
                                <li>
                                    <img src="../public/images/love.png"/>
                                    <span>${weibo.likeNum }</span>
                                </li>
                                <li>
                                    <img src="../public/images/send_round.png"/>
                                    <span>${weibo.repostNum }</span>
                                </li>
                                <li>
                                    <img src="../public/images/message.png"/>
                                    <span>${weibo.commentNum }</span>
                                </li>
                            </ul>
                        </td>
                    </tr>
                </table>
            </li>
            
            </c:forEach>
        </ul>
    </section>
    
    <section id="translation" style="">
        <header>
            <img src="../public/images/translate.png"/>
            <span>微博传播链</span>
        </header>
        <div id="translate_chain">
            <script src="../public/javascript/d3.v4.min.js"></script>
            <script src="../public/javascript/trans_tree.js"></script>
            <script type="text/javascript">
		    	$(function() {  
		    		//alert("go!");
		    		var jsonUrl = "${weiboTransformPath }";
		    		getTransformTree(jsonUrl);
		    		
		    	}); 
 			 </script> 
        </div>
    </section>
    <section id="user_property">
        <header>
            <img src="../public/images/user.png"/>
            <span>读者基本属性</span>
        </header>
        <div id="characters">
            <div id="age"></div>
            <div id="gender"></div>
        </div>
    </section>
    <section id="map">
        <header>
            <img src="../public/images/location.png"/>
            <span>读者地域分布</span>
        </header>
        <div id="location"></div>
    </section>
    <section id="comment">
        <header>
            <img src="../public/images/topic.png"/>
            <span>评论话题挖掘</span>
        </header>
        <div id="topic">
            <svg id="svg2" width="600" height="570"></svg>
            <script src="https://d3js.org/d3.v4.min.js"></script>
            <script src="../public/javascript/topic.js"></script>
            <script type="text/javascript">
				$(function() {  
					//alert("go!");
					var jsonPath = '${topicJsonPath }';
					//alert(jsonPath);
					getTopic(jsonPath);
				}); 
			</script>
            
            <div id="artical">
                <ul id="sortable">
	                <c:forEach items="${topicList }" var="topic">
                    	<li class="right_text">
		                    <p>${topic } </p>
		                </li>
		            </c:forEach>
                </ul>
            </div>
        </div>
    </section>
</div>
<footer>&copy;2016广东外语外贸大学 智能信息处理研究所 数据挖掘实验室 保留所有权利 关于我们</footer>
</body>
<script src="../public/javascript/echarts.js"></script>
<script src="../public/javascript/china.js"></script>
<script src="../public/javascript/age.js"></script>
<script src="../public/javascript/gender.js"></script>
 <script type="text/javascript">
    	$(function() {  
    		getAgeCharacter("${queryByIDAge.a79 }","${queryByIDAge.a80 }","${queryByIDAge.a90 }","${queryByIDAge.a95 }","${queryByIDAge.anull }");
    		getSexCharacter("${queryByIDSex.girl }","${queryByIDSex.boy }");
    	}); 
</script>
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
        	        	getAreaCharacter(data);
        	        }  
        	     });  
    	}); 
</script>
</html>