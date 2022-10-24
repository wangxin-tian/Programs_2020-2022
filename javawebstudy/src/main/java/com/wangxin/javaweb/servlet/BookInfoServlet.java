package com.wangxin.javaweb.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "BookInfoServlet", value = "/BookInfoServlet")
public class BookInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("bookId","1001");
        request.setAttribute("bookName","JavaWeb编程");
        request.setAttribute("bookPrice","56.30");

        //通过RequestDispatcher转发到⼀个jsp⻚⾯
        request.getRequestDispatcher("/jsp/book/book_info.jsp").
                forward(request,response);
    }
}
