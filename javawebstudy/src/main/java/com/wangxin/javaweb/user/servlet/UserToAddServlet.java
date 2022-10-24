package com.wangxin.javaweb.user.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "UserToAddServlet", value = "/usertoadd")
public class UserToAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1 TODO:从数据库获得数据
        List<String> clazzlist = new ArrayList<String>() {{
            add("计科1901");
            add("计科1902");
            add("计科1903");
            add("计科1904");
            add("计科1905");
            add("计科1906");
            add("计科1907");
        }};

        //2 放进request
        request.setAttribute("clazzlist",clazzlist);
        //3 转发到注册⻚⾯
        request.getRequestDispatcher("/jsp/user/user_add.jsp").
                forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
