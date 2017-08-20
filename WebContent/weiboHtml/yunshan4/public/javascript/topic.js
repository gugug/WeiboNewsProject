/**
 * Created by Administrator on 2017/2/14 0014.
 */
var myChart=echarts.init(document.getElementById('topic'));
myChart.showLoading();
$.get('../public/data/les-miserables.gexf', function (xml) {
    myChart.hideLoading();
    var graph = echarts.dataTool.gexf.parse(xml);
    var categories = [];
    for (var i = 0; i < 9; i++) {
        categories[i] = {
            name: '类目' + i
        };
    }
    graph.nodes.forEach(function (node) {
        node.itemStyle = null;
        node.value = node.symbolSize;
        node.symbolSize /= 1.5;
        node.label = {
            normal: {
                show: node.symbolSize > 10
            }
        };
        node.category = node.attributes.modularity_class;
    });
    var option = {
        title: {
            top: 'bottom',
            left: 'center'
        },
        tooltip: {},
        legend: [{
            orient:'vertical',
            x:'right',
            y:'bottom',
            padding:8,
            itemGap:20,
            textStyle:{
                fontSize:15,
                fontWeight:'bold'
            },
            data: categories.map(function (a) {
                return a.name;
            })
        }],
        animationDurationUpdate: 1500,
        animationEasingUpdate: 'quinticInOut',
        series : [
            {
                name: 'Les Miserables',
                type: 'graph',
                layout: 'circular',
                circular: {
                    rotateLabel: true
                },
                data: graph.nodes,
                links: graph.links,
                categories: categories,
                roam: true,
                label: {
                    normal: {
                        position: 'right',
                        formatter: '{b}'
                    }
                },
                lineStyle: {
                    normal: {
                        color: 'source',
                        curveness: 0.3
                    }
                }
            }
        ]
    };

    myChart.setOption(option);
}, 'xml');