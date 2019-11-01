package com.bysj.dao;

import com.bysj.pojo.Teacher;

import java.util.List;

public interface TeacherMapper {
    List<Teacher> queryAllTeacher();
    Teacher queryTeacherById(int id);
    Teacher queryTeacherByUsername(String username);
    int addTeacher(Teacher teacher);
    int updateTeacher(Teacher teacher);
    int deleteTeacher(int id);
}
