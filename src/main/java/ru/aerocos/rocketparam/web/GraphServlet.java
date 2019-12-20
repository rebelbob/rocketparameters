package ru.aerocos.rocketparam.web;

import ru.aerocos.rocketparam.model.Mass;
import ru.aerocos.rocketparam.model.graphs.Stage1;
import ru.aerocos.rocketparam.repository.MassParam;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/graph")
public class GraphServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



        Stage1 stage1 = new Stage1();
        stage1.compute(Double.parseDouble(request.getParameter("P1")), Double.parseDouble(request.getParameter("t1")),
                Double.parseDouble(request.getParameter("betta")), Double.parseDouble(request.getParameter("D1")),
                2786, 75000 + 12300 + 2900, Integer.parseInt(request.getParameter("fi1")));
        stage1.compute(Double.parseDouble(request.getParameter("P2")), Double.parseDouble(request.getParameter("t2")),
                Double.parseDouble(request.getParameter("betta")), Double.parseDouble(request.getParameter("D2")),
                2943, 12300 + 2900, Integer.parseInt(request.getParameter("fi2")));
        stage1.compute(Double.parseDouble(request.getParameter("P3")), Double.parseDouble(request.getParameter("t3")),
                Double.parseDouble(request.getParameter("betta")), Double.parseDouble(request.getParameter("D3")),
                2953, 2900, Integer.parseInt(request.getParameter("fi3")));

        request.setAttribute("speed", toDoubleList(stage1.getTime(), stage1.getSpeed()));
        request.setAttribute("fi", toDoubleList(stage1.getTime(), stage1.getFiList()));
        request.setAttribute("tetta", toDoubleList(stage1.getTime(), stage1.getTettaList()));
        request.setAttribute("alpha", toDoubleList(stage1.getTime(), stage1.getAlphaList()));
        request.setAttribute("hight", toDoubleList(stage1.getTime(), stage1.getHight()));

        request.getRequestDispatcher("pages/graph.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);
    }

    private ArrayList<ArrayList<Integer>> toDoubleList(List<Integer> list1, List<Integer> list2){
        ArrayList<ArrayList<Integer>> doubleList = new ArrayList<>();
        for (int i = 0; i < list1.size(); i++){
            ArrayList<Integer> s = new ArrayList<>();
            s.add(list1.get(i));
            s.add(list2.get(i));
            doubleList.add(s);
        }
        return doubleList;
    }
}
