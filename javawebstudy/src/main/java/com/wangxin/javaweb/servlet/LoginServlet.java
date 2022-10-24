package com.wangxin.javaweb.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/loginservlet")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if(("admin").equals(username)&&("123").equals("password")){
            resp.sendRedirect("/myweb/welcome.html");
        }else {
            resp.sendRedirect("/myweb/welcome.html");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
