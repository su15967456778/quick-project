package com.example.activity.vo;

import lombok.Data;

@Data
public class HandlerConditionVo {

    /**
     * 每添加一个条件，可以增加一个参数
     */

    private Integer activityId;

    private Long productId;

    private Long storeId;

}

