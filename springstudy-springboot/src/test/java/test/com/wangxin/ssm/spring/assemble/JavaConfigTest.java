package test.com.wangxin.ssm.spring.assemble;

import com.wangxin.ssm.spring.assemble.javaconfig.Clazz;
import com.wangxin.ssm.spring.assemble.javaconfig.JavaConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext
                ac = new AnnotationConfigApplicationContext(JavaConfig.class);
        Clazz c = (Clazz) ac.getBean("clazz");
        System.out.println("使⽤javaconfig装配bean:");
        System.out.println(c.toString());
    }
}
