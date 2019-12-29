package com.lgcy.blog.api.admin;

import com.lgcy.blog.domain.admin.CbPlatSysUser;
import com.lgcy.blog.framework.model.response.QueryResponseResult;
import com.lgcy.blog.framework.model.response.ResponseResult;
import io.swagger.annotations.*;

import java.util.List;

/**
 * @Author chenye
 * @Date 2019/12/29
 */
@Api(value = "平台-系统-用户接口", description = "提供用户的增、删、改、查方法")
public interface CbPlatSysUserControllerApi {

    /**
     * 获取数据列表
     */
    @ApiOperation(value = " 分页 获取 平台-系统-用户表 列表", notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "分页页数", required = true, dataType = "int", defaultValue = "1"),
            @ApiImplicitParam(name = "rows", value = "分页大小", required = true, dataType = "int", defaultValue = "20")
    })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful — 请求已完成"),
            @ApiResponse(code = 400, message = "请求中有语法问题，或不能满足请求"),
            @ApiResponse(code = 401, message = "未授权客户机访问数据"),
            @ApiResponse(code = 404, message = "服务器找不到给定的资源；文档不存在"),
            @ApiResponse(code = 500, message = "服务器不能完成请求")}
    )
    QueryResponseResult<CbPlatSysUser> findListByPage(int pageIndex, int step);


    /**
     * 获取全部数据
     */
    @ApiOperation(value = "获取 平台-系统-用户表 所有数据列表", notes = "")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful — 请求已完成"),
            @ApiResponse(code = 400, message = "请求中有语法问题，或不能满足请求"),
            @ApiResponse(code = 401, message = "未授权客户机访问数据"),
            @ApiResponse(code = 404, message = "服务器找不到给定的资源；文档不存在"),
            @ApiResponse(code = 500, message = "服务器不能完成请求")}
    )
    QueryResponseResult<CbPlatSysUser> findAll();


    /**
     * 根据ID查找数据
     */
    @ApiOperation(value = " 根据主键ID 获取 平台-系统-用户表 详情", notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "主键ID", required = true, dataType = "Long"),
    })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful — 请求已完成"),
            @ApiResponse(code = 400, message = "请求中有语法问题，或不能满足请求"),
            @ApiResponse(code = 401, message = "未授权客户机访问数据"),
            @ApiResponse(code = 404, message = "服务器找不到给定的资源；文档不存在"),
            @ApiResponse(code = 500, message = "服务器不能完成请求")}
    )
    CbPlatSysUser find(Long id);


    /**
     * 添加数据
     */
    @ApiOperation(value = "平台-系统-用户表新增数据")
    ResponseResult addItem(CbPlatSysUser CbPlatSysUser);

    /**
     * 更新数据
     */
    @ApiOperation(value = "平台-系统-用户表新增数据")
    ResponseResult updateItem(CbPlatSysUser CbPlatSysUser);

    /**
     * 删除数据
     */
    @ApiOperation(value = "平台-系统-用户表新增数据")
    ResponseResult deleteItems(List<Long> ids);
    
}
