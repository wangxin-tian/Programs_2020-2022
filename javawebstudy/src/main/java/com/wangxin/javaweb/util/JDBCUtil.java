package com.wangxin.javaweb.util;

import java.sql.*;

public class JDBCUtil {
    private static Connection conn;
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        //DriverManager.registerDriver();
        Class.forName("com.mysql.cj.jdbc.Driver");
        //创建一个连接
        String url = "jdbc:mysql://localhost:3306/mydb? serverTimezone=Asia/Shanghai&autoReconnect=true&useSSL=false&ch aracterEncoding=utf8&useUnicode=true";
        String username = "root";
        String password = "556688";
        conn = DriverManager.getConnection(url,username,password);
        return conn;
    }
    public static void release(ResultSet rs, Statement stmt, Connection conn){
        if (rs != null){
            try{
                rs.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        if (stmt != null){
            try{
                rs.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        if (conn != null){
            try{
                rs.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
