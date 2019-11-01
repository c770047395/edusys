package com.bysj.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {
    private int id;
    private String username;
    private String password;
    private String name;
    private String sex;
    private String idNumber;
    private String age;
    private String role;
    private String school;
    private String descripthon;
    private String phone;
    private String sq;
    private String an;
    private int status; //状态，0未认证正常，1已认证正常，2未认证封禁，3已认证封禁
}
