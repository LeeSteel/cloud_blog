package com.lgcy.blog.framework.model.response;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
public class QueryResponseResult<T> extends ResponseResult {

    QueryResult<T> queryResult;

    public QueryResponseResult(ResultCode resultCode, QueryResult<T> queryResult){
        super(resultCode);
        this.queryResult = queryResult;
    }

}
