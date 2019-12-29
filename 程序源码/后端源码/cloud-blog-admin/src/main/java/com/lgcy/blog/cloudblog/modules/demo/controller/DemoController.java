package com.lgcy.blog.cloudblog.modules.demo.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lgcy.blog.api.demo.DemoControllerApi;
import com.lgcy.blog.cloudblog.modules.demo.service.DemoService;
import com.lgcy.blog.domain.demo.Demo;
import com.lgcy.blog.domain.demo.response.DemoCode;
import com.lgcy.blog.framework.exception.ExceptionCast;
import com.lgcy.blog.framework.model.response.CommonCode;
import com.lgcy.blog.framework.model.response.QueryResponseResult;
import com.lgcy.blog.framework.model.response.QueryResult;
import com.lgcy.blog.framework.model.response.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

/**
 * @version V1.0
 * @Title:
 * @Package
 * @Description: 样例 前端控制器
 * @author: 李钢 2580704698@qq.com
 * @date: 2019-08-19
 * @Copyright: Copyright (c) 2019
 */
@RestController
@RequestMapping("/demo/demo")
@Slf4j
public class DemoController implements DemoControllerApi {


    @Autowired
    private DemoService demoService;

    @RequestMapping("/list")
    @ResponseBody
    @Override
    public QueryResponseResult<Demo> findListByPage(@RequestParam(name = "page", defaultValue = "1") int pageIndex, @RequestParam(name = "rows", defaultValue = "20") int step) {
        Page page = new Page(pageIndex, step);
        demoService.page(page);
        QueryResult<Demo> queryResult = new QueryResult<>();
        long total = page.getTotal();
        List list = (List<Demo>) page.getRecords();
        queryResult.setTotal(total);
        queryResult.setList(list);
        return new QueryResponseResult<Demo>(CommonCode.SUCCESS, queryResult);
    }


    @RequestMapping("/all")
    @ResponseBody
    @Override
    public QueryResponseResult<Demo> findAll() {
        List<Demo> models = demoService.list();

        QueryResult<Demo> queryResult = new QueryResult<>();
        long total = models.size();
        queryResult.setTotal(total);
        queryResult.setList(models);
        return new QueryResponseResult<Demo>(CommonCode.SUCCESS, queryResult);
    }


    @RequestMapping("/find")
    @ResponseBody
    @Override
    public Demo find(@RequestParam("id") Long id) {
        Demo demo = demoService.getById(id);
        if (demo == null) {
            ExceptionCast.cast(DemoCode.DEMO_ISNULL);
        }
        return demo;
    }


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    @Override
    public ResponseResult addItem(@RequestBody Demo demo) {
        boolean isOk = demoService.save(demo);
        if (isOk) {
            return new ResponseResult(CommonCode.SUCCESS);
        }
        return new ResponseResult(DemoCode.DEMO_ADD_ERROR);
    }


    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    @ResponseBody
    @Override
    public ResponseResult updateItem(@RequestBody Demo demo) {
        boolean isOk = demoService.updateById(demo);
        if (isOk) {
            return new ResponseResult(CommonCode.SUCCESS);
        }
        return new ResponseResult(DemoCode.DEMO_UPDATE_ERROR);
    }


    @RequestMapping("/del")
    @ResponseBody
    @Override
    public ResponseResult deleteItems(@RequestParam("ids") List<Long> ids) {
        boolean isOk = demoService.removeByIds(ids);
        if (isOk) {
            return new ResponseResult(CommonCode.SUCCESS);
        }
        return new ResponseResult(DemoCode.DEMO_DELETE_ERROR);
    }
}
 


