package com.wangxin.javaweb.servlet.car;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

@WebServlet(name = "BookListServlet",value = "/BookListServlet")
public class BookListServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        Collection<Book> books = BookDB.getAll();
        out.write("本站提供的图书有：&nbsp;&nbsp;" +
                "<a href='/CartServlet'>查看购物⻋</a><br>");
        for (Book book : books) {
            String url = "/PurchaseServlet?id=" + book.getId();
            out.write(book.getName() + "<a href='" + url + "'>点击购买</a> <br>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}
