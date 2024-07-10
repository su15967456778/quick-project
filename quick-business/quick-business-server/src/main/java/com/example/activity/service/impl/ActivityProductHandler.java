package com.example.activity.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.activity.entity.ActivityProductDetail;
import com.example.activity.entity.ActivityTimeDetail;
import com.example.activity.service.ActivityProductDetailService;
import com.example.activity.service.ActivityService;
import com.example.activity.service.IActivityHandler;
import com.example.activity.vo.HandlerConditionVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ActivityProductHandler extends IActivityHandler {

    @Autowired
    private ActivityProductDetailService activityProductDetailService;

    @Autowired
    private ActivityService activityService;

    @Override
    public BigDecimal handle(HandlerConditionVo handlerConditionVo) {
        List<ActivityProductDetail> productDetails = activityProductDetailService.list(Wrappers.<ActivityProductDetail>lambdaQuery()
                .eq(ActivityProductDetail::getActivityId, handlerConditionVo.getActivityId())
                .eq(ActivityProductDetail::getProductId, handlerConditionVo.getProductId()));

        //如果符合活动条件，则继续向下搜索
        if (CollectionUtil.isNotEmpty(productDetails)) {
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
