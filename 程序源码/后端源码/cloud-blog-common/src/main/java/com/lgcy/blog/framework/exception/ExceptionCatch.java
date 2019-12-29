package com.lgcy.blog.framework.exception;

import com.google.common.collect.ImmutableMap;
import com.lgcy.blog.framework.model.response.CommonCode;
import com.lgcy.blog.framework.model.response.ResponseResult;
import com.lgcy.blog.framework.model.response.ResultCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 异常统一捕获类
 * @Author chenye
 * @Date 2019/11/21
 */
@ControllerAdvice//控制器增强
public class ExceptionCatch {

    private static final Logger log = LoggerFactory.getLogger(ExceptionCatch.class);

    private static ImmutableMap<Class<? extends Throwable>, ResultCode> EXCEPTIONS;

    protected static ImmutableMap.Builder<Class<? extends Throwable>, ResultCode> builder = ImmutableMap.builder();

    /**
     * 捕获CustomException此类异常
     * @param customException
     * @return
     */
    @ExceptionHandler(CustomException.class)
    @ResponseBody
    public ResponseResult customException(CustomException customException){
        //错误打印
//        customException.printStackTrace();
        //记录日志
        log.error("cetch exception:{}", customException.getMessage());
        ResultCode resultCode = customException.getResultCode();
        return new ResponseResult(resultCode);
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseResult exception(Exception exception){
        //错误信息打印
//        exception.printStackTrace();
        //记录日志
        log.error("cetch exception:{}", exception.getMessage());
        if (EXCEPTIONS == null) {
            EXCEPTIONS = builder.build();
        }
        ResultCode resultCode = EXCEPTIONS.get(exception.getClass());
        if (resultCode != null) {
            return new ResponseResult(resultCode);
        } else {
            return new ResponseResult(CommonCode.SERVER_ERROR);
        }
    }


    static {
        builder.put(HttpMessageNotReadableException.class, CommonCode.INVALID_PARAM);
    }

}
