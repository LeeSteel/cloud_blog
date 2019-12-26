package com.lgcy.blog.cloudblog.modules.demo.entity;


import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.lgcy.blog.cloudblog.common.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @version V1.0
 * @Title:
 * @Package
 * @Description: 样例
 * @author: 李钢 2580704698@qq.com
 * @date: 2019-08-19
 * @Copyright: Copyright (c) 2019
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="Demo对象", description="样例")
public class Demo extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "自增编号")
    @TableId("id")
    private int id;

    @ApiModelProperty(value = "名称")
    @TableField("name")
    private String name;

    @ApiModelProperty(value = "创建时间")
    @TableField("create_date")
    private LocalDateTime createDate;

    @ApiModelProperty(value = "创建者")
    @TableField("create_by")
    private String createBy;


}
