package com.bysj.service;

import com.bysj.dao.StudentMapper;
import com.bysj.pojo.Student;

import java.util.List;

public interface StudentService {
    List<Student> queryAllStudent();
    Student queryStudentById(int id);
    Student queryStudentByUsername(String username);
    int addStudent(Student student);
    int updateStudent(Student student);
    int deleteStudent(int id);
    Student login(String username,String password);
    boolean changeStatus(int id,int status);

}
