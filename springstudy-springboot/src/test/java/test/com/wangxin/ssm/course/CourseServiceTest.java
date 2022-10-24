package test.com.wangxin.ssm.course;

import com.wangxin.ssm.course.model.Course;
import com.wangxin.ssm.course.service.CourseService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class CourseServiceTest {
    public static void main(String[] args) {
        //1、创建spring容器 同时创建了mybatis的工程类、数据源、service
        ApplicationContext ac =
                new ClassPathXmlApplicationContext("spring-integration.xml");
        //2获得service对象
        //可以通过bean的名称，也可以通过类型名获得
//        CourseService courseService = (CourseService)ac.getBean(CourseService.class);
        CourseService courseService = (CourseService)ac.getBean("courseService");
        //3、使⽤service对象操作数据库
        //3.1 添加
//       Course course = new Course();
//       course.setCourseTitle("Web编程技术");
//       course.setCourseCode("10001");
//       course.setCourseType("专业必修");
//       course.setCourseCredit("3");
//       course.setCourseHours("64");
//       course.setTerm("第二学年第2学期");
//       course.setCourseDesc("web spring");
//       courseService.addCourse(course);
        //3.2 删除
//        courseService.deleteCourse(2);
        //3.3 根据id查询
//      Course course1= courseService.findCourseById(5);
//      System.out.println(course1);

        //3.4 修改
//        Course course = new Course();
//        course.setCourseId(5);
//        course.setCourseTitle("Java语⾔");
//        course.setCourseCode("JX02S1001");
//        course.setCourseType("专业课/必修");
//        course.setCourseCredit("4");
//        course.setCourseHours("64");
//        course.setTerm("第⼆学年第1学期");
//        course.setCourseDesc("学习C语⾔");
//        courseService.updateCourse(course);
        //3.5 查询所有
        List<Course> list = courseService.findAllCourses();
        for(Course c : list){
            System.out.println(c.toString());
        }
    }
}
