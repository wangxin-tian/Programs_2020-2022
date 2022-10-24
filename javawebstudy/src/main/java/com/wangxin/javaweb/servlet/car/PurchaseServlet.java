package com.wangxin.javaweb.servlet.car;
import com.wangxin.javaweb.servlet.car.Book;
import com.wangxin.javaweb.servlet.car.BookDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@WebServlet(name = "PurchaseServlet",value = "/PurchaseServlet")
public class PurchaseServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {
        // 获得⽤户购买的商品
        String id = request.getParameter("id");
        if (id == null) {
            // 如果id为null，重定向到ListBookServlet⻚⾯
            String url = "/ListBookServlet";
            response.sendRedirect(url);
            return;
        }
        Book book = BookDB.getBook(id);
        // 创建或者获得⽤户的Session对象
        HttpSession session = request.getSession();
        // 从Session对象中获得⽤户的购物⻋
        List<Book> cart = (List) session.getAttribute("cart");
        if (cart == null) {
            // ⾸次购买，为⽤户创建⼀个购物⻋(List集合模拟购物⻋)
            cart = new ArrayList<Book>();
        }
        // 将商品放⼊购物⻋
        cart.add(book);
        // 将购物⻋存⼊Session对象
        session.setAttribute("cart", cart);
        // 点击成功,重新回到图书列表
        response.sendRedirect("/BookListServlet");
    }
    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}
