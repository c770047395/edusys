package com.bysj.service;

import com.bysj.dao.TeacherMapper;
import com.bysj.pojo.Teacher;

import java.util.List;

public class TeacherServiceImpl implements TeacherService {
    private TeacherMapper teacherMapper;

    public void setTeacherMapper(TeacherMapper teacherMapper) {
        this.teacherMapper = teacherMapper;
    }

    public List<Teacher> queryAllTeacher() {
        return teacherMapper.queryAllTeacher();
    }

    public Teacher queryTeacherById(int id) {
        return teacherMapper.queryTeacherById(id);
    }

    public Teacher queryTeacherByUsername(String username) {
        return teacherMapper.queryTeacherByUsername(username);
    }

    public int addTeacher(Teacher teacher) {
        return teacherMapper.addTeacher(teacher);
    }

    public int updateTeacher(Teacher teacher) {
        return teacherMapper.updateTeacher(teacher);
    }

    public int deleteTeacher(int id) {
        return teacherMapper.deleteTeacher(id);
    }

    public List<Teacher> queryTeacherByStatus(int status) {
        return teacherMapper.queryTeacherByStatus(status);
    }

    public Teacher login(String username, String password) {
        Teacher teacher = teacherMapper.queryTeacherByUsername(username);
        if (teacher == null){
            return null;
        }
        if (!teacher.getPassword().equals(password)) {
            return null;
        }
        return teacher;

    }

    public boolean changeStatus(int id, int status) {
        Teacher teacher = queryTeacherById(id);
        teacher.setStatus(status);
        teacherMapper.updateTeacher(teacher);
        return true;
    }
}
