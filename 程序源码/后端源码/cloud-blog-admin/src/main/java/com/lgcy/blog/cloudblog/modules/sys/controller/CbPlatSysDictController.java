package com.lgcy.blog.cloudblog.modules.sys.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lgcy.blog.api.admin.CbPlatSysDictControllerApi;
import com.lgcy.blog.domain.admin.CbPlatSysDict;
import com.lgcy.blog.domain.admin.response.CbPlatSysCode;
import com.lgcy.blog.framework.exception.ExceptionCast;
import com.lgcy.blog.framework.model.response.*;
import com.lgcy.blog.framework.model.response.QueryResponseResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;
import com.lgcy.blog.cloudblog.modules.sys.service.ICbPlatSysDictService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @version V1.0
 * @Title:
 * @Package
 * @Description: 平台-系统-数据字典 前端控制器
 * @author: 李钢 2580704698@qq.com
 * @date: 2019-11-06
 * @Copyright: Copyright (c) 2019
 */

@Slf4j
@RestController
@RequestMapping("/sys/cb-plat-sys-dict")
public class CbPlatSysDictController implements CbPlatSysDictControllerApi {

    @Autowired
    private ICbPlatSysDictService cbPlatSysDictService;



    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @Override
    public QueryResponseResult<CbPlatSysDict> findListByPage(@RequestParam(name = "page", defaultValue = "1") int pageIndex, @RequestParam(name = "rows", defaultValue = "20") int step) {

        Page page = new Page(pageIndex, step);
        IPage iPage = cbPlatSysDictService.page(page);

        QueryResult<CbPlatSysDict> queryResult = new QueryResult<>();
        long total = iPage.getTotal();
        List list = (List<CbPlatSysDict>) iPage.orders();
        queryResult.setTotal(total);
        queryResult.setList(list);
        return new QueryResponseResult<CbPlatSysDict>(CommonCode.SUCCESS, queryResult);
    }

    /**
     * 获取全部数据
     */
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @Override
    public QueryResponseResult<CbPlatSysDict> findAll() {

        List<CbPlatSysDict> models = cbPlatSysDictService.list();
        if (models.size() <= 0) {
            ExceptionCast.cast(CbPlatSysCode.CB_PLAT_SYS_ISNULL);
        }
        QueryResult<CbPlatSysDict> queryResult = new QueryResult<>();
        long total = models.size();
        queryResult.setTotal(total);
        queryResult.setList(models);
        return new QueryResponseResult<>(CommonCode.SUCCESS, queryResult);
    }


    /**
     * 根据ID查找数据
     */
    @RequestMapping(value = "/find", method = RequestMethod.GET)
    @Override
    public CbPlatSysDict find(@RequestParam("id") Long id) {
        CbPlatSysDict CbPlatSysDict = cbPlatSysDictService.getById(id);
        if (CbPlatSysDict == null) {
            ExceptionCast.cast(CbPlatSysCode.CB_PLAT_SYS_ISNULL);
        }
        return CbPlatSysDict;
    }


    /**
     * 添加数据
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    @Override
    public ResponseResult addItem(@RequestBody CbPlatSysDict CbPlatSysDict) {
        boolean isOk = cbPlatSysDictService.save(CbPlatSysDict);
        if (isOk) {
            return new ResponseResult(CommonCode.SUCCESS);
        }
        return new ResponseResult(CbPlatSysCode.CB_PLAT_SYS_ADD_ERROR);
    }


    /**
     * 更新数据
     */
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    @ResponseBody
    @Override
    public ResponseResult updateItem(@RequestBody CbPlatSysDict CbPlatSysDict) {
        boolean isOk = cbPlatSysDictService.updateById(CbPlatSysDict);
        if (isOk) {
            return new ResponseResult(CommonCode.SUCCESS);
        }
        return new ResponseResult(CbPlatSysCode.CB_PLAT_SYS_UPDATE_ERROR);
    }


    /**
     * 删除数据
     */
    @RequestMapping(value = "/del", method = RequestMethod.DELETE)
    @ResponseBody
    @Override
    public ResponseResult deleteItems(@RequestParam("ids") List<Long> ids) {
        boolean isOk = cbPlatSysDictService.removeByIds(ids);
        if (isOk) {
            return new ResponseResult(CommonCode.SUCCESS);
        }
        return new ResponseResult(CbPlatSysCode.CB_PLAT_SYS_DELETE_ERROR);
    }

}

