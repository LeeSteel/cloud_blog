package com.lgcy.blog.cloudblog.modules.sys.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lgcy.blog.api.admin.CbPlatSysUserControllerApi;
import com.lgcy.blog.cloudblog.modules.sys.service.ICbPlatSysUserService;
import com.lgcy.blog.domain.admin.CbPlatSysDictGroup;
import com.lgcy.blog.domain.admin.CbPlatSysUser;
import com.lgcy.blog.domain.admin.response.CbPlatSysCode;
import com.lgcy.blog.framework.exception.ExceptionCast;
import com.lgcy.blog.framework.model.response.CommonCode;
import com.lgcy.blog.framework.model.response.QueryResponseResult;
import com.lgcy.blog.framework.model.response.QueryResult;
import com.lgcy.blog.framework.model.response.ResponseResult;
import io.swagger.annotations.*;
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
@Api(description = "平台-系统-用户表模块接口详情")
@RestController
@RequestMapping("/sys/cb-plat-sys-user")
public class CbPlatSysUserController implements CbPlatSysUserControllerApi {

    @Autowired
    private ICbPlatSysUserService cbPlatSysUserService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @Override
    public QueryResponseResult<CbPlatSysUser> findListByPage(@RequestParam(name = "page", defaultValue = "1") int pageIndex, @RequestParam(name = "rows", defaultValue = "20") int step) {
        Page page = new Page(pageIndex, step);
        IPage iPage = cbPlatSysUserService.page(page);
        QueryResult<CbPlatSysUser> queryResult = new QueryResult<>();
        long total = iPage.getTotal();
        List records = (List<CbPlatSysUser>) iPage.orders();
        queryResult.setTotal(total);
        queryResult.setList(records);
        return new QueryResponseResult<CbPlatSysUser>(CommonCode.SUCCESS, queryResult);
    }


    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @Override
    public QueryResponseResult<CbPlatSysUser> findAll() {
        List<CbPlatSysUser> models = cbPlatSysUserService.list();
        QueryResult<CbPlatSysUser> queryResult = new QueryResult<>();
        long total = models.size();
        queryResult.setTotal(total);
        queryResult.setList(models);
        return new QueryResponseResult<CbPlatSysUser>(CommonCode.SUCCESS, queryResult);
    }


    @RequestMapping(value = "/find", method = RequestMethod.GET)
    @Override
    public CbPlatSysUser find(@RequestParam("id") Long id) {
        CbPlatSysUser CbPlatSysUser = cbPlatSysUserService.getById(id);
        if (CbPlatSysUser == null) {
            ExceptionCast.cast(CbPlatSysCode.CB_PLAT_SYS_ISNULL);
        }
        return CbPlatSysUser;
    }


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @Override
    public ResponseResult addItem(@RequestBody CbPlatSysUser CbPlatSysUser) {
        boolean isOk = cbPlatSysUserService.save(CbPlatSysUser);
        if (isOk) {
            return new ResponseResult(CommonCode.SUCCESS);
        }
        return new ResponseResult(CbPlatSysCode.CB_PLAT_SYS_DELETE_ERROR);
    }


    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    @Override
    public ResponseResult updateItem(@RequestBody CbPlatSysUser CbPlatSysUser) {
        boolean isOk = cbPlatSysUserService.updateById(CbPlatSysUser);
        if (isOk) {
            return new ResponseResult(CommonCode.SUCCESS);
        }
        return new ResponseResult(CbPlatSysCode.CB_PLAT_SYS_DELETE_ERROR);
    }


    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    @Override
    public ResponseResult deleteItems(@RequestParam("ids") List<Long> ids) {
        boolean isOk = cbPlatSysUserService.removeByIds(ids);
        if (isOk) {
            return new ResponseResult(CommonCode.SUCCESS);
        }
        return new ResponseResult(CbPlatSysCode.CB_PLAT_SYS_DELETE_ERROR);
    }
}
 


