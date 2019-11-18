package ru.aerocos.rocketparam.web;

import ru.aerocos.rocketparam.model.Mass;
import ru.aerocos.rocketparam.model.Posledovatelnoe;
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

        Parameters rep = new Parameters();
        rep.setVx(Double.parseDouble(request.getParameter("Vx"))).
                setS(Double.parseDouble(request.getParameter("s1")), Double.parseDouble(request.getParameter("s2"))).
                setW(Double.parseDouble(request.getParameter("w1")), Double.parseDouble(request.getParameter("w2"))).
                setZ(1.1, 1.1).
                setMp(Double.parseDouble(request.getParameter("mp"))).
                computeZX();

        rep = Mass.compute(rep);


        response.getWriter().print(rep.massToStr());
    }
}
