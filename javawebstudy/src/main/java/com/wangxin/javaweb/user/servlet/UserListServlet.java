package com.wangxin.javaweb.user.servlet;

import com.wangxin.javaweb.user.dao.UserDAO;
import com.wangxin.javaweb.user.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserListServlet", value = "/userlist")
public class UserListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {
        //1 从数据库取数据
        UserDAO dao = new UserDAO();
        List<User> list=dao.findAll();
        //2 把数据转发到jsp页面
        request.setAttribute("userlist",list);
        request.getRequestDispatcher("/jsp/user/user_list.jsp")
                .forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
