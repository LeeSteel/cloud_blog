package com.lgcy.blog.framework.exception;


import com.lgcy.blog.framework.model.response.ResultCode;

/**
 * @Author chenye
 * @Date 2019/11/21
 */
public class CustomException extends RuntimeException {

    private ResultCode resultCode;

    public CustomException(ResultCode resultCode) {
        this.resultCode = resultCode;
    }

    public ResultCode getResultCode(){
        return resultCode;
    }
}
