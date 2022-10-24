package com.wangxin.javaweb.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RequestParamsServlet",value = "/RequestParamsServlet")
public class RequestParamsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置request对象的解码⽅式
        req.setCharacterEncoding("utf-8");
        // username 为HTML⻚⾯的 input控件的 name属性
        String name = req.getParameter("username");
        String password = req.getParameter("password");String sex = req.getParameter("sex");
        System.out.println("姓名:" + name);
        System.out.println("密码:" + password);
        System.out.println("性别:" + sex);
        // 获取参数名为“hobby”的值
        String[] hobbys = req.getParameterValues("hobby");
        String hobby="";
        System.out.print("爱好:");
        for (int i = 0; i < hobbys.length; i++) {
            System.out.print(hobbys[i] + ",");
            hobby= hobby+ hobbys[i];
            System.out.println();
        }
        //输出到浏览器
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().println(
                "你输⼊的数据为:<br>"+
                        "姓名:"+name+"<br>"+
                        "密码:"+password+"<br>"+
                        "性别:"+sex+"<br>"+
                        "爱好:"+hobby+"<br>"
        );

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
