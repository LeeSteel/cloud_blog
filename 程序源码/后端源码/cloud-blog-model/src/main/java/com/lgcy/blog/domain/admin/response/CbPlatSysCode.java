package com.lgcy.blog.domain.admin.response;

import com.google.common.collect.ImmutableMap;
import com.lgcy.blog.framework.model.response.ResultCode;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Author chenye
 * @Date 2019/12/29
 */
public enum CbPlatSysCode implements ResultCode {

    CB_PLAT_SYS_ISNULL(false,22001,"平台数据不存在"),
    CB_PLAT_SYS_ADD_ERROR(false,22002,"平台数据新增失败"),
    CB_PLAT_SYS_UPDATE_ERROR(false,22003,"平台数据修改失败"),
    CB_PLAT_SYS_DELETE_ERROR(false,22004,"平台数据删除失败"),
    CB_PLAT_SYS_ADD_DOUBLE_ERROR(false,22005,"平台数据重复新增");

    //操作代码
    @ApiModelProperty(value = "操作是否成功", example = "true", required = true)
    boolean success;

    //操作代码
    @ApiModelProperty(value = "操作代码", example = "22001", required = true)
    int code;

    //提示信息
    @ApiModelProperty(value = "操作提示", example = "操作过于频繁！", required = true)
    String message;

    private CbPlatSysCode(boolean success, int code, String message){
        this.success = success;
        this.code = code;
        this.message = message;
    }
    private static final ImmutableMap<Integer, CbPlatSysCode> CACHE;

    static {
        final ImmutableMap.Builder<Integer, CbPlatSysCode> builder = ImmutableMap.builder();
        for (CbPlatSysCode commonCode : values()) {
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
