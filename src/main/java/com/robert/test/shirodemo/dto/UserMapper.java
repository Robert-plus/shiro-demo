package com.robert.test.shirodemo.dto;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @Author Christy
 * @DESC
 * @Date 2020/11/16 15:49
 **/
@Mapper
public interface UserMapper extends BaseMapper<User> {
    /**
     * 根据用户名查找用户
     * @author Christy
     * @date 2020/11/17 22:19
     * @param username
     * @return com.christy.mplus.model.entity.User
     */
    @Select("SELECT u.id,u.username,u.password,u.salt,u.age,u.email,u.address FROM t_user u WHERE u.username = #{username}")
    User findUserByUsername(String username);

}

