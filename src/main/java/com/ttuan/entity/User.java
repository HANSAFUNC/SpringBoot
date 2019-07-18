package com.ttuan.entity;


import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.stereotype.Component;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("user")
public class User implements Serializable {
    @TableId(type = IdType.ID_WORKER_STR)
    private String uid;

    @ApiModelProperty(value = "用户名")
    @TableField(value = "user_name")
    private String userName;

    @TableField(value = "user_nickName")
    private String nickName;

    @ApiModelProperty(value = "年龄")
    @TableField(exist = false)
    private int age;

    @ApiModelProperty(value = "头像")
    private String userHeadImg;

    @ApiModelProperty(value = "账号")
    private String account;

    @ApiModelProperty(value = "密码")
    private String pwd;



}
