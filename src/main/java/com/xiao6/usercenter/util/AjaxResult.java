package com.xiao6.usercenter.util;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author meiwenjun
 * @Description
 * @create 2018-04-10 17:25
 **/
@ApiModel(description= "返回响应数据")
public class AjaxResult {

    public static final int CODE_SUCCESS = 0;

    public static final int CODE_FAILED = 1;

    @ApiModelProperty(value = "响应码 1:成功")
    private int code;
    @ApiModelProperty(value = "消息提示")
    private String message;
    @ApiModelProperty(value = "返回对象数据")
    private Object data;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public Object getData() {
        return data;
    }

    @ApiModelProperty(value = "是否成功")
    public boolean isSuccess() {
        return CODE_SUCCESS == code;
    }

    private AjaxResult(int code, Object data, String message) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public AjaxResult(int code, String message) {
        this.code=code;
        this.message=message;
    }

    public static final AjaxResult success() {
        return new AjaxResult(CODE_SUCCESS, null, null);
    }

    public static final AjaxResult success(Object data) {
        return new AjaxResult(CODE_SUCCESS, data, null);
    }

    public static final AjaxResult success(String message) {
        return new AjaxResult(CODE_SUCCESS, null, message);
    }

    public static final AjaxResult success(Object data, String message) {
        return new AjaxResult(CODE_SUCCESS, data, message);
    }

    public static final AjaxResult failed() {
        return new AjaxResult(CODE_FAILED, null, null);
    }

    public static final AjaxResult failed(String message) {
        return new AjaxResult(CODE_FAILED, null, message);
    }

    public static final AjaxResult failed(Object data, String message) {
        return new AjaxResult(CODE_FAILED, data, message);
    }

    public static final AjaxResult failed(Object data) {
        return new AjaxResult(CODE_FAILED, data, "");
    }
}


