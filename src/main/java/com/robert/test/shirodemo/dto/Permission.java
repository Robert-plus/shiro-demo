package com.robert.test.shirodemo.dto;


import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author Christy
 * @DESC
 * @Date 2020/11/16 15:38
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("t_permission")
@ApiModel("权限实体类")
public class Permission implements Serializable {
    /** 数据库中设置该字段自增时该注解不能少 **/
    @TableId(type = IdType.AUTO)
    @ApiModelProperty(name = "id", value = "ID主键")
    private Integer id;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    @ApiModelProperty(name = "name", value = "权限名称")
    private String name;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    @ApiModelProperty(name = "url", value = "权限菜单URL")
    private String url;
}
