/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2019-12-20 11:52:41 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class parameters_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/style.css\">\n");
      out.write("    <script src=\"http://code.jquery.com/jquery-latest.min.js\"></script>\n");
      out.write("    <script src=\"js/myjs.js\"></script>\n");
      out.write("    <title>График</title>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <center>\n");
      out.write("        <div class=\"slider\">\n");
      out.write("            <div class=\"slide slide1\">\n");
      out.write("                <h2>Выбор основных проектных характеристик</h2>\n");
      out.write("                <hr><br>\n");
      out.write("                <img src=\"rocket.jpg\">\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div class=\"slide slide2\">\n");
      out.write("                <h2>Выбор схемы соединения ракетных блоков</h2>\n");
      out.write("                <hr><br>\n");
      out.write("                <form>\n");
      out.write("                    <input type=\"radio\" id=\"choice1\"\n");
      out.write("                        name=\"scheme\" value=\"posled\" checked>\n");
      out.write("                    <label for=\"choice1\">Последовательное</label>\n");
      out.write("                    <br>\n");
      out.write("                     <input type=\"radio\" id=\"choice2\"\n");
      out.write("                        name=\"scheme\" value=\"parallbezpereliva\">\n");
      out.write("                    <label for=\"choice2\">Параллельное без перелива</label>\n");
      out.write("                    <br>\n");
      out.write("                    <input type=\"radio\" id=\"choice3\"\n");
      out.write("                        name=\"scheme\" value=\"parallspereliv\">\n");
      out.write("                    <label for=\"choice3\">Параллельное с переливом</label>\n");
      out.write("                    <br>\n");
      out.write("                    <input type=\"radio\" id=\"choice4\"\n");
      out.write("                        name=\"scheme\" value=\"trehstuppaket\">\n");
      out.write("                    <label for=\"choice4\">Трехступенчатый пакет</label>\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div class=\"slide slide3\">\n");
      out.write("                <h2>Оптимизация масс ракетных блоков</h2>\n");
      out.write("                <hr>\n");
      out.write("                <form>\n");
      out.write("                    <h3>Исходные параметры</h3>\n");
      out.write("                    <table>\n");
      out.write("                        <tr>\n");
      out.write("                            <td>Масса полезной нагрузки, т</td>\n");
      out.write("                            <td id=\"column\"><input type=\"text\" id=\"mp\"></td>\n");
      out.write("                            <td>Конструктивная характеристика ракетных блоков первой ступени, s1</td>\n");
      out.write("                            <td id=\"column\"><input type=\"text\" id=\"s1\"></td>\n");
      out.write("                            <td>Удельный импульс топлива и двигателя РБ первой ступени, м/с</td>\n");
      out.write("                            <td id=\"column\"><input type=\"text\" id=\"w1\"></td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td>Высота орбиты выведения, км</td>\n");
      out.write("                            <td id=\"column\"><input type=\"text\" id=\"H\"></td>\n");
      out.write("                            <td>Конструктивная характеристика ракетных блоков второй ступени, s2</td>\n");
      out.write("                            <td id=\"column\"><input type=\"text\" id=\"s2\"></td>\n");
      out.write("                            <td>Удельный импульс топлива и двигателя РБ второй ступени, м/с</td>\n");
      out.write("                            <td id=\"column\"><input type=\"text\" id=\"w2\"></td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr id=\"stup3req\" hidden=\"true\">\n");
      out.write("                            <td></td>\n");
      out.write("                            <td></td>\n");
      out.write("                            <td>Конструктивная характеристика ракетных блоков третьей ступени, s3</td>\n");
      out.write("                            <td id=\"column\"><input type=\"text\" id=\"s3\" value=\"6\"></td>\n");
      out.write("                            <td>Удельный импульс топлива и двигателя РБ третьей ступени, м/с</td>\n");
      out.write("                            <td id=\"column\"><input type=\"text\" id=\"w3\" value=\"2000\"></td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr id=\"aInput\" hidden=\"true\">\n");
      out.write("                            <td>Отношение силы тяги</td>\n");
      out.write("                            <td id=\"column\"><input type=\"text\" id=\"a\" value=\"0.7\"></td>\n");
      out.write("                        </tr>\n");
      out.write("                    </table>\n");
      out.write("                </form>\n");
      out.write("                <br><br>\n");
      out.write("                <form>\n");
      out.write("                        <h3>Результаты оптимизации</h3>\n");
      out.write("                        <table>\n");
      out.write("                            <tr>\n");
      out.write("                                <td>Масса РБ первой ступени, т</td>\n");
      out.write("                                <td id=\"column\"><div id=\"mb1\"></div></td>\n");
      out.write("                                <td>Масса топлива РБ первой ступени, т</td>\n");
      out.write("                                <td id=\"column\"><div id=\"mt1\"></div></td>\n");
      out.write("                                <td>Масса конструкции РБ первой ступени, т</td>\n");
      out.write("                                <td id=\"column\"><div id=\"mk1\"></div></td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td>Масса РБ второй ступени, м/с</td>\n");
      out.write("                                <td id=\"column\"><div id=\"mb2\"></div></td>\n");
      out.write("                                <td>Масса топлива РБ второй ступени, т</td>\n");
      out.write("                                <td id=\"column\"><div id=\"mt2\"></div></td>\n");
      out.write("                                <td>Масса конструкции РБ второй ступени, т</td>\n");
      out.write("                                <td id=\"column\"><div id=\"mk2\"></div></td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr id=\"stup3res\" hidden=\"true\">\n");
      out.write("                                <td >Масса РБ третьей ступени, м/с</td>\n");
      out.write("                                <td id=\"column\"><div id=\"mb3\"></div></td>\n");
      out.write("                                <td>Масса топлива РБ третьей ступени, т</td>\n");
      out.write("                                <td id=\"column\"><div id=\"mt3\"></div></td>\n");
      out.write("                                <td>Масса конструкции РБ третьей ступени, т</td>\n");
      out.write("                                <td id=\"column\"><div id=\"mk3\"></div></td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td>Стартовая масса РН, т</td>\n");
      out.write("                                <td id=\"column\"><div id=\"m0\"></div></td>\n");
      out.write("                            </tr>\n");
      out.write("                        </table>\n");
      out.write("                        <br>\n");
      out.write("                        <a class=\"button compute\" href=\"#\" role=\"button\">Рассчитать</a>\n");
      out.write("                    </form>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div class=\"slide slide4\">\n");
      out.write("                <h2>Проверочный рассчёт</h2>\n");
      out.write("                <hr><br>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div class=\"slide slide5\">\n");
      out.write("                <h2>Графики</h2>\n");
      out.write("                <hr><br>\n");
      out.write("                <form>\n");
      out.write("                                    <h3>Исходные параметры</h3>\n");
      out.write("                                    <table>\n");
      out.write("                                        <tr>\n");
      out.write("                                            <td>Тяга двигателя первой ступени</td>\n");
      out.write("                                            <td id=\"column\"><input type=\"text\" id=\"P1\" value=\"2150\"></td>\n");
      out.write("                                            <td>Тяга двигателя второй ступени</td>\n");
      out.write("                                            <td id=\"column\"><input type=\"text\" id=\"P2\" value=\"371\"></td>\n");
      out.write("                                            <td>Тяга двигателя третьей ступени</td>\n");
      out.write("                                            <td id=\"column\"><input type=\"text\" id=\"P3\" value=\"100\"></td>\n");
      out.write("                                        </tr>\n");
      out.write("                                        <tr>\n");
      out.write("                                            <td>Время работы первой ступени</td>\n");
      out.write("                                            <td id=\"column\"><input type=\"text\" id=\"t1\" value=\"116\"></td>\n");
      out.write("                                            <td>Время работы второй ступени</td>\n");
      out.write("                                            <td id=\"column\"><input type=\"text\" id=\"t2\" value=\"105\"></td>\n");
      out.write("                                            <td>Время работы третьей ступени</td>\n");
      out.write("                                            <td id=\"column\"><input type=\"text\" id=\"t3\" value=\"90\"></td>\n");
      out.write("                                        </tr>\n");
      out.write("                                        <tr>\n");
      out.write("                                            <td>Диаметр первой ступени</td>\n");
      out.write("                                            <td id=\"column\"><input type=\"text\" id=\"D1\" value=\"2.6\"></td>\n");
      out.write("                                            <td>Диаметр второй ступени</td>\n");
      out.write("                                            <td id=\"column\"><input type=\"text\" id=\"D2\" value=\"2.2\"></td>\n");
      out.write("                                            <td>Диаметр третьей ступени</td>\n");
      out.write("                                            <td id=\"column\"><input type=\"text\" id=\"D3\" value=\"1.4\"></td>\n");
      out.write("                                        </tr>\n");
      out.write("                                        <tr>\n");
      out.write("                                            <td>Конечный угол первой ступени</td>\n");
      out.write("                                            <td id=\"column\"><input type=\"text\" id=\"fi1\" value=\"40\"></td>\n");
      out.write("                                            <td>Конечный угол второй ступени</td>\n");
      out.write("                                            <td id=\"column\"><input type=\"text\" id=\"fi2\" value=\"10\"></td>\n");
      out.write("                                            <td>Конечный угол третьей ступени</td>\n");
      out.write("                                            <td id=\"column\"><input type=\"text\" id=\"fi3\" value=\"0\"></td>\n");
      out.write("                                        </tr>\n");
      out.write("                                        <tr>\n");
      out.write("                                            <td>Угол полураствора корпуса</td>\n");
      out.write("                                            <td id=\"column\"><input type=\"text\" id=\"betta\" value=\"19\"></td>\n");
      out.write("                                        </tr>\n");
      out.write("                                    </table>\n");
      out.write("                                    <br>\n");
      out.write("                                    <a class=\"button graph\" href=\"#\" role=\"button\">Построить</a>\n");
      out.write("                                </form>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <a class=\"button slider_control_prev\" href=\"#\" role=\"button\">Назад</a>\n");
      out.write("            <a class=\"button slider_control_next\" href=\"#\" role=\"button\">Далее</a>\n");
      out.write("        </div>\n");
      out.write("    </center>\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
