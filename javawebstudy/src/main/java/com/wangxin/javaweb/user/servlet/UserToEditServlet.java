package com.wangxin.javaweb.user.servlet;

import com.wangxin.javaweb.user.dao.UserDAO;
import com.wangxin.javaweb.user.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "UserToEditServlet", value = "/usertoedit")
public class UserToEditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userId = request.getParameter("userId");
        User user = new User();
        UserDAO dao =new UserDAO();
        if(null != userId){
            //学⽣数据
            user = dao.find(Integer.parseInt(userId));
        }
        //班级列表数据
        List<String> clazzlist = new ArrayList<String>() {{
            add("计科1901");
            add("计科1902");
            add("计科1903");
            add("计科1904");
            add("计科1905");
            add("计科1906");
            add("计科1907");
        }};
        //把找到的数据放进request
        request.setAttribute("user",user);
        request.setAttribute("clazzlist",clazzlist);

        //转发到修改⻚⾯

        request.getRequestDispatcher("/jsp/user/user_edit.jsp").
                forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
