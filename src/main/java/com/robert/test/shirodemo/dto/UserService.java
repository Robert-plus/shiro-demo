package com.robert.test.shirodemo.dto;


public interface UserService {
    /**
     * 用户注册
     * @param user
     */
    void register(User user);
    User findUserByUserName(String userName);
}

