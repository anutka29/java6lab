package com.anutka29.java6lab;

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

    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String sizeString = req.getParameter("size");
        String countString = req.getParameter("count");
        String colorString = req.getParameter("color");

        String[] text_start = {
                "The world of computer programming and coding can be confusing - and often intimidating.",
                "As school continue to incorporate STEM onto their curriculum, there are many new worlds ",
                "and concepts that are often used, and sometimes misused. Whether you are a teacher ",
                "looking to add to your curriculum, or a parent with a child in school, ",
                "you will often hear terms like \"coding,\" \"programming,\" \"block-based,\" and \"text-based.\" ",
                "They can sound pretty complicated to someone unfamiliar with the topic. Read below for some ",
                "simple definitions to help you understand the basics.",
                "While coding and programming are very similar and the terms are often used together, ",
                "there are some important differences between the two. ",
                "Coding, in its simplest form, is the process of writing instructions. ",
                "Programming is taking those instructions and making the target act according to them. ",
        };

        StringBuilder sb = new StringBuilder();
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

        for (int i=0; i<count; i++) {
            sb.append(text_start[i]);
            sb.append("<br>");
        }

        String text = sb.toString().trim();

        req.setAttribute("text", text);
        req.setAttribute("size", size);
        req.setAttribute("count", count);
        req.setAttribute("color", colorString);
        getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
    }

}
