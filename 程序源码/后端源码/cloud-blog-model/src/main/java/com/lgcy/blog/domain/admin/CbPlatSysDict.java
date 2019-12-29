package com.lgcy.blog.domain.admin;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @version V1.0
 * @Title:
 * @Package
 * @Description: 平台-系统-数据字典
 * @author: 李钢 2580704698@qq.com
 * @date: 2019-11-06
 * @Copyright: Copyright (c) 2019
 */
@Data
@Accessors(chain = true)
@ToString
@TableName("cb_plat_sys_dict")
@ApiModel(value="CbPlatSysDict对象", description="平台-系统-数据字典")
public class CbPlatSysDict implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "所属分组id")
    @TableField("group_id")
    private String groupId;

    @ApiModelProperty(value = "字典名称")
    @TableField("name")
    private String name;

    @ApiModelProperty(value = "字典值")
    @TableField("value")
    private String value;

    @ApiModelProperty(value = "父级编号")
    @TableField("parent_id")
    private String parentId;

    @ApiModelProperty(value = "排序号")
    @TableField("sort")
    private Integer sort;

    @ApiModelProperty(value = "状态码")
    @TableField("status")
    private Integer status;

    @ApiModelProperty(value = "备注")
    @TableField("remark")
    private String remark;


}
