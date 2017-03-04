/**
 * Created by Administrator on 2017/2/15 0015.
 */
var myChart = echarts.init(document.getElementById('age'));
// app.title = '坐标轴刻度与标签对齐';
var option = {
    title:{
        text:'读者年龄分布',
        textStyle:{
            color:'#000000',
            fontSize:20,
        },
        textAlign:'left',
    },
    color: ['#3398DB'],
    tooltip : {
        trigger: 'axis',
        axisPointer : {            // 坐标轴指示器，坐标轴触发有效
            type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
        }
    },
    grid: {
        left: '3%',
        right: '4%',
        bottom: '3%',
        containLabel: true
    },
    xAxis : [
        {
            type : 'category',
            data : ['0-15', '16-25', '26-35', '36-45', '46-55', '56-65', '66以上'],
            axisTick: {
                alignWithLabel: true
            }
        }
    ],
    yAxis : [
        {
            type : 'value'
        }
    ],
    series : [
        {
            name:'年龄分布',
            type:'bar',
            barWidth: '60%',
            data:[10, 52, 200, 334, 390, 330, 220]
        }
    ]
};
myChart.setOption(option);