
$(function(){

    //alert(year);
    //发送ajax请求统计数据
    $.post("loadAddrCount.action",function(data){

        var dom = document.getElementById("tt");

        var myChart = echarts.init(dom);


        var app = {};
       // option = null;
        app.title = '客户地区分布';

        option = {
            backgroundColor: '#2c343c',

            title: {
                text: '客户地区分布图',
                left: 'center',
                top: 20,
                textStyle: {
                    color: '#ccc'
                }
            },

            tooltip : {
                trigger: 'item',
                formatter: "{a} <br/>{b} : {c} ({d}%)"
            },

           /* visualMap: {
                show: false,
                min: 80,
                max: 600,
                inRange: {
                    colorLightness: [0, 1]
                }
            },*/
            series : [
                {
                    name:'客户来源',
                    type:'pie',
                    radius : '55%',
                    center: ['50%', '50%'],
                    data:data,
                    roseType: 'radius',
                    label: {
                        normal: {
                            textStyle: {
                                color: 'rgba(255, 255, 255, 0.3)'
                                    }
                        }
                    },
                    labelLine: {
                        normal: {
                            lineStyle: {
                                color: 'rgba(255, 255, 255, 0.3)'
                            },
                            smooth: 0.2,
                            length: 10,
                            length2: 20
                        }
                    },
                    itemStyle: {
                        normal: {
                            color: function (){ return "#"+("00000"+((Math.random()*16777215+0.5)>>0).toString(16)).slice(-6); },
                            shadowBlur: 200,
                            shadowColor: 'rgba(0, 0, 0, 0.3)'
                        }
                    },

                    animationType: 'scale',
                    animationEasing: 'elasticOut',
                    animationDelay: function (idx) {
                        return Math.random() * 200;
                    }
                }
            ]
        };
        ;
        if (option && typeof option === "object") {
            myChart.setOption(option, true);
        }


    });

})





