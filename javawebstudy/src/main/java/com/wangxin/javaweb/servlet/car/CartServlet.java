package com.wangxin.javaweb.servlet.car;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "CartServlet",value = "/CartServlet")
public class CartServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        // 变量cart引⽤⽤户的购物⻋
        List<Book> cart = null;
        // 变量pruFlag标记⽤户是否买过商品
        boolean purFlag = true;
        // 获得⽤户的session
        HttpSession session = request.getSession(false);
        // 如果session为null，purFlag置为false
        if (session == null) {
            purFlag = false;
        } else {
            // 获得⽤户购物⻋
            cart = (List) session.getAttribute("cart");
            // 如果⽤的购物⻋为null，purFlag置为false
            if (cart == null) {
                purFlag = false;
            }
        }
        /*
         * 如果purFlag为false，表明⽤户没有购买图书 重定向到ListServlet⻚⾯
         */
        if (!purFlag) {
            out.write("对不起！您还没有购买任何商品！" +
                    "&nbsp;&nbsp;<a href='/BookListServlet'>返回图书列表</a><br>");
        } else {
            // 否则显示⽤户购买图书的信息
            out.write("您购买的图书有：" +
                    "&nbsp;&nbsp;<a href='/BookListServlet'>返回图书列表</a><br>");
            double price = 0;
            for (Book book : cart) {
                out.write(book.getName() + "<br>");
            }
        }
    }
    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}
