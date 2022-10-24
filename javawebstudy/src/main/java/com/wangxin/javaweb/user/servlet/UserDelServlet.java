package com.wangxin.javaweb.user.servlet;

import com.wangxin.javaweb.user.dao.UserDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UserDelServlet", value = "/userdel")
public class UserDelServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userId = request.getParameter("userId");
        if(null != userId){
            //TODO：到数据库删除数据
            UserDAO dao = new UserDAO();
            dao.delete(Integer.parseInt(userId));
        }

        response.sendRedirect("/userlist");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
