package com.wangxin.ssm.course.dao;

import com.wangxin.ssm.course.model.Course;

import java.util.List;

public interface CourseMapper {

    public void addCourse(Course course);

    public void updateCourse(Course course);//修改的课程是有Id的

    public void deleteCourse(int id);

    public Course findCourseById(int id);

    public List<Course> findAllCourses();

}
