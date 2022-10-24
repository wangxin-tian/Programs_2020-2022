package com.wangxin.ssm.spring.bean;
/**
 * 属性赋值注⼊,要求
 * 1 必须存在⼀个⽆参数的构造函数
 * 2 必须存在⼀个属性:student
 * 3 必须存在属性的setter⽅法:setStudent(Student student)
 */
public class School2 {
    private int schoolId = 10002;
    private String schoolName = "hbxy";
    private Student student;
    /**
     * 每个java类都有⼀个不带参数的隐含的构造函数
     * 如果已经存在带参数的构造函数
     * 则必须显式的定义⼀个⽆参数构造函数
     * @return
     */
    public School2(){

    }
    public School2(String name){
        this.schoolName=name;
    }

    public int getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(int schoolId) {
        this.schoolId = schoolId;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "School2{" +
                "schoolId=" + schoolId +
                ", schoolName='" + schoolName + '\'' +
                ", student=" + student +
                '}';
    }
}
