package com.anutka29.java6lab;

import com.thedeanda.lorem.Lorem;
import com.thedeanda.lorem.LoremIpsum;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/index")
public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String sizeString = req.getParameter("size");
        String countString = req.getParameter("count");

        int size;
        int count;
        try {
            size = Integer.parseInt(sizeString);
            count = Integer.parseInt(countString);
        }
        catch (NumberFormatException e)
        {
            size = 10;
            count = 1;
        }
        Lorem lorem = LoremIpsum.getInstance();
        String text = lorem.getHtmlParagraphs(count, count);
        req.setAttribute("text", text);
        req.setAttribute("size", size);
        req.setAttribute("count", count);
        getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}
