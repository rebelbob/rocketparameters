<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="stylesheet" href="css/style.css">
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script src="js/myjs.js"></script>
                <script>
                    var choice = "posled";

                    $(document).ready(function(){
                      $(".compute").click(function(){
                        $.post("/rocket/parameters",
                        {
                          scheme : choice,
                          Vx: $("#Vx").val(),
                          mp: $("#mp").val(),
                          s1: $("#s1").val(),
                          s2: $("#s2").val(),
                          w1: $("#w1").val(),
                          w2: $("#w2").val(),
                          a: $("#a").val()
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
                          $("#mb3").text(list[7]);
                          $("#mt3").text(list[8]);
                          $("#mk3").text(list[9]);
                        });
                      });
                    });

                    $(document).ready(function(){
                        $("#choice1").click(function(){
                            choice = "posled";
                            $("#aInput").hide();
                            $("#stup3").hide();
                        });
                        $("#choice2").click(function(){
                            choice = "parallbezpereliva";
                            $("#aInput").show();
                            $("#stup3").hide();
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
                    <input type="radio" id="choice1"
                        name="scheme" value="posled" checked>
                    <label for="choice1">Последовательное</label>
                    <br>
                     <input type="radio" id="choice2"
                        name="scheme" value="parallbezpereliva">
                    <label for="choice2">Параллельное без перелива</label>
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
                        <tr id="aInput" hidden="true">
                            <td>Отношение силы тяги</td>
                            <td id="column"><input type="text" id="a"></td>
                        </tr>
                        <tr id="stup3" hidden="true">
                            <td>Конструктивная характеристика ракетных блоков третьей ступени, s3</td>
                            <td id="column"><input type="text" id="s3"></td>
                            <td>Удельный импульс топлива и двигателя РБ третьей ступени, м/с</td>
                            <td id="column"><input type="text" id="w3"></td>
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
                            <tr id="stup3" hidden="true">
                                <td >Масса РБ третьей ступени, м/с</td>
                                <td id="column"><div id="mb3"></div></td>
                                <td>Масса топлива РБ третьей ступени, т</td>
                                <td id="column"><div id="mt3"></div></td>
                                <td>Масса конструкции РБ третьей ступени, т</td>
                                <td id="column"><div id="mk3"></div></td>
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