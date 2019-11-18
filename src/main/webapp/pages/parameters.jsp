<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="stylesheet" href="css/style.css">
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script src="js/myjs.js"></script>
                <script>
                    $(document).ready(function(){
                      $(".compute").click(function(){
                        $.post("/rocket/parameters",
                        {
                          Vx: $("#Vx").val(),
                          mp: $("#mp").val(),
                          s1: $("#s1").val(),
                          s2: $("#s2").val(),
                          w1: $("#w1").val(),
                          w2: $("#w2").val()
                        },
                        function(data,status){
                          var list = data.split(',');
                          $("#mb1").text(list[0]);
                          $("#mb2").text(list[1]);
                          $("#mt1").text(list[2]);
                          $("#mt2").text(list[3]);
                          $("#mk1").text(list[4]);
                          $("#mk2").text(list[5]);
                          $("#m0").text(list[6]);
                        });
                      });
                    });
                </script>
    <title>График</title>
</head>
<body>
    <center>
        <div class="slider">
            <div class="slide slide1">
                <h2>Выбор основных проектных характеристик</h2>
                <hr><br>
                <img src="rocket.jpg">
            </div>

            <div class="slide slide2">
                <h2>Выбор схемы соединения ракетных блоков</h2>
                <hr><br>
                <form>
                    <input type="radio" id="contactChoice1"
                        name="contact" value="email" checked>
                    <label for="contactChoice1">Последовательное</label>
                    <br>
                     <input type="radio" id="contactChoice2"
                        name="contact" value="phone">
                    <label for="contactChoice2">Параллельное</label>
                </form>
            </div>

            <div class="slide slide3">
                <h2>Оптимизация масс ракетных блоков</h2>
                <hr>
                <form>
                    <h3>Исходные параметры</h3>
                    <table>
                        <tr>
                            <td>Масса полезной нагрузки, т</td>
                            <td id="column"><input type="text" id="mp"></td>
                            <td>Конструктивная характеристика ракетных блоков первой ступени, s1</td>
                            <td id="column"><input type="text" id="s1"></td>
                            <td>Удельный импульс топлива и двигателя РБ первой ступени, м/с</td>
                            <td id="column"><input type="text" id="w1"></td>
                        </tr>
                        <tr>
                            <td>Характеристическая скорость РН, м/с</td>
                            <td id="column"><input type="text" id="Vx"></td>
                            <td>Конструктивная характеристика ракетных блоков второй ступени, s2</td>
                            <td id="column"><input type="text" id="s2"></td>
                            <td>Удельный импульс топлива и двигателя РБ второй ступени, м/с</td>
                            <td id="column"><input type="text" id="w2"></td>
                        </tr>
                    </table>
                </form>
                <br><br>
                <form>
                        <h3>Результаты оптимизации</h3>
                        <table>
                            <tr>
                                <td>Масса РБ первой ступени, т</td>
                                <td id="column"><div id="mb1"></div></td>
                                <td>Масса топлива РБ первой ступени, т</td>
                                <td id="column"><div id="mt1"></div></td>
                                <td>Масса конструкции РБ первой ступени, т</td>
                                <td id="column"><div id="mk1"></div></td>
                            </tr>
                            <tr>
                                <td>Масса РБ второй ступени, м/с</td>
                                <td id="column"><div id="mb2"></div></td>
                                <td>Масса топлива РБ второй ступени, т</td>
                                <td id="column"><div id="mt2"></div></td>
                                <td>Масса конструкции РБ второй ступени, т</td>
                                <td id="column"><div id="mk2"></div></td>
                            </tr>
                            <tr>
                                <td>Стартовая масса РН, т</td>
                                <td id="column"><div id="m0"></div></td>
                            </tr>
                        </table>
                        <br>
                        <a class="button compute" href="#" role="button">Рассчитать</a>
                    </form>
            </div>

            <a class="button slider_control_prev" href="#" role="button">Назад</a>
            <a class="button slider_control_next" href="#" role="button">Далее</a>
        </div>
    </center>
</body>
</html>