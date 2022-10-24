package com.wangxin.javaweb.servlet.filter;

import javax.servlet.*;
import java.io.IOException;

public class CharacterFilter implements Filter {

    private String characterEncoding = null;
    FilterConfig fc;

    //读取配置的编码格式
    @Override
    public void init(FilterConfig config)
            throws ServletException {
        fc = config;
        if(null != fc &&
                null != fc.getInitParameter("encoding") &&
                !"".equals(fc.getInitParameter("encoding"))){
            characterEncoding = fc.getInitParameter("encoding");
        }else{
            characterEncoding = "UTF-8";
        }
    }

    @Override
    public void doFilter(ServletRequest req,
                         ServletResponse resp,
                         FilterChain chain)
            throws IOException, ServletException {
        // 拦截所有的请求 解决全站中⽂乱码
        // 指定 request 和 response 的编码
        req.setCharacterEncoding(characterEncoding);
        //将response对象中的数据以UTF-8解码后发向浏览器
        resp.setCharacterEncoding(characterEncoding);
        //告诉浏览器输出内容为HTML,并使⽤UTF-8对html内容进⾏解码
        resp.setContentType("text/html;charset="+characterEncoding);
        chain.doFilter(req, resp);
    }

    @Override
    public void destroy() {
    }
}
