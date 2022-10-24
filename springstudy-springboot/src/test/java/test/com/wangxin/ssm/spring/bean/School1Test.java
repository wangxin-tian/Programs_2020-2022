package test.com.wangxin.ssm.spring.bean;

import com.wangxin.ssm.spring.bean.School1;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class School1Test {
    public static void main(String[] args) {
        //1
        ApplicationContext ac =
                new ClassPathXmlApplicationContext("spring-config.xml");
        //2
        School1 s1=(School1) ac.getBean("school1");
        //3
        System.out.println(s1.toString());
    }
}
