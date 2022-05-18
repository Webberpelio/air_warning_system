package com.air_research.airwarningsystem.response;

import lombok.Getter;

/**
 * @author zwell
 */
@Getter
public enum ResultEnum {

    OK(true, 200, "请求成功"),
    BAD_REQUEST(false, 400, "参数错误"),
    UNAUTHORIZED(false, 401, "未授权"),
    NOT_FOUND(false, 404, "找不到请求的资源"),
    TOKEN_NULL(false, 40301, "token为空"),
    TOKEN_ERROR(false, 40301, "token认证失败"),
    SERVICE_UNAVAILABLE(false, 500, "服务器故障");


    private Boolean success;
    private Integer code;
    private String message;

    /**
     * 枚举类的构造方法默认为private访问权限
     * @param success
     * @param code
     * @param message
     */
    private ResultEnum(boolean success, Integer code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }
}
