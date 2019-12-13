<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Графики</title>

    <script src="js/jquery.min.js"></script>
    <script src="js/highcharts.js"></script>
    <script src="js/graph.js"></script>

</head>
<body>
    <center>
    <h3><a href="index.html">Home</a></h3>
    <hr>
    <h2>Графики</h2>
     <script type="text/javascript">
        graph('Скорость', 'Время', 'speed', ${speed});
        graph('Угол тангажа', 'Время', 'fi', ${fi});
        graph('Тетта', 'Время', 'tetta', ${tetta});
        graph('Альфа', 'Время', 'alpha', ${alpha});
        graph('Высота', 'Время', 'hight', ${hight});

     </script>
     <div id="speed" style="width: 700px; height: 600px; display:inline-block;"></div>
     <div id="fi" style="width: 700px; height: 600px; display:inline-block;"></div>
     <div id="tetta" style="width: 700px; height: 600px; display:inline-block;"></div>
     <div id="alpha" style="width: 700px; height: 600px; display:inline-block;"></div>
     <div id="hight" style="width: 700px; height: 600px; display:inline-block;"></div>
     </center>
</body>
</html>