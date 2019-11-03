package com.bysj.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Evalution {
    private int id;
    private Date postTime;
    private Date anTime;
    private String postContent;
    private String anContent;
    private int orderId;
    private int toUser;
    private int toTeacher;
}
