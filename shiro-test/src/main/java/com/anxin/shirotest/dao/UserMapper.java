package com.anxin.shirotest.dao;

import com.anxin.shirotest.pojo.User;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author: ly
 * @date: 2019/9/23 10:44
 */
@Service
public class UserMapper {
    public User findByUserName(String username) {
        User user = new User();
        user.setId(1);
        user.setCreateTime(new Date());
        user.setUserName("admin");
        user.setPassword("1fedc5a36d03c185065dd2b323886aa5");//123456
        user.setStatus("1");
        return user;
    }
}
