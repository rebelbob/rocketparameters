package ru.aerocos.rocketparam.web;

import ru.aerocos.rocketparam.model.Mass;
import ru.aerocos.rocketparam.repository.Parameters;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/parameters")
public class ParametersServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("pages/parameters.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String name = request.getParameter("name");
//        response.getWriter().print("Hello "+ name + "!!");

        String respStr = "";

        Parameters rep = new Parameters();
        rep.setVx(Double.parseDouble(request.getParameter("Vx"))).
                setS(Double.parseDouble(request.getParameter("s1")), Double.parseDouble(request.getParameter("s2")), Double.parseDouble(request.getParameter("s3"))).
                setW(Double.parseDouble(request.getParameter("w1")), Double.parseDouble(request.getParameter("w2")), Double.parseDouble(request.getParameter("w3"))).
                setMp(Double.parseDouble(request.getParameter("mp"))).
                setA(Double.parseDouble(request.getParameter("a"))).
                compute(request.getParameter("scheme"));

        switch (request.getParameter("scheme")){
            case "posled" :
            case "parallbezpereliva" : respStr = Mass.compute(rep).massToStr2(); break;
        }
        response.getWriter().print(respStr);
    }
}
