package com.wangxin.javaweb.servlet.car;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

//模拟数据库
public class BookDB {
    private static HashMap<String,Book> books = new LinkedHashMap<>();
    static {
        books.put("1", new Book("1", "JavaWeb开发"));
        books.put("2", new Book("2", "JDBC开发"));
        books.put("3", new Book("3", "Java基础"));
        books.put("4", new Book("4", "C语⾔"));
        books.put("5", new Book("5", "Spring实战"));
    }
    // 获得所有的图书
    public static Collection<Book> getAll() {
        return books.values();
    }
    // 根据指定的id获得图书
    public static Book getBook(String id) {
        return books.get(id);
    }
}
