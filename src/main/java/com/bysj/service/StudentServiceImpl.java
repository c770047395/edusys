package com.bysj.service;

import com.bysj.dao.StudentMapper;
import com.bysj.pojo.Student;

import java.util.List;

public class StudentServiceImpl implements StudentService {
    private StudentMapper studentMapper;

    public void setStudentMapper(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }

    public List<Student> queryAllStudent() {
        return studentMapper.queryAllStudent();
    }

    public Student queryStudentById(int id) {
        return studentMapper.queryStudentById(id);
    }

    public int addStudent(Student student) {
        return studentMapper.addStudent(student);
    }

    public int updateStudent(Student student) {
        return studentMapper.updateStudent(student);
    }

    public int deleteStudent(int id) {
        return studentMapper.deleteStudent(id);
    }

    public Student queryStudentByUsername(String username) {
        return studentMapper.queryStudentByUsername(username);
    }

    public Student login(String username, String password) {
        Student student = studentMapper.queryStudentByUsername(username);
        if (student == null){
            return null;
        }
        if (!student.getPassword().equals(password)) {
            return null;
        }
        return student;
    }

    public boolean changeStatus(int id, int status) {
        Student student = queryStudentById(id);
        student.setStatus(status);
        studentMapper.updateStudent(student);
        return true;
    }
}
