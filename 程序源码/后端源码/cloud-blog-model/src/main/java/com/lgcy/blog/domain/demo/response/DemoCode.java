package com.lgcy.blog.domain.demo.response;

import com.google.common.collect.ImmutableMap;
import com.lgcy.blog.framework.model.response.ResultCode;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Author chenye
 * @Date 2019/12/29
 */
public enum DemoCode implements ResultCode {

    DEMO_ISNULL(false,20001,"样例不存在"),
    DEMO_ADD_ERROR(false,20002,"样例数据新增失败"),
    DEMO_UPDATE_ERROR(false,20003,"样例数据修改失败"),
    DEMO_DELETE_ERROR(false,20004,"样例数据删除失败");

    //操作代码
    @ApiModelProperty(value = "操作是否成功", example = "true", required = true)
    boolean success;

    //操作代码
    @ApiModelProperty(value = "操作代码", example = "20001", required = true)
    int code;

    //提示信息
    @ApiModelProperty(value = "操作提示", example = "操作过于频繁！", required = true)
    String message;

    private DemoCode(boolean success, int code, String message){
        this.success = success;
        this.code = code;
        this.message = message;
    }
    private static final ImmutableMap<Integer, DemoCode> CACHE;

    static {
        final ImmutableMap.Builder<Integer, DemoCode> builder = ImmutableMap.builder();
        for (DemoCode commonCode : values()) {
            builder.put(commonCode.code(), commonCode);
        }
        CACHE = builder.build();
    }

    @Override
    public boolean success() {
        return success;
    }

    @Override
    public int code() {
        return code;
    }

    @Override
    public String message() {
        return message;
    }

}
