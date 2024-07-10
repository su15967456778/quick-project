package com.example.activity.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.activity.entity.ActivityTimeDetail;
import com.example.activity.service.ActivityService;
import com.example.activity.service.ActivityTimeDetailService;
import com.example.activity.service.IActivityHandler;
import com.example.activity.vo.HandlerConditionVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActivityTimeHandler extends IActivityHandler {

    @Autowired
    private ActivityTimeDetailService timeDetailService;

    @Autowired
    private ActivityService activityService;

    @Override
    public BigDecimal handle(HandlerConditionVo handlerConditionVo) {

        List<ActivityTimeDetail> timeDetails = timeDetailService.list(Wrappers.<ActivityTimeDetail>lambdaQuery()
                .eq(ActivityTimeDetail::getActivityId, handlerConditionVo.getActivityId())
                .ge(ActivityTimeDetail::getStartTime, LocalDateTime.now())
                .le(ActivityTimeDetail::getEndTime, LocalDateTime.now()));

        //如果符合活动条件，则继续向下搜索
        if (CollectionUtil.isNotEmpty(timeDetails)) {
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
