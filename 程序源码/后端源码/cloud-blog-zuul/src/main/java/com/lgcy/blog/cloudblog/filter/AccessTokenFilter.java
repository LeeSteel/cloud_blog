package com.lgcy.blog.cloudblog.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;
import com.netflix.zuul.context.RequestContext;
import javax.servlet.http.HttpServletRequest;
/**
 * @version V1.0
 * @Title:
 * @Package
 * @Description:  token 校验
 * @author: 李钢 2580704698@qq.com
 * @date: 2019/10/10 13:24
 * @Copyright: Copyright (c) 2019
 */
public class AccessTokenFilter  extends ZuulFilter {
    @Override
    public String filterType() {
        //前置过滤器
        return "pre";
    }

    @Override
    public int filterOrder() {
        //优先级为0，数字越大，优先级越低
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        //是否执行该过滤器，此处为true，说明需要过滤
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        String token = request.getParameter("token");
        //暂时简单化测试
        if (null != token && token.equals("cloud")) {
            // 对该请求进行路由
            ctx.setSendZuulResponse(true);
            ctx.setResponseStatusCode(200);
            // 设值，可以在多个过滤器时使用
            ctx.set("isSuccess", true);
            return null;
        } else {
            // 过滤该请求，不对其进行路由
            ctx.setSendZuulResponse(false);
            // 返回错误码
            ctx.setResponseStatusCode(403);
            // 返回错误内容
            ctx.setResponseBody("{\"result\":\"Request illegal!the token is null\"}");
            ctx.set("isSuccess", false);
            return null;
        }
    }
}
