package com.lgcy.blog.cloudblog.modules.demo.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lgcy.blog.cloudblog.common.BaseController;
import com.lgcy.blog.cloudblog.common.BaseResponse;
import com.lgcy.blog.cloudblog.modules.demo.entity.Demo;
import com.lgcy.blog.cloudblog.modules.demo.service.DemoService;
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
public class DemoController extends BaseController {


    @Autowired
    private DemoService demoService;

    /**
     * 获取数据列表
     */
    @RequestMapping("/list")
    @ResponseBody
    public BaseResponse findListByPage(@RequestParam(name = "page", defaultValue = "1") int pageIndex, @RequestParam(name = "rows", defaultValue = "20") int step) {
        Page page = new Page(pageIndex, step);
        demoService.page(page);
        return BaseResponse.success(page);
    }


    /**
     * 获取全部数据
     */
    @RequestMapping("/all")
    @ResponseBody
    public BaseResponse findAll() {
        List<Demo> models = demoService.list();
        return BaseResponse.success(models);
    }


    /**
     * 根据ID查找数据
     */
    @RequestMapping("/find")
    @ResponseBody
    public BaseResponse find(@RequestParam("id") Long id) {
        Demo demo = demoService.getById(id);
        if (demo == null) {
            return BaseResponse.error("尚未查询到此ID");
        }
        return BaseResponse.success(demo);
    }


    /**
     * 添加数据
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public BaseResponse addItem(@RequestBody Demo demo) {
        boolean isOk = demoService.save(demo);
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
    public BaseResponse updateItem(@RequestBody Demo demo) {
        boolean isOk = demoService.updateById(demo);
        if (isOk) {
            return BaseResponse.success("数据更改成功！");
        }
        return BaseResponse.error("数据更改失败");
    }


    /**
     * 删除数据
     */
    @RequestMapping("/del")
    @ResponseBody
    public BaseResponse deleteItems(@RequestParam("ids") List<Long> ids) {
        boolean isOk = demoService.removeByIds(ids);
        if (isOk) {
            return BaseResponse.success("数据删除成功！");
        }
        return BaseResponse.error("数据删除失败");
    }
}
 


