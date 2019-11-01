package com.bysj.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Orders {
    private int id;
    private Date pubTime;
    private Date finTime;
    private int checkNum;
    private int postNum;
    private String sub;
    private String level;
    private String content;
    private float price;
    private int weekNum;
    private int status;
    private Student student;
    private Teacher teacher;
}
