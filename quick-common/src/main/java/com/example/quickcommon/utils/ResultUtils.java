package com.example.quickcommon.utils;


import com.example.quickcommon.base.ResultVO;
import com.example.quickcommon.enums.ResultEnum;

public class ResultUtils {

    public static ResultVO success() {
        return success(null);
    }


    public static ResultVO success(String msg, Object data) {
        return buildResultVO(ResultEnum.SUCCESS.getCode(), msg, data);
    }

    public static ResultVO successData(String msg) {
        return buildResultVO(ResultEnum.SUCCESS.getCode(), null, msg);
    }

    public static ResultVO success(Object data) {
        return buildResultVO(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMsg(), data);
    }

    public static ResultVO error(Integer code, String msg) {
        return buildResultVO(code, msg, null);
    }

    public static ResultVO error(String msg) {
        return buildResultVO(ResultEnum.INTERNAL_SERVER_ERROR.getCode(), msg, null);
    }

    public static ResultVO error(ResultEnum resultEnum) {
        return buildResultVO(resultEnum.getCode(), resultEnum.getMsg(), null);
    }

    private static ResultVO buildResultVO(Integer code, String msg, Object data) {
        return ResultVO.builder().code(code).msg(msg).data(data).build();
    }
}
