package com.lgcy.blog.cloudblog.modules.sys.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lgcy.blog.cloudblog.common.BaseController;
import com.lgcy.blog.cloudblog.common.BaseResponse;
import com.lgcy.blog.cloudblog.modules.sys.entity.CbPlatSysDictGroup;
import com.lgcy.blog.cloudblog.modules.sys.entity.CbPlatSysUser;
import com.lgcy.blog.cloudblog.modules.sys.service.ICbPlatSysDictGroupService;
import com.lgcy.blog.cloudblog.modules.sys.service.ICbPlatSysUserService;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * @Description: 平台-系统-数据字典分组 前端控制器
 * @author: chenye
 * @date: 2019-11-01
 */
@Slf4j
@Api(description = "平台-系统-数据字典分组接口详情")
@RestController
@RequestMapping("/sys/cb-plat-sys-dict-group")
public class CbPlatSysDictGroupController extends BaseController {

    @Autowired
    private ICbPlatSysDictGroupService cbPlatSysDictGroupService;

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
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public BaseResponse findListByPage(@RequestParam(name = "page", defaultValue = "1") int pageIndex, @RequestParam(name = "rows", defaultValue = "20") int step) {
        Page page = new Page(pageIndex, step);
        cbPlatSysDictGroupService.page(page);
        return BaseResponse.success(page);
    }


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
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public BaseResponse findAll() {
        List<CbPlatSysDictGroup> models = cbPlatSysDictGroupService.list();
        return BaseResponse.success(models);
    }


    /**
     * 根据ID查找数据
     */
    @ApiOperation(value = " 根据主键ID 获取 平台-系统-用户表 详情", notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "主键ID", required = true),
    })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful — 请求已完成"),
            @ApiResponse(code = 400, message = "请求中有语法问题，或不能满足请求"),
            @ApiResponse(code = 401, message = "未授权客户机访问数据"),
            @ApiResponse(code = 404, message = "服务器找不到给定的资源；文档不存在"),
            @ApiResponse(code = 500, message = "服务器不能完成请求")}
    )
    @RequestMapping(value = "/find", method = RequestMethod.GET)
    public BaseResponse find(@RequestParam("id") String id) {
        CbPlatSysDictGroup cbPlatSysDictGroup = cbPlatSysDictGroupService.getById(id);
        if (cbPlatSysDictGroup == null) {
            return BaseResponse.error("尚未查询到此ID");
        }
        return BaseResponse.success(cbPlatSysDictGroup);
    }


    /**
     * 添加数据
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public BaseResponse addItem(@RequestBody CbPlatSysDictGroup cbPlatSysDictGroup) {
        System.out.println(cbPlatSysDictGroup);
        cbPlatSysDictGroup.setCreateTime(new Date());

        boolean isOk = cbPlatSysDictGroupService.save(cbPlatSysDictGroup);
        if (isOk) {
            return BaseResponse.success("数据添加成功！");
        }
        return BaseResponse.error("数据添加失败");
    }


    /**
     * 更新数据
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public BaseResponse updateItem(@RequestBody CbPlatSysDictGroup cbPlatSysDictGroup) {
        boolean isOk = cbPlatSysDictGroupService.updateById(cbPlatSysDictGroup);
        if (isOk) {
            return BaseResponse.success("数据更改成功！");
        }
        return BaseResponse.error("数据更改失败");
    }


    /**
     * 删除数据
     */
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public BaseResponse deleteItems(@RequestParam("ids") List<String> ids) {
        System.out.println(ids.toString());
        boolean isOk = cbPlatSysDictGroupService.removeByIds(ids);
        if (isOk) {
            return BaseResponse.success("数据删除成功！");
        }
        return BaseResponse.error("数据删除失败");
    }
}
 


