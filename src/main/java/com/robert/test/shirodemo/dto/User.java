package com.robert.test.shirodemo.dto;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author Christy
 * @DESC
 * @Date 2020/11/16 15:38
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("t_user")
@ApiModel("用户实体类")
public class User implements Serializable {
    /** 数据库中设置该字段自增时该注解不能少 **/
    @TableId(type = IdType.AUTO)
    @ApiModelProperty(name = "id", value = "ID 主键")
    private Integer id;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    @ApiModelProperty(name = "username", value = "用户名")
    private String username;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    @ApiModelProperty(name = "password", value = "密码")
    private String password;

    @TableField(fill = FieldFill.INSERT)
    @ApiModelProperty(name = "salt", value = "盐")
    private String salt;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    @ApiModelProperty(name = "age", value = "年龄")
    private Integer age;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    @ApiModelProperty(name = "email", value = "邮箱")
    private String email;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    @ApiModelProperty(name = "address", value = "地址")
    private String address;

    @TableField(exist = false)
    private List<Role> roles = new ArrayList<>();
}

