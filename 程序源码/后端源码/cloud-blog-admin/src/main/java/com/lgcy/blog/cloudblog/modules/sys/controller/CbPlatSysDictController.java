package com.lgcy.blog.cloudblog.modules.sys.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import com.lgcy.blog.cloudblog.common.BaseController;
import lombok.extern.slf4j.Slf4j;
import com.lgcy.blog.cloudblog.modules.sys.service.ICbPlatSysDictService;
import com.lgcy.blog.cloudblog.modules.sys.entity.CbPlatSysDict;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.lgcy.blog.cloudblog.common.BaseResponse;

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
public class CbPlatSysDictController extends BaseController {

    @Autowired
    private ICbPlatSysDictService cbPlatSysDictService;
 
   /**
     * 获取数据列表
     */
        @ApiOperation(value="获取 平台-系统-数据字典 列表", notes="")
        @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "分页页数", required = true, dataType = "int"),
        @ApiImplicitParam(name = "rows", value = "分页大小", required = true, dataType = "int")
        })
    @RequestMapping(value="/list", method = RequestMethod.GET)
    public BaseResponse findListByPage(@RequestParam(name = "page", defaultValue = "1") int pageIndex,@RequestParam(name = "rows", defaultValue = "20") int step){
        Page page = new Page(pageIndex,step);
       cbPlatSysDictService.page(page);
        return BaseResponse.success(page);
    }


    /**
     * 获取全部数据
     */
    @RequestMapping(value="/all", method = RequestMethod.GET)
    public BaseResponse findAll(){
        List<CbPlatSysDict> models = cbPlatSysDictService.list();
        return BaseResponse.success(models);
    }


    /**
     * 根据ID查找数据
     */
    @RequestMapping(value="/find", method = RequestMethod.GET)
    public BaseResponse find(@RequestParam("id") Long id){
        CbPlatSysDict CbPlatSysDict = cbPlatSysDictService.getById(id);
        if(CbPlatSysDict==null){
            return BaseResponse.error("尚未查询到此ID");
        }
        return BaseResponse.success(CbPlatSysDict);
    }


    /**
     * 添加数据
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public BaseResponse addItem(@RequestBody CbPlatSysDict CbPlatSysDict){
        boolean isOk = cbPlatSysDictService.save(CbPlatSysDict);
        if(isOk){
            return BaseResponse.success("数据添加成功！");
        }
        return BaseResponse.error("数据添加失败");
    }


    /**
     * 更新数据
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public BaseResponse updateItem(@RequestBody CbPlatSysDict CbPlatSysDict){
        boolean isOk = cbPlatSysDictService.updateById(CbPlatSysDict);
        if(isOk){
            return BaseResponse.success("数据更改成功！");
        }
        return BaseResponse.error("数据更改失败");
     }


    /**
     * 删除数据
     */
    @RequestMapping(value="/del", method = RequestMethod.DELETE)
    @ResponseBody
    public BaseResponse deleteItems(@RequestParam("ids") List<Long> ids){
        boolean isOk = cbPlatSysDictService.removeByIds(ids);
        if(isOk){
            return BaseResponse.success("数据删除成功！");
        }
        return BaseResponse.error("数据删除失败");
        }
    }
 


