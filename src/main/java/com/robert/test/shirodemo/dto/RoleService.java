package com.robert.test.shirodemo.dto;


import java.util.List;

public interface RoleService {
    /**
     * 根据用户id获取用户的角色集合
     * @param userId
     * @return
     */
    List<Role> getRolesByUserId(Integer userId);
}

