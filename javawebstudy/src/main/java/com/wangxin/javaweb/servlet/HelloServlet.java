package com.wangxin.javaweb.servlet;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloServlet extends GenericServlet {
    public void service(ServletRequest request,
                        ServletResponse response)
                        throws ServletException, IOException {
        PrintWriter out = response.getWriter();

       out.println("Hello my dear");
    }
}
