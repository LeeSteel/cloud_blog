package com.lgcy.blog.api.demo;

import com.lgcy.blog.domain.demo.Demo;
import com.lgcy.blog.framework.model.response.QueryResponseResult;
import com.lgcy.blog.framework.model.response.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;

/**
 * @Author chenye
 * @Date 2019/12/29
 */
@Api(value = "样例接口", description = "提供增、删、改、查的规范例子")
public interface DemoControllerApi {

    /**
     * 获取数据列表
     */
    @ApiOperation(value = "获取数据列表")
    QueryResponseResult<Demo> findListByPage(int pageIndex, int step);


    /**
     * 获取全部数据
     */
    @ApiOperation(value = "获取全部数据")
    QueryResponseResult<Demo> findAll();


    /**
     * 根据ID查找数据
     */
    @ApiOperation("根据ID查找数据")
    Demo find(Long id);


    /**
     * 添加数据
     */
    @ApiOperation("添加数据")
    ResponseResult addItem(Demo demo);


    /**
     * 更新数据
     */
    @ApiOperation("更新数据")
    ResponseResult updateItem(Demo demo);


    /**
     * 删除数据
     */
    @ApiOperation("删除数据")
    ResponseResult deleteItems(List<Long> ids);
}
