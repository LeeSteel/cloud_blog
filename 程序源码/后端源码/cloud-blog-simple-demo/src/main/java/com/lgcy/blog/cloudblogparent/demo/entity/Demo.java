package com.lgcy.blog.cloudblogparent.demo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @version V1.0
 * @Title:
 * @Package
 * @Description: TODO
 * @author: 李钢 2580704698@qq.com
 * @date: 2019/8/19 0:23
 * @Copyright: Copyright (c) 2019
 */
@Data
@TableName("demo")
public class Demo implements Serializable {
    /**
     * 主键
     */
    private int id;
    /**
     * 名称
     */
    private String name;
}
