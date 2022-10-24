package com.wangxin.javaweb.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ResultServlet",value = "/ResultServlet")
public class ResultServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        req.setCharacterEncoding("utf-8");
        // 获取PrintWriter对象⽤于输出信息
        PrintWriter out = resp.getWriter();
        // 获取request请求对象转发过来的数据
        String students = (String) req.getAttribute("students");
        String schoolName = req.getParameter("schoolName");
        String address = req.getParameter("address");
        if (students != null) {
            out.println("这些内容是ResultServlet输出到浏览器的:<br>");
            out.println("学校名称：" + schoolName + "<br>");
            out.println("学校地址：" + address + "<br>");
            out.println("学⽣⼈数：" + students + "<br>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
