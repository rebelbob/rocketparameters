package ru.aerocos.rocketparam.web;

import ru.aerocos.rocketparam.model.Posledovatelnoe;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/parameters")
public class ParametersServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String name = request.getParameter("name");
//        response.getWriter().print("Hello "+ name + "!!");

        ArrayList<Double> inputParam = new ArrayList<>();


        Posledovatelnoe posledovatelnoe = new Posledovatelnoe(Double.parseDouble(request.getParameter("Vx")),
                Double.parseDouble(request.getParameter("s1")), Double.parseDouble(request.getParameter("s2")),
                Double.parseDouble(request.getParameter("w1")), Double.parseDouble(request.getParameter("w2")));
        posledovatelnoe.compute();

        inputParam.add(posledovatelnoe.getX1());
        inputParam.add(posledovatelnoe.getX2());


        request.getRequestDispatcher("pages/parameters.jsp").forward(request, response);
    }
}
