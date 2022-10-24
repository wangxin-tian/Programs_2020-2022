package com.wangxin.javaweb.user.servlet;

import com.wangxin.javaweb.user.dao.UserDAO;
import com.wangxin.javaweb.user.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UserEditServlet", value = "/useredit")
public class UserEditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp)
            throws ServletException, IOException {
        //接收中⽂
        req.setCharacterEncoding("UTF-8");
        //获得参数
        int userId = Integer.parseInt(req.getParameter("userId"));
        String userName = req.getParameter("userName");
        String sex = req.getParameter("sex");
        String birthplace = req.getParameter("birthplace");
        String userNo = req.getParameter("userNo");
        String clazz = req.getParameter("clazz");
        String address = req.getParameter("address");
        User user = new User();
        user.setUserId(userId);
        user.setUserName(userName);
        user.setSex(sex);
        user.setBirthplace(birthplace);
        user.setUserNo(userNo);
        user.setClazz(clazz);
        user.setAddress(address);

        UserDAO dao = new UserDAO();
        dao.update(user);
        //添加成功，跳转到列表⻚⾯
        resp.sendRedirect("/userlist");
    }

    @Override
    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp)
            throws ServletException, IOException {
        doGet(req, resp);
    }
}
