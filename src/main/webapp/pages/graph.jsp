<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>График</title>

    <script src="js/jquery.min.js"></script>
    <script src="js/highcharts.js"></script>

    <script type="text/javascript">
            var chart1;

            $(document).ready(function(){
                chart1 = new Highcharts.Chart({
                    chart: {renderTo: 'speed',  type: 'spline'},
                    title: {text: 'Скорость'},
                    yAxis:[{
             	        title:{text: 'Скорость'}}],
             	    xAxis:[{
                        title:{text: 'Время'}}],
                    plotOptions: {
                        spline: {
                             marker: {
                                  enabled: false
                             }
                        }
                    },
                    series: [{data: ${speed}}]
                });
             });

             var chart2;

                                  $(document).ready(function(){
                                      chart2 = new Highcharts.Chart({
                                          chart: {renderTo: 'fi',  type: 'spline'},
                                          title: {text: 'Угол тангажа'},
                                          yAxis:[{
                                   	        title:{text: 'Угол тангажа'}}],
                                   	    xAxis:[{
                                              title:{text: 'Время'}}],
                                          plotOptions: {
                                              spline: {
                                                   marker: {
                                                        enabled: false
                                                   }
                                              }
                                          },
                                          series: [{data: ${fi}}]
                                      });
                                   });


          var chart3;

                      $(document).ready(function(){
                          chart3 = new Highcharts.Chart({
                              chart: {renderTo: 'tetta',  type: 'spline'},
                              title: {text: 'Тетта'},
                              yAxis:[{
                       	        title:{text: 'Тетта'}}],
                       	    xAxis:[{
                                  title:{text: 'Время'}}],
                              plotOptions: {
                                  spline: {
                                       marker: {
                                            enabled: false
                                       }
                                  }
                              },
                              series: [{data: ${tetta}}]
                          });
                       });


          var chart4;

                                $(document).ready(function(){
                                    chart4 = new Highcharts.Chart({
                                        chart: {renderTo: 'alpha',  type: 'spline'},
                                        title: {text: 'Альфа'},
                                        yAxis:[{
                                 	        title:{text: 'Альфа'}}],
                                 	    xAxis:[{
                                            title:{text: 'Время'}}],
                                        plotOptions: {
                                            spline: {
                                                 marker: {
                                                      enabled: false
                                                 }
                                            }
                                        },
                                        series: [{data: ${alpha}}]
                                    });
                                 });

         var chart5;

                                $(document).ready(function(){
                                    chart5 = new Highcharts.Chart({
                                        chart: {renderTo: 'hight',  type: 'spline'},
                                        title: {text: 'Высота'},
                                        yAxis:[{
                                 	        title:{text: 'Высота'}}],
                                 	    xAxis:[{
                                            title:{text: 'Время'}}],
                                        plotOptions: {
                                            spline: {
                                                 marker: {
                                                      enabled: false
                                                 }
                                            }
                                        },
                                        series: [{data: ${hight}}]
                                    });
                                 });
         </script>

</head>
<body>
    <center>
    <h3><a href="index.html">Home</a></h3>
    <hr>
    <h2>Графики</h2>
    <div id="speed" style="width: 700px; height: 600px; display:inline-block;"></div>
     <div id="fi" style="width: 700px; height: 600px; display:inline-block;"></div>
     <div id="tetta" style="width: 700px; height: 600px; display:inline-block;"></div>
     <div id="alpha" style="width: 700px; height: 600px; display:inline-block;"></div>
     <div id="hight" style="width: 700px; height: 600px; display:inline-block;"></div>
     </center>
</body>
</html>