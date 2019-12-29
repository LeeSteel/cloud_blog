package com.lgcy.blog.domain.admin;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.Date;

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
@Accessors(chain = true)
@ToString
@TableName("cb_plat_sys_dict_group")
@ApiModel(value="CbPlatSysDictGroup对象", description="平台-系统-数据字典分组")
public class CbPlatSysDictGroup {
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
