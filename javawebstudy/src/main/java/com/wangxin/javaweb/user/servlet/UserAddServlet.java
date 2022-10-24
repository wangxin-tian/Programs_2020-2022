package com.wangxin.javaweb.user.servlet;

import com.wangxin.javaweb.user.dao.UserDAO;
import com.wangxin.javaweb.user.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UserAddServlet", value = "/useradd")
public class UserAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp)
            throws ServletException, IOException {
        String userName = req.getParameter("userName");
        String sex = req.getParameter("sex");
        String birthplace = req.getParameter("birthplace");
        String userNo = req.getParameter("userNo");
        String clazz = req.getParameter("clazz");
        String address = req.getParameter("address");
        User user = new User();
        user.setUserName(userName);
        user.setSex(sex);
        user.setBirthplace(birthplace);
        user.setUserNo(userNo);
        user.setClazz(clazz);
        user.setAddress(address);

        UserDAO dao = new UserDAO();
        dao.add(user);

        resp.sendRedirect("/userlist");//重定向
    }

    @Override
    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp)
            throws ServletException, IOException {
        doGet(req, resp);
    }
}
