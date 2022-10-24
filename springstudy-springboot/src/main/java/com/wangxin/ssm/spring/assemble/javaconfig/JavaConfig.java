package com.wangxin.ssm.spring.assemble.javaconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan(value = "com.wangxin.ssm.spring.assemble.javaconfig") //定义要扫描的包路径
public class JavaConfig {

    @Bean("teacher") //定义⼀个bean,指定bean的名称
    @Scope("prototype")
    public Teacher createTeacher(){
        return new Teacher();
    }
    /**

     @Bean //定义⼀个bean，如果没有定义bean的名称,则以⽅法名clazz作为对象的名称
     public Clazz clazz(){
     Clazz clazz = new Clazz(); //setter⽅法注⼊ ，注⼊类要有个⽆参构造函
     数
     clazz.setTeacher(createTeacher());
     return clazz;
     }
     */


    @Bean //定义⼀个bean，如果没有定义bean的名称,则以⽅法名clazz作为对象的名称
    @Autowired
    public Clazz clazz(Teacher teacher){
        return new Clazz(teacher); //构造函数注⼊
    }
}
