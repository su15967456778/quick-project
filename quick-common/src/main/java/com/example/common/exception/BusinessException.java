package com.example.common.exception;


import com.example.common.enums.ResultEnum;

public class BusinessException extends RuntimeException {

    /**
     * 自定义错误码
     */
    private Integer code;

    public BusinessException() {
        this(ResultEnum.FAILURE);
    }

    /**
     * 自定义构造器，只保留一个，让其必须输入错误码及内容
     */
    public BusinessException(int code, String msg) {
        super(msg);
        this.code = code;
    }

    public BusinessException(String msg) {
        this(ResultEnum.FAILURE.getCode(), msg);
    }

    /**
     * 自定义构造器，只保留一个，让其必须输入错误码及内容
     */
    public BusinessException(ResultEnum resultEnum) {
        this(resultEnum.getCode(), resultEnum.getMsg());
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }


}
