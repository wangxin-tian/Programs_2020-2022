package com.wangxin.javaweb.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FirstServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //输出中⽂
        resp.setContentType("text/html;charset=utf-8");
        //使⽤response响应浏览器的请求：返回简单⽂本
        //response.getWriter().print("第⼀个Servlet");
        //使⽤response响应浏览器的请求：返回复杂html内容
        resp.getWriter().print(
                "姓名<input type='text' name='username'>" +
                        "<br> " +
                        "密码<input type='password' name='userpwd'>" +
                        "<br>" +
                        "<input type='button' value='登录'>"
        );
    }
}
