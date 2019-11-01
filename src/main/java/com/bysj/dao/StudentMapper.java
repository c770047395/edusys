package com.bysj.dao;

import com.bysj.pojo.Student;

import java.util.List;

public interface StudentMapper {
    List<Student> queryAllStudent();
    Student queryStudentById(int id);
    Student queryStudentByUsername(String username);
    int addStudent(Student student);
    int updateStudent(Student student);
    int deleteStudent(int id);


}
