<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="stylesheet" href="css/style.css">
    <script src="js/jquery.min.js"></script>
    <script src="js/myjs.js"></script>
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
                            <td>Характеристическая скорость РН, м/с</td>
                            <td id="column"><input type="text" id="Vx"></td>
                            <td>Конструктивная характеристика ракетных блоков первой ступени, s1</td>
                            <td id="column"><input type="text" id="s1"></td>
                        </tr>
                        <tr>
                            <td>Конструктивная характеристика ракетных блоков второй ступени, s2</td>
                            <td id="column"><input type="text" id="s2"></td>
                            <td>Удельный импульс топлива и двигателя РБ первой ступени, м/с</td>
                            <td id="column"><input type="text" id="w1"></td>
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
                                <td id="column"></td>
                                <td>Масса РБ второй ступени, м/с</td>
                                <td id="column"><div id="bly"></div></td>
                                <td>Масса топлива РБ первой ступени, т</td>
                                <td id="column"><input type="text"></td>
                            </tr>
                            <tr>
                                <td>Масса топлива РБ второй ступени, т</td>
                                <td id="column"><input type="text"></td>
                                <td>Масса конструкции РБ первой ступени, т</td>
                                <td id="column"><input type="text"></td>
                                <td>Масса конструкции РБ второй ступени, т</td>
                                <td id="column"><input type="text"></td>
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