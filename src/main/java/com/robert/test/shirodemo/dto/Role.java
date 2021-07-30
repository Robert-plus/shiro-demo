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
@TableName("t_role")
@ApiModel("角色实体类")
public class Role implements Serializable {
    /** 数据库中设置该字段自增时该注解不能少 **/
    @TableId(type = IdType.AUTO)
    @ApiModelProperty(name = "id", value = "ID 主键")
    private Integer id;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    @ApiModelProperty(name = "name", value = "角色名称")
    private String name;

    @TableField(exist = false)
    private List<Permission> permissions = new ArrayList<>();
}

