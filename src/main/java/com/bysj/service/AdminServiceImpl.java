package com.bysj.service;

import com.bysj.dao.AdminMapper;
import com.bysj.pojo.Admin;

import java.util.List;

public class AdminServiceImpl implements AdminService {
    private AdminMapper adminMapper;

    public void setAdminMapper(AdminMapper adminMapper) {
        this.adminMapper = adminMapper;
    }

    public List<Admin> queryAllAdmin() {
        return adminMapper.queryAllAdmin();
    }

    public Admin queryAdminById(int id) {
        return adminMapper.queryAdminById(id);
    }

    public Admin queryAdminByUsername(String admin) {
        return adminMapper.queryAdminByUsername(admin);
    }

    public int addAdmin(Admin admin) {
        return adminMapper.addAdmin(admin);
    }

    public int updateAdmin(Admin admin) {
        return adminMapper.updateAdmin(admin);
    }

    public int deleteAdmin(int id) {
        return adminMapper.deleteAdmin(id);
    }

    public Admin login(String username,String password) {
        Admin admin = adminMapper.queryAdminByUsername(username);
        if (admin == null){
            return null;
        }
        if (!admin.getPassword().equals(password)) {
            return null;
        }
        return admin;
    }
}
