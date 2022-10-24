package test.com.wangxin.ssm.spring.assemble;

import com.wangxin.ssm.spring.assemble.annotation.ClazzAnnotation;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationTest {
    public static void main(String[] args) {
        //1
        ApplicationContext ac=
                new ClassPathXmlApplicationContext("spring-config.xml");
        //2
        ClazzAnnotation clazz=(ClazzAnnotation) ac.getBean("clazzAnnotation");

        //3
        System.out.println(clazz.toString());
    }
}
