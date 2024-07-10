package com.example.activity.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.activity.entity.ActivityStoreDetail;
import com.example.activity.service.ActivityService;
import com.example.activity.service.ActivityStoreDetailService;
import com.example.activity.service.IActivityHandler;
import com.example.activity.vo.HandlerConditionVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ActivityStoreHandler extends IActivityHandler {

    @Autowired
    private ActivityStoreDetailService storeDetailService;

    @Autowired
    private ActivityService activityService;

    @Override
    public BigDecimal handle(HandlerConditionVo handlerConditionVo) {
        ActivityStoreDetail storeDetails = storeDetailService.getOne(Wrappers.<ActivityStoreDetail>lambdaQuery()
                .eq(ActivityStoreDetail::getStoreId, handlerConditionVo.getStoreId())
                .eq(ActivityStoreDetail::getActivityId, handlerConditionVo.getActivityId()).last("limit 0,1"));

        //如果符合活动条件，则继续向下搜索
        if (storeDetails != null) {
            if (hasNext()) {
                return nextHandler.handle(handlerConditionVo);
            } else {
                return activityService.getById(handlerConditionVo.getActivityId()).getDiscount();
            }
        }
        //如果不符合条件，返回该商品折扣率为100%
        return new BigDecimal("100");
    }
}
