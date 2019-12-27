package com.lgcy.blog.cloudblog.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableName;
import com.lgcy.blog.cloudblog.common.BaseEntity;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
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
 * @Description: 平台-系统-数据字典分组
 * @author: 李钢 2580704698@qq.com
 * @date: 2019-11-05
 * @Copyright: Copyright (c) 2019
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("cb_plat_sys_dict_group")
@ApiModel(value="CbPlatSysDictGroup对象", description="平台-系统-数据字典分组")
public class CbPlatSysDictGroup extends BaseEntity {
   private static final long serialVersionUID = 1L;

    @TableId(value="id", type = IdType.UUID)
    private String id;

    @ApiModelProperty(value = "分组编码")
    @TableField("code")
    private String code;

    @ApiModelProperty(value = "分组名称")
    @TableField("name")
    private String name;

    @ApiModelProperty(value = "创建时间")
    @TableField("create_time")
    private Date createTime;

    @ApiModelProperty(value = "备注")
    @TableField("remark")
    private String remark;


}
