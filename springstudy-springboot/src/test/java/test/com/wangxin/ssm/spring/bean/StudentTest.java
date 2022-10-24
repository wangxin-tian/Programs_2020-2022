package test.com.wangxin.ssm.spring.bean;

import com.wangxin.ssm.spring.bean.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StudentTest {
    public static void main(String[] args) {
        //1 创建spring容器
        ApplicationContext ac=
                new ClassPathXmlApplicationContext("spring-config.xml");
        //2 通过id或者name获得java对象，需要类型转换
        Student s=(Student) ac.getBean("student");
        //3 使⽤对象
        s.setId(10000001);
        s.setName("张三");
        s.setSex("男");
        s.setEmail("zs@hbxy.edu.cn");
        System.out.println(s.toString());
    }
}
