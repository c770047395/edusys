package com.bysj.service;

import com.bysj.pojo.Teacher;

import java.util.List;

public interface TeacherService {
    List<Teacher> queryAllTeacher();
    Teacher queryTeacherById(int id);
    Teacher queryTeacherByUsername(String username);
    int addTeacher(Teacher teacher);
    int updateTeacher(Teacher teacher);
    int deleteTeacher(int id);
    Teacher login(String username, String password);
    boolean changeStatus(int id,int status);
}
