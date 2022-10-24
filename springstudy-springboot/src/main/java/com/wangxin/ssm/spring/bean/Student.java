package com.wangxin.ssm.spring.bean;

public class Student {
    private int id = 10000001;
    private String name = "张三";
    private String sex = "男";
    private String email = "zhansan@hbxy.edu.cn";

    /*依赖关系 -类似- 构造函数与变量的关系*/

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    @Override
    public String toString() {
        //json格式的字符串
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
