package com.lgcy.blog.framework.model.response;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @Author chenye
 * @Date 2019/12/29
 */
@Data
@ToString
public class ResponseResult implements BaseResponse {

    //操作是否成功
    boolean success;

    //操作代码
    int code;

    //提示信息
    String message;

    public ResponseResult(){}

    public ResponseResult(ResultCode resultCode){
        this.success = resultCode.success();
        this.code = resultCode.code();
        this.message = resultCode.message();
    }

    public static ResponseResult SUCCESS(){
        return new ResponseResult(CommonCode.SUCCESS);
    }
    public static ResponseResult FAIL(){
        return new ResponseResult(CommonCode.FAIL);
    }
}
