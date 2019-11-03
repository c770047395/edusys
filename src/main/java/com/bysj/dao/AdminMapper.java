package com.bysj.dao;

import com.bysj.pojo.Admin;

import java.util.List;

public interface AdminMapper {
    List<Admin> queryAllAdmin();
    Admin queryAdminById(int id);
    Admin queryAdminByUsername(String admin);
    int addAdmin(Admin admin);
    int updateAdmin(Admin admin);
    int deleteAdmin(int id);
}
