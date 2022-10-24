package com.wangxin.ssm.spring.instance;

public class BeanStaticFactory {
    public static Cookie cookieFactory(){
        Cookie cookie = new Cookie();
        cookie.setType("奶油饼⼲");
        cookie.setProductTime("2010-04-22");
        return cookie;
    }
}
