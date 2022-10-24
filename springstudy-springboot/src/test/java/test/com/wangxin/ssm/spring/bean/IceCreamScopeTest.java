package test.com.wangxin.ssm.spring.bean;

import com.wangxin.ssm.spring.scope.IceCream;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IceCreamScopeTest {
    public static void main(String[] args) {
        //1、实例化spring容器
        ApplicationContext ac =
                new ClassPathXmlApplicationContext("spring-config.xml");
        //2.1 连续获得两个iceCream1,⽐较两个实例的对象号
        System.out.println("iceCream1通过singleton⽅式⽣成:");
        IceCream icecream=(IceCream)ac.getBean("iceCream1");
        System.out.println(icecream);
        System.out.println(ac.getBean("iceCream1"));
        System.out.println(ac.getBean("iceCream1"));
        //2.2 连续获得两个iceCream2,⽐较两个实例的对象号
        System.out.println("iceCream2通过prototype⽅式⽣成:");
        System.out.println(ac.getBean("iceCream2"));
        System.out.println(ac.getBean("iceCream2"));
        System.out.println(ac.getBean("iceCream2"));
    }
}
