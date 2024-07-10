package com.example.activity.service;

import com.example.activity.vo.HandlerConditionVo;

import java.math.BigDecimal;

public abstract class IActivityHandler {

    public IActivityHandler nextHandler;

    public boolean hasNext() {
        return this.nextHandler != null;
    }

    /**
     * 查询这个商品符不符合这个活动并且返回折扣率
     */
    public abstract BigDecimal handle(HandlerConditionVo handlerConditionVo);



}
