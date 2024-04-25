package com.example.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResultEnum {
    OK(0,"成功"),
    SUCCESS(200, "操作成功"),
    FAILURE(400, "业务异常"),
    UN_AUTHORIZED(401, "请求未授权或登录已过期"),
    FORBIDDEN(402, "您的账号已被禁用，如有疑问，请联系客服。"),
    NOT_FOUND(404, "404 没找到请求"),
    MSG_NOT_READABLE(400, "消息不能读取"),
    METHOD_NOT_SUPPORTED(405, "不支持当前请求方法"),
    MEDIA_TYPE_NOT_SUPPORTED(415, "不支持当前媒体类型"),
    REQ_REJECT(403, "请求被拒绝"),
    INTERNAL_SERVER_ERROR(500, "服务器异常"),
    PARAM_MISS(400, "缺少必要的请求参数"),
    PARAM_TYPE_ERROR(400, "请求参数类型错误"),
    PARAM_BIND_ERROR(400, "请求参数绑定错误"),
    PARAM_VALID_ERROR(400, "参数校验失败"),
    PARAMS_CONVERSION_EXCEPTION(400, "参数转换异常"),
    NO_AUTHORITY(400, "用户无权限访问"),

    ACCOUNT_ALREADY_EXIST(600,"账号已存在"),
    USERNAME_ALREADY_EXIST(601,"用户名已存在"),
    MAX_UPLOAD_SIZE_EXCEEDED_EXCEPTION(700, "上传文件大小超过限制"),
    DATA_INTERGRITY_VIOLATION_EXCEPTION(800, "数据完整性违反异常"),

    FEILE_NOT_FOUND(404, "404 没找到请求"),

    WX_ORDER_ERROR(501,"微信下单异常"),

    WX_ORDER_CALLBACK_ERROR(502,"微信下单回调异常"),

    WX_ORDER_CALLBACK_FAILURE(503,"微信下单回调业务异常"),

    WX_QUERY_ORDER_ERROR(504,"微信查询订单异常"),

    WX_CLOSE_ORDER_ERROR(505,"微信关闭订单异常"),

    WX_TRANSFERS_ORDER_ERROR(506,"微信提现订单异常");

    final int code;
    final String msg;
}
