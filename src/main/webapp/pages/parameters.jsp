<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="stylesheet" href="css/style.css">
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
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
                    <input type="radio" id="choice1"
                        name="scheme" value="posled" checked>
                    <label for="choice1">Последовательное</label>
                    <br>
                     <input type="radio" id="choice2"
                        name="scheme" value="parallbezpereliva">
                    <label for="choice2">Параллельное без перелива</label>
                    <br>
                    <input type="radio" id="choice3"
                        name="scheme" value="parallspereliv">
                    <label for="choice3">Параллельное с переливом</label>
                    <br>
                    <input type="radio" id="choice4"
                        name="scheme" value="trehstuppaket">
                    <label for="choice4">Трехступенчатый пакет</label>
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
                            <td>Высота орбиты выведения, км</td>
                            <td id="column"><input type="text" id="H"></td>
                            <td>Конструктивная характеристика ракетных блоков второй ступени, s2</td>
                            <td id="column"><input type="text" id="s2"></td>
                            <td>Удельный импульс топлива и двигателя РБ второй ступени, м/с</td>
                            <td id="column"><input type="text" id="w2"></td>
                        </tr>
                        <tr id="stup3req" hidden="true">
                            <td></td>
                            <td></td>
                            <td>Конструктивная характеристика ракетных блоков третьей ступени, s3</td>
                            <td id="column"><input type="text" id="s3" value="6"></td>
                            <td>Удельный импульс топлива и двигателя РБ третьей ступени, м/с</td>
                            <td id="column"><input type="text" id="w3" value="2000"></td>
                        </tr>
                        <tr id="aInput" hidden="true">
                            <td>Отношение силы тяги</td>
                            <td id="column"><input type="text" id="a" value="0.7"></td>
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
                            <tr id="stup3res" hidden="true">
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

            <div class="slide slide4">
                <h2>Проверочный рассчёт</h2>
                <hr><br>
            </div>

            <div class="slide slide5">
                <h2>Графики</h2>
                <hr><br>
                <form>
                                    <h3>Исходные параметры</h3>
                                    <table>
                                        <tr>
                                            <td>Тяга двигателя первой ступени</td>
                                            <td id="column"><input type="text" id="P1" value="2150"></td>
                                            <td>Тяга двигателя второй ступени</td>
                                            <td id="column"><input type="text" id="P2" value="371"></td>
                                            <td>Тяга двигателя третьей ступени</td>
                                            <td id="column"><input type="text" id="P3" value="100"></td>
                                        </tr>
                                        <tr>
                                            <td>Время работы первой ступени</td>
                                            <td id="column"><input type="text" id="t1" value="116"></td>
                                            <td>Время работы второй ступени</td>
                                            <td id="column"><input type="text" id="t2" value="105"></td>
                                            <td>Время работы третьей ступени</td>
                                            <td id="column"><input type="text" id="t3" value="90"></td>
                                        </tr>
                                        <tr>
                                            <td>Диаметр первой ступени</td>
                                            <td id="column"><input type="text" id="D1" value="2.6"></td>
                                            <td>Диаметр второй ступени</td>
                                            <td id="column"><input type="text" id="D2" value="2.2"></td>
                                            <td>Диаметр третьей ступени</td>
                                            <td id="column"><input type="text" id="D3" value="1.4"></td>
                                        </tr>
                                        <tr>
                                            <td>Конечный угол первой ступени</td>
                                            <td id="column"><input type="text" id="fi1" value="40"></td>
                                            <td>Конечный угол второй ступени</td>
                                            <td id="column"><input type="text" id="fi2" value="10"></td>
                                            <td>Конечный угол третьей ступени</td>
                                            <td id="column"><input type="text" id="fi3" value="0"></td>
                                        </tr>
                                        <tr>
                                            <td>Угол полураствора корпуса</td>
                                            <td id="column"><input type="text" id="betta" value="19"></td>
                                        </tr>
                                    </table>
                                    <br>
                                    <a class="button graph" href="#" role="button">Построить</a>
                                </form>
            </div>

            <a class="button slider_control_prev" href="#" role="button">Назад</a>
            <a class="button slider_control_next" href="#" role="button">Далее</a>
        </div>
    </center>
</body>
</html>