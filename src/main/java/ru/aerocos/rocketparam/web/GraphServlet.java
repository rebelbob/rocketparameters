package ru.aerocos.rocketparam.web;

import ru.aerocos.rocketparam.model.graphs.Stage1;
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
        stage1.compute(2150, 100, 19, 2.6, 2786, 75000 + 12300 + 2900, 22);
        stage1.compute(371.5, 90, 19, 2.2, 2943, 12300 + 2900, 10);
        stage1.compute(100, 80, 19, 1.4, 2953, 2900, 0);

        request.setAttribute("speed", toDoubleList(stage1.getTime(), stage1.getSpeed()));
        request.setAttribute("fi", toDoubleList(stage1.getTime(), stage1.getFiList()));
        request.setAttribute("tetta", toDoubleList(stage1.getTime(), stage1.getTettaList()));
        request.setAttribute("alpha", toDoubleList(stage1.getTime(), stage1.getAlphaList()));
        request.setAttribute("hight", toDoubleList(stage1.getTime(), stage1.getHight()));

        request.getRequestDispatcher("pages/graph.jsp").forward(request, response);
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
