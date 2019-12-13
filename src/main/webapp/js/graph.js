function graph(yTitle, xTitle, divId, array){
    var chart;
                $(document).ready(function(){
                    chart = new Highcharts.Chart({
                        chart: {renderTo: divId,  type: 'spline'},
                        title: {text: 'График зависимости параметра ' + yTitle + ' от параметра ' + xTitle},
                        yAxis:[{
                 	        title:{text: yTitle}}],
                 	    xAxis:[{
                            title:{text: xTitle}}],
                        plotOptions: {
                            spline: {
                                 marker: {
                                      enabled: false
                                 }
                            }
                        },
                        series: [{data: array,
                                name: yTitle}]
                    });
                 });
}