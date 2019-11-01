package com.bysj.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    private int id;
    private String username;
    private String password;
    private String name;
    private String sex;
    private String idNumber;
    private String area;
    private String address;
    private String phone;
    private String sq;
    private String an;
    private int status; //状态，0未交押金正常，1已交押金正常，2未交押金封禁，3已交押金封禁
}
