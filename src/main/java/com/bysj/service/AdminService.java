package com.bysj.service;

import com.bysj.pojo.Admin;

import java.util.List;

public interface AdminService {
    List<Admin> queryAllAdmin();
    Admin queryAdminById(int id);
    Admin queryAdminByUsername(String admin);
    int addAdmin(Admin admin);
    int updateAdmin(Admin admin);
    int deleteAdmin(int id);
    Admin login(String username,String password);
}
