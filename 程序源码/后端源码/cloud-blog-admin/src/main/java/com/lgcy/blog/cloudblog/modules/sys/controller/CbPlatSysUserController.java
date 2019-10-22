package com.lgcy.blog.cloudblog.modules.sys.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lgcy.blog.cloudblog.common.BaseController;
import com.lgcy.blog.cloudblog.common.BaseResponse;
import com.lgcy.blog.cloudblog.modules.sys.entity.CbPlatSysUser;
import com.lgcy.blog.cloudblog.modules.sys.service.ICbPlatSysUserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @version V1.0
 * @Title:
 * @Package
 * @Description: 平台-系统-用户表 前端控制器
 * @author: 李钢 2580704698@qq.com
 * @date: 2019-10-22
 * @Copyright: Copyright (c) 2019
 */

@Slf4j
@RestController
@RequestMapping("/sys/cb-plat-sys-user")
public class CbPlatSysUserController extends BaseController {

    @Autowired
    private ICbPlatSysUserService cbPlatSysUserService;

    /**
     * 获取数据列表
     */
    @ApiOperation(value = "获取 平台-系统-用户表 列表", notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "分页页数", required = true, dataType = "int"),
            @ApiImplicitParam(name = "rows", value = "分页大小", required = true, dataType = "int")
    })
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public BaseResponse findListByPage(@RequestParam(name = "page", defaultValue = "1") int pageIndex, @RequestParam(name = "rows", defaultValue = "20") int step) {
        Page page = new Page(pageIndex, step);
        cbPlatSysUserService.page(page);
        return BaseResponse.success(page);
    }


    /**
     * 获取全部数据
     */
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public BaseResponse findAll() {
        List<CbPlatSysUser> models = cbPlatSysUserService.list();
        return BaseResponse.success(models);
    }


    /**
     * 根据ID查找数据
     */
    @RequestMapping(value = "/find", method = RequestMethod.GET)
    public BaseResponse find(@RequestParam("id") Long id) {
        CbPlatSysUser CbPlatSysUser = cbPlatSysUserService.getById(id);
        if (CbPlatSysUser == null) {
            return BaseResponse.error("尚未查询到此ID");
        }
        return BaseResponse.success(CbPlatSysUser);
    }


    /**
     * 添加数据
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public BaseResponse addItem(@RequestBody CbPlatSysUser CbPlatSysUser) {
        boolean isOk = cbPlatSysUserService.save(CbPlatSysUser);
        if (isOk) {
            return BaseResponse.success("数据添加成功！");
        }
        return BaseResponse.error("数据添加失败");
    }


    /**
     * 更新数据
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public BaseResponse updateItem(@RequestBody CbPlatSysUser CbPlatSysUser) {
        boolean isOk = cbPlatSysUserService.updateById(CbPlatSysUser);
        if (isOk) {
            return BaseResponse.success("数据更改成功！");
        }
        return BaseResponse.error("数据更改失败");
    }


    /**
     * 删除数据
     */
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    @ResponseBody
    public BaseResponse deleteItems(@RequestParam("ids") List<Long> ids) {
        boolean isOk = cbPlatSysUserService.removeByIds(ids);
        if (isOk) {
            return BaseResponse.success("数据删除成功！");
        }
        return BaseResponse.error("数据删除失败");
    }
}
 


