package com.lgcy.blog.cloudblog.modules.sys.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lgcy.blog.api.admin.CbPlatSysDictGroupControllerApi;
import com.lgcy.blog.cloudblog.modules.sys.service.ICbPlatSysDictGroupService;
import com.lgcy.blog.domain.admin.CbPlatSysDictGroup;
import com.lgcy.blog.domain.admin.response.CbPlatSysCode;
import com.lgcy.blog.framework.exception.ExceptionCast;
import com.lgcy.blog.framework.model.response.CommonCode;
import com.lgcy.blog.framework.model.response.QueryResponseResult;
import com.lgcy.blog.framework.model.response.QueryResult;
import com.lgcy.blog.framework.model.response.ResponseResult;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @Description: 平台-系统-数据字典分组 前端控制器
 * @author: chenye
 * @date: 2019-11-01
 */
@Api(description = "平台-系统-数据字典分组接口详情")
@RestController
@RequestMapping("/sys/cb-plat-sys-dict-group")
public class CbPlatSysDictGroupController implements CbPlatSysDictGroupControllerApi {

    @Autowired
    private ICbPlatSysDictGroupService cbPlatSysDictGroupService;

    /**
     * 获取数据列表
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @Override
    public QueryResponseResult<CbPlatSysDictGroup> findListByPage(@RequestParam(name = "page", defaultValue = "1") int pageIndex, @RequestParam(name = "rows", defaultValue = "20") int step) {
        Page page = new Page(pageIndex, step);
        cbPlatSysDictGroupService.page(page);
        QueryResult<CbPlatSysDictGroup> queryResult = new QueryResult<>();
        long total = page.getTotal();
        List records = (List<CbPlatSysDictGroup>) page.getRecords();
        queryResult.setTotal(total);
        queryResult.setList(records);
        return new QueryResponseResult<CbPlatSysDictGroup>(CommonCode.SUCCESS, queryResult);
    }


    /**
     * 获取全部数据
     */
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @Override
    public QueryResponseResult<CbPlatSysDictGroup> findAll() {
        List<CbPlatSysDictGroup> models = cbPlatSysDictGroupService.list();
        QueryResult<CbPlatSysDictGroup> queryResult = new QueryResult<>();
        long total = models.size();
        queryResult.setTotal(total);
        queryResult.setList(models);
        return new QueryResponseResult<CbPlatSysDictGroup>(CommonCode.SUCCESS, queryResult);
    }


    /**
     * 根据ID查找数据
     */
    @RequestMapping(value = "/find", method = RequestMethod.GET)
    @Override
    public CbPlatSysDictGroup find(@RequestParam("id") String id) {
        CbPlatSysDictGroup cbPlatSysDictGroup = cbPlatSysDictGroupService.getById(id);
        if (cbPlatSysDictGroup == null) {
            ExceptionCast.cast(CbPlatSysCode.CB_PLAT_SYS_ISNULL);
        }
        return cbPlatSysDictGroup;
    }


    /**
     * 添加数据
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @Override
    public ResponseResult addItem(@RequestBody CbPlatSysDictGroup cbPlatSysDictGroup) {
        System.out.println(cbPlatSysDictGroup);
        cbPlatSysDictGroup.setCreateTime(new Date());

        boolean isOk = cbPlatSysDictGroupService.save(cbPlatSysDictGroup);
        if (isOk) {
            return new ResponseResult(CommonCode.SUCCESS);
        }
        return new ResponseResult(CbPlatSysCode.CB_PLAT_SYS_DELETE_ERROR);
    }


    /**
     * 更新数据
     */
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    @Override
    public ResponseResult updateItem(@RequestBody CbPlatSysDictGroup cbPlatSysDictGroup) {
        boolean isOk = cbPlatSysDictGroupService.updateById(cbPlatSysDictGroup);
        if (isOk) {
            return new ResponseResult(CommonCode.SUCCESS);
        }
        return new ResponseResult(CbPlatSysCode.CB_PLAT_SYS_DELETE_ERROR);
    }


    /**
     * 删除数据
     */
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    @Override
    public ResponseResult deleteItems(@RequestParam("ids") List<String> ids) {
        System.out.println(ids.toString());
        boolean isOk = cbPlatSysDictGroupService.removeByIds(ids);
        if (isOk) {
            return new ResponseResult(CommonCode.SUCCESS);
        }
        return new ResponseResult(CbPlatSysCode.CB_PLAT_SYS_DELETE_ERROR);
    }
}
 


