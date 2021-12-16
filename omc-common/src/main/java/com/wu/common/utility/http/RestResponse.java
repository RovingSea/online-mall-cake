package com.wu.common.utility.http;

import lombok.Data;

/**
 * 接口统一响应体
 * @author Haixin Wu
 * @date 2021/12/16
 * @time 13:03
 * @since 1.0
 */
@Data
public class RestResponse<T> {
    private int code;
    private String msg;
    private T response;

    public RestResponse(int code, String message) {
        this.code = code;
        this.msg = message;
    }

    public RestResponse(int code, String message, T response) {
        this.code = code;
        this.msg = message;
        this.response = response;
    }

    public static RestResponse ok() {
        SystemCode systemCode = SystemCode.OK;
        return new RestResponse(systemCode.getCode(), systemCode.getMessage());
    }

    public static RestResponse failure() {
        SystemCode systemCode = SystemCode.Failure;
        return new RestResponse<>(systemCode.getCode(), systemCode.getMessage());
    }

    public static <F> RestResponse<F> ok(F response) {
        SystemCode systemCode = SystemCode.OK;
        return new RestResponse<>(systemCode.getCode(), systemCode.getMessage(), response);
    }

    public static <F> RestResponse<F> failure(F response) {
        SystemCode systemCode = SystemCode.Failure;
        return new RestResponse<>(systemCode.getCode(), systemCode.getMessage(), response);
    }
}

