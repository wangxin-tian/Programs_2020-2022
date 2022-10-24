package com.wangxin.javaweb.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "MyServlet", value = "/MyServlet")
public class MyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("username","wangxin");
        request.setAttribute("pwd","123456");

        request.getRequestDispatcher("/jsp/myjsp.jsp")
                .forward(request,response);//链式调用
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

    }
}
