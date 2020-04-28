package com.mic.pro.common.web.util;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 通用API返回
 *
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "请求返回基类", description = "请求返回基类")
public class ApiResult<T> {

    @ApiModelProperty(example = "0", required = true, value = "错误码", dataType = "integer")
    private int errcode;
    @ApiModelProperty(example = "服务器内部错误", required = true, value = "错误消息", dataType = "String")
    private String errmsg;
    private T data;

    public static ApiResult succ() {
        return new ApiResult(0, null, null);
    }

    public static <R> ApiResult<R> succ(R data) {
        return new ApiResult<R>(0, null, data);
    }

    public static ApiResult fail() {
        return new ApiResult(1, "服务器错误", null);
    }

    public static ApiResult fail(String errmsg) {
        return new ApiResult(1, errmsg, null);
    }

    public static ApiResult fail(int errcode, String errmsg) {
        return new ApiResult(errcode, errmsg, null);
    }

}
