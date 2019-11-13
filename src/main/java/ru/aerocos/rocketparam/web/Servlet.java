package ru.aerocos.rocketparam.web;

import org.slf4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

public class Servlet extends HttpServlet {
    private static final Logger log = getLogger(Servlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Integer> nums = Arrays.asList(1,2,3,4,5,6,7,8,5,4,6,8,2,3,4,5);

        req.setAttribute("nums", nums);

        req.getRequestDispatcher("graph.jsp").forward(req, resp);
    }
}
