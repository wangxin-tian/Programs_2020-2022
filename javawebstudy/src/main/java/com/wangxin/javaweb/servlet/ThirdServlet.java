package com.wangxin.javaweb.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
//servlet生命周期
@WebServlet(name = "ThirdServlet" ,value = "/ThirdServlet")
public class ThirdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doGet方法被调用");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doPost方法被调用");
    }

    @Override
    public void destroy() {
        System.out.println("destroy方法被调用");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("init方法被调用");
    }
}
