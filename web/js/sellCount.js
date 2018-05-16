function demoEcharts(title,id){
		
		var year=title.substr(0,4);
		//alert(year);
		//发送ajax请求统计数据
		$.post("loadSellData.action","year="+year,function(result){
			
			var dom = document.getElementById(id);

			var myChart = echarts.init(dom);
			var app = {};
			option = null;
			app.title = '年对应的月销售额';
			
			option = {
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
			            data :result.xaxis,
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
			            name:'销售额',
			            type:'bar',
			            barWidth: '60%',
			            data:result.yayis
			        }
			    ]
			};
			;
			if (option && typeof option === "object") {
			    myChart.setOption(option, true);
			}
			
			
		});
	}
	
	
$(function(){
	
	var title =$('#tt').tabs('getTab',0).panel('options').title
    //alert(tab);
	title=title.substr(0,4);

	demoEcharts(title,0);
	//给选项卡绑定onSelect事件
	$('#tt').tabs({onSelect:function(title,index){
		
		//alert(title+"        "+index);
		demoEcharts(title,index)
	}})
	
})