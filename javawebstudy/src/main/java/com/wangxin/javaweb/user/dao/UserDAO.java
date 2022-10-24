package com.wangxin.javaweb.user.dao;

import com.wangxin.javaweb.user.dao.UserDAO;
import com.wangxin.javaweb.user.model.User;
import com.wangxin.javaweb.util.JDBCUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    // 添加⽤户的操作
    public boolean add(User user) {
        Connection conn = null;
        PreparedStatement preStmt = null;
        ResultSet rs = null;
        try {
            // 获得数据的连接
            conn = JDBCUtil.getConnection();
            // 执⾏的SQL语句
            String sql = "INSERT INTO user (user_name, sex, birth_place, clazz, user_No, address)"
                    + "VALUES(?,?,?,?,?,?)";//?占位符，按位置取值
            // 创建执⾏SQL语句的PreparedStatement 对象

            preStmt = conn.prepareStatement(sql);
            preStmt.setString(1, user.getUserName());
            preStmt.setString(2, user.getSex());
            preStmt.setString(3, user.getBirthplace());
            preStmt.setString(4, user.getClazz());
            preStmt.setString(5, user.getUserNo());
            preStmt.setString(6, user.getAddress());
            int num=preStmt.executeUpdate();
            if (num > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.release(rs, preStmt, conn);
        }
        return false;
    }
    // 查询所有的User对象
    public ArrayList<User> findAll() {
        Connection conn = null;
        PreparedStatement preStmt = null;
        ResultSet rs = null;
        ArrayList<User> list = new ArrayList<User>();
        try {
            // 获得数据的连接
            conn = JDBCUtil.getConnection();
            // SQL语句
            String sql = "SELECT * FROM user";
            // 获得Statement对象
            preStmt = conn.prepareStatement(sql);
            rs = preStmt.executeQuery();
            // 处理结果集
            while (rs.next()) {
                User user = new User();
                user.setUserId(rs.getInt("user_id"));
                user.setUserName(rs.getString("user_name"));
                user.setSex(rs.getString("sex"));
                user.setBirthplace(rs.getString("birth_place"));
                user.setClazz(rs.getString("clazz"));
                user.setUserNo(rs.getString("user_no"));
                user.setAddress(rs.getString("address"));

                list.add(user);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.release(rs, preStmt, conn);
        }
        return null;
    }
    // 根据id查找指定的user
    public User find(int userid) {
        User user = new User();
        Connection conn = null;
        PreparedStatement preStmt = null;
        ResultSet rs = null;
        try {
            // 获得数据的连接
            conn = JDBCUtil.getConnection();
            // SQL语句
            String sql = "SELECT * FROM user WHERE user_id=?";
            // 创建执⾏SQL语句的PreparedStatement 对象
            preStmt = conn.prepareStatement(sql);
            preStmt.setInt(1,userid);
            rs = preStmt.executeQuery();
            // 处理结果集
            while (rs.next()) {
                user.setUserId(rs.getInt("user_id"));
                user.setUserName(rs.getString("user_name"));
                user.setSex(rs.getString("sex"));
                user.setBirthplace(rs.getString("birth_place"));
                user.setClazz(rs.getString("clazz"));
                user.setUserNo(rs.getString("user_no"));
                user.setAddress(rs.getString("address"));
                return user;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.release(rs, preStmt, conn);
        }
        return null;
    }
    // 删除⽤户
    public boolean delete(int id) {
        Connection conn = null;
        PreparedStatement preStmt = null;
        ResultSet rs = null;
        try {
            // 获得数据的连接
            conn = JDBCUtil.getConnection();
            // SQL语句
            String sql = "DELETE FROM user WHERE user_id=?";
            // 创建执⾏SQL语句的PreparedStatement 对象
            preStmt = conn.prepareStatement(sql);
            preStmt.setInt(1,id);
            int num = preStmt.executeUpdate();
            if (num > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.release(rs, preStmt, conn);
        }
        return false;
    }
    // 修改⽤户
    public boolean update(User user) {
        Connection conn = null;
        PreparedStatement preStmt = null;
        ResultSet rs = null;
        try {
            // 获得数据的连接
            conn = JDBCUtil.getConnection();
            // 执⾏的SQL语句
            String sql = "UPDATE user set"+
                    " user_name=?, sex=?, birth_place=?, clazz=?, user_No=?, address=?"
                    + " where user_id=? ";
            // 创建执⾏SQL语句的PreparedStatement 对象
            preStmt = conn.prepareStatement(sql);
            preStmt.setString(1, user.getUserName());
            preStmt.setString(2, user.getSex());
            preStmt.setString(3, user.getBirthplace());
            preStmt.setString(4, user.getClazz());
            preStmt.setString(5, user.getUserNo());
            preStmt.setString(6, user.getAddress());
            preStmt.setInt(7, user.getUserId());
            int num = preStmt.executeUpdate();
            if (num > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.release(rs, preStmt, conn);
        }
        return false;
    }
}

