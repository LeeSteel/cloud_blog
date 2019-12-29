package com.lgcy.blog.framework.exception;


import com.lgcy.blog.framework.model.response.ResultCode;

/**
 * @Author chenye
 * @Date 2019/11/21
 */
public class ExceptionCast {

    public static void cast(ResultCode resultCode){
        throw new CustomException(resultCode);
    }
}
