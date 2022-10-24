package test.com.wangxin.ssm.spring.bean;

import com.wangxin.ssm.spring.instance.Cookie;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanFactoryTest {
    public static void main(String[] args) {

        //1
        ApplicationContext ac=
                new ClassPathXmlApplicationContext("spring-config.xml");
        //2
        Cookie cookie1=(Cookie) ac.getBean("cookie1");

        //3
        System.out.println("通过构造器创建对象");
        System.out.println(ac.getBean("cookie1"));
        //3.2、获得并打印cookie2对象
        System.out.println("通过静态⼯⼚实例化cookie2:");
        System.out.println(ac.getBean("cookie2"));
        //3.3、获得并打印cookie3对象
        System.out.println("通过实例⼯⼚实例化cookie3:");
        System.out.println(ac.getBean("cookie3"));
    }
}
