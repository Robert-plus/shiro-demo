package com.robert.test.shirodemo.dto;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author Christy
 * @DESC
 * @Date 2020/11/17 22:40
 **/
@Mapper
public interface RoleMapper extends BaseMapper<Role> {
    /**
     * 根据用户id查询用户的角色
     * @author Christy
     * @date 2020/11/17 22:42
     * @param userId
     * @return java.util.List<com.christy.mplus.model.entity.Role>
     */
    @Select("select r.id,r.name from t_role r left join t_user_role ur on ur.role_id = r.id where ur.user_id = #{userId}")
    List<Role> getRolesByUserId(Integer userId);
}

