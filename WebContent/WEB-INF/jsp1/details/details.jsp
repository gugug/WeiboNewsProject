<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!doctype html>

	<%@include file="../public_jsp/public_header.jsp" %>
        
	<div class="main-content">

            
    <div class="panel panel-default">
        <a href="#page-stats" class="panel-heading" data-toggle="collapse">实体情绪图</a>
  		<div style="height:500px; margin: 0">
       <div id="mention" style="height: 100%"></div>
       <script type="text/javascript" src="../public/lib/echarts.min.js"></script>
       
       <script type="text/javascript">
		var dom = document.getElementById("mention");
		var myChart = echarts.init(dom);
		var app = {};
		/* var dd = [];
		dd = "${list1 }";*/ 
		var entityList = new Array(); 
		var negativeList = new Array(); 
		var pastiveList = new Array(); 
		entityList = "${entityList}".replace('[','').replace(']','').split(','); 
		negativeList = "${negativeList}".replace('[','').replace(']','').split(',');
		pastiveList = "${pastiveList}".replace('[','').replace(']','').split(','); 
		option = null;
		app.title = '正负条形图';
		
		option = {
			tooltip : {
				trigger: 'axis',
				axisPointer : {            // 坐标轴指示器，坐标轴触发有效
					type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
				}
			},
			legend: {
				data:['正向', '负向']
			},
			grid: {
				left: '3%',
				right: '4%',
				bottom: '3%',
				containLabel: true
			},
			xAxis : [
				{
					type : 'value'
				}
			],
			yAxis : [
				{
					type : 'category',
					axisTick : {show: false},
					data:entityList,
					axisLabel : {
						interval:0,
						rotate:30
					}
				}
			],
			series : [
				
					
				{
					name:'正向',
					type:'bar',
					stack: '总量',
					label: {
						normal: {
							
							show: true
						}
					},
					itemStyle:{
					  normal:{color:'#AEEEEE'}
				  	},
			  
					data:pastiveList
				},
				{
					name:'负向',
					type:'bar',
					stack: '总量',
					label: {
						normal: {
							show: true,
							position: 'left'
						}
					},
					itemStyle:{
                  		normal:{color:'#CD5B45'}
              		},
					data:negativeList

				}
			]
		};
	
		if (option && typeof option === "object") {
			myChart.setOption(option, true);
		}
			   </script>

        </div>
    </div>

<div class="row">
    <div class="col-sm-6 col-md-6" style="width:100%">
        <div class="panel panel-default"> 
            <div class="panel-heading no-collapse">
                相关报道列表
            </div>
            
           	<div id="newsListId" style="height:280px; overflow:auto" > </div>
         
        </div>
    </div>
</div>

<%@include file="../public_jsp/public_footer.jsp" %>