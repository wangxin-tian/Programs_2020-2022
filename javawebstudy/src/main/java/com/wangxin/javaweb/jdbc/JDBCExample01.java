package com.wangxin.javaweb.jdbc;

import java.sql.*;

public class JDBCExample01 {
    public static void main(String[] args) {

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;//三个非常昂贵的资源，使用后要及时释放

        try {
            //1 加载驱动
            //DriverManager.registerDriver();
            Class.forName("com.mysql.cj.jdbc.Driver");
            //创建一个连接
            String url = "jdbc:mysql://localhost:3306/mydb? serverTimezone=Asia/Shanghai&autoReconnect=true&useSSL=false&ch aracterEncoding=utf8&useUnicode=true";
            String username = "root";
            String password = "556688";
            conn = DriverManager.getConnection (url, username, password);
            //3 创建statement
            stmt = conn.createStatement();
            //4 执行sql语句
            String sql="select * from user";
            rs = stmt.executeQuery(sql);
            //5 处理结果
            //System.out.println("userId | userName | sex | birthPlace | clazz | userNo | address");
            while (rs.next()) {
                // 通过列名获取指定字段的值
                int userId = rs.getInt("user_id");
                String userName = rs.getString("user_name");
                String sex = rs.getString("sex");
                String birthPlace = rs.getString("birth_place");
                String clazz = rs.getString("clazz");
                String userNo = rs.getString("user_no");
                String address = rs.getString("address");
                //打印出获得的数据
                System.out.println(userId + " | " + userName +
                        " | " + sex + " | " + birthPlace + " | "
                        + clazz+" | " + userNo+" | " +
                        address);
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally{
            //6 释放资源
            if(rs!=null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                rs = null;
            }
            if(stmt!=null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                stmt = null;
            }
            if(conn!=null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                conn = null;
            }
        }
    }
}
