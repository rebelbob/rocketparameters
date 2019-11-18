<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>График</title>

    <script type="text/javascript">
        <%@include file="js/jquery.min.js"%>
    </script>
    <script type="text/javascript">
            <%@include file="js/highcharts.js"%>
    </script>
    <script type="text/javascript">
            var dat1=${nums};
            var chart1;

            $(document).ready(function(){
                chart1 = new Highcharts.Chart({
                    chart: {renderTo: 'container1',  type: 'spline'},
                    title: {text: 'Какой то график'},
                    yAxis:[{
             	        title:{text: 'Высота'}}],
             	    xAxis:[{
                        title:{text: 'Время'}}],
                    tooltip: {
                                    crosshairs: true,
                                    shared: true
                                },
                                plotOptions: {
                                    spline: {
                                        marker: {
                                            enabled: false
                                        }
                                    }
                                },
                    series: [{data: dat1}]
                });
             });
         </script>
</head>
<body>
    <center>
    <h3><a href="index.html">Home</a></h3>
    <hr>
    <h2>График</h2>

     <div id="container1" style="width: 700px; height: 400px "></div>
     </center>
</body>
</html>