package com.wangxin.ssm.spring.jdbc;

import com.wangxin.ssm.spring.bean.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class StudentDAO {
    @Autowired
    JdbcTemplate template;

    public StudentDAO(JdbcTemplate jdbcTemplate) {
        this.template = jdbcTemplate;
    }
    public void setTemplate(JdbcTemplate template){
        this.template = template;
    }
    public void addStudent(Student student){
        String sql="INSERT INTO students(name,sex,email) " +
                " values(?,?,?)";
        template.update(sql,
                student.getName(),student.getSex(),student.getEmail());
    }
    public void deleteStudent(int id){
        String sql = "DELETE FROM students WHERE id = ?";
        template.update(sql,id);
    }
    public void updateStudent(Student student){
        String sql = "UPDATE STUDENTS SET name=? , sex=? , email=? " + "WHERE id=? ";
        template.update(sql, student.getName(),
                student.getSex(),student.getEmail(),student.getId());
    }

    // 简单查询，按照ID查询，返回字符串
    public String findNameById(int id) {
        String sql = "select name from students where id=?";
        return template.queryForObject(sql, String.class, id);
    }
    // 复杂查询返回List集合
    public List<Student> findAll() {
        String sql = "select * from students";
        return template.query(sql, new StudentRowMapper());
    }
    //根据id查询
    public Student findById(int id) {
        String sql="select * from students where id=?";
        return template.queryForObject(sql, new StudentRowMapper(), id);
    }
    //使⽤spring RowMapper进⾏数据集和对象映射
    class StudentRowMapper implements RowMapper<Student> {
        //rs为返回结果集，以每⾏为单位封装着
        @Override
        public Student mapRow(ResultSet rs, int rowNum)
                throws SQLException {
            Student student = new Student();
            student.setId(rs.getInt("id"));
            student.setName(rs.getString("name"));
            student.setSex(rs.getString("sex"));
            student.setEmail(rs.getString("email"));
            return student;
        }
    }
}
