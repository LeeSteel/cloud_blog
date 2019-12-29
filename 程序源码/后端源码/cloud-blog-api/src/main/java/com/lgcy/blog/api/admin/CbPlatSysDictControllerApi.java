package com.lgcy.blog.api.admin;

import com.lgcy.blog.domain.admin.CbPlatSysDict;
import com.lgcy.blog.framework.model.response.QueryResponseResult;
import com.lgcy.blog.framework.model.response.QueryResult;
import com.lgcy.blog.framework.model.response.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import java.util.List;

/**
 * @Author chenye
 * @Date 2019/12/28
 */
@Api(value = "平台-系统-数据字典接口", description = "用于维护数据字典，对其进行增、删、改、查操作")
public interface CbPlatSysDictControllerApi {
    /**
     * 获取数据列表
     */
    @ApiOperation(value="获取 平台-系统-数据字典 列表", notes="")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "分页页数", required = true, dataType = "int"),
            @ApiImplicitParam(name = "rows", value = "分页大小", required = true, dataType = "int")
    })
    public QueryResponseResult<CbPlatSysDict> findListByPage(int pageIndex, int step);


    /**
     * 获取全部数据
     */
    @ApiOperation(value = "查询数据字典全部数据")
    public QueryResponseResult<CbPlatSysDict> findAll();


    /**
     * 根据ID查找数据
     */
    @ApiOperation(value = "依据ID查询数据字典数据")
    public CbPlatSysDict find(Long id);

    /**
     * 添加数据
     */
    @ApiOperation(value = "新增数据字典数据")
    public ResponseResult addItem(CbPlatSysDict CbPlatSysDict);


    /**
     * 更新数据
     */
    @ApiOperation(value = "修改数据字典数据")
    public ResponseResult updateItem(CbPlatSysDict CbPlatSysDict);


    /**
     * 删除数据
     */
    @ApiOperation(value = "删除数据字典数据")
    public ResponseResult deleteItems(List<Long> ids);

}



