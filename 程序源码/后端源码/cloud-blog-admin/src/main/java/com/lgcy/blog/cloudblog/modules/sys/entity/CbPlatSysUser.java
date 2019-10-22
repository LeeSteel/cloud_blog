package com.lgcy.blog.cloudblog.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.lgcy.blog.cloudblog.common.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @version V1.0
 * @Title:
 * @Package
 * @Description: 平台-系统-用户表
 * @author: 李钢 2580704698@qq.com
 * @date: 2019-10-22
 * @Copyright: Copyright (c) 2019
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("cb_plat_sys_user")
@ApiModel(value="CbPlatSysUser对象", description="平台-系统-用户表")
public class CbPlatSysUser extends BaseEntity {
   private static final long serialVersionUID = 1L;

    @TableId(value = "user_id", type = IdType.AUTO)
    private Long userId;

    @ApiModelProperty(value = "用户名")
    @TableField("user_name")
    private String userName;

    @TableField("real_name")
    private String realName;

    @ApiModelProperty(value = "性别")
    @TableField("sex")
    private Integer sex;

    @ApiModelProperty(value = "机构编码")
    @TableField("org_no")
    private String orgNo;

    @ApiModelProperty(value = "盐")
    @TableField("salt")
    private String salt;

    @ApiModelProperty(value = "邮件服务器地址")
    @TableField("email_host")
    private String emailHost;

    @ApiModelProperty(value = "邮箱")
    @TableField("email")
    private String email;

    @ApiModelProperty(value = "用户邮箱密码")
    @TableField("email_pw")
    private String emailPw;

    @ApiModelProperty(value = "手机号")
    @TableField("mobile")
    private String mobile;

    @ApiModelProperty(value = "状态  0：禁用   1：正常")
    @TableField("status")
    private Integer status;

    @ApiModelProperty(value = "密码")
    @TableField("password")
    private String password;

    @ApiModelProperty(value = "创建者id")
    @TableField("create_user_id")
    private String createUserId;

    @ApiModelProperty(value = "创建人所属机构")
    @TableField("create_user_org_no")
    private String createUserOrgNo;

    @ApiModelProperty(value = "创建时间")
    @TableField("create_time")
    private LocalDateTime createTime;


}
