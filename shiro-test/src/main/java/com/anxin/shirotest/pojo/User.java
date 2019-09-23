package com.anxin.shirotest.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private Integer id;
    private String userName;
    private String password;
    private Date createTime;
    private String status;

}
