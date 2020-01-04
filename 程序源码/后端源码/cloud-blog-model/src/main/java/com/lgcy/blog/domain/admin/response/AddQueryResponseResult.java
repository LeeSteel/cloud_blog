package com.lgcy.blog.domain.admin.response;

import com.lgcy.blog.framework.model.response.QueryResult;
import com.lgcy.blog.framework.model.response.ResponseResult;
import com.lgcy.blog.framework.model.response.ResultCode;
import lombok.Data;
import lombok.ToString;

/**
 * @Author chenye
 * @Date 2019/12/29
 */
@Data
@ToString
public class AddQueryResponseResult extends ResponseResult {

    private Long id;

    public AddQueryResponseResult(ResultCode resultCode,Long id) {
        super(resultCode);
        this.id = id;
    }
}
