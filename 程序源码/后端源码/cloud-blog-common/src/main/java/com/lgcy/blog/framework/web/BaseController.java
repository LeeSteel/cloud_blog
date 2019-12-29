package com.lgcy.blog.framework.web;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @version V1.0
 * @Title:
 * @Package
 * @Description: TODO
 * @author: 李钢 2580704698@qq.com
 * @date: 2019/8/19 22:58
 * @Copyright: Copyright (c) 2019
 */
public class BaseController {

    protected HttpServletRequest request;

    protected HttpServletResponse response;

    protected HttpSession session;

    @ModelAttribute
    public void setReqAndRes(HttpServletRequest request, HttpServletResponse response) {

        this.request = request;

        this.response = response;

        this.session = request.getSession();

    }
}
