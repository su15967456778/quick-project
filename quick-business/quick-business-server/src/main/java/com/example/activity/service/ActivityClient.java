package com.example.activity.service;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.activity.entity.ActivityConditionClass;
import com.example.activity.entity.ActivityConditionDetail;
import com.example.activity.service.impl.ActivityStoreHandler;
import com.example.activity.service.impl.ActivityTimeHandler;
import com.example.activity.vo.HandlerConditionVo;
import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Service
public class ActivityClient {


    /**
     * 活动缓存
     */
    Cache<Integer, IActivityHandler> activityCache = Caffeine.newBuilder()
            .maximumSize(100)
            .expireAfterAccess(600L, TimeUnit.SECONDS)
            .build();


    @Autowired
    private ActivityConditionClassService conditionClassService;

    @Autowired
    private ActivityConditionDetailService conditionDetailService;

    public BigDecimal clientHandler(HandlerConditionVo handlerConditionVo) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        IActivityHandler activityHandler = activityCache.getIfPresent(handlerConditionVo.getActivityId());
        //查询缓存，如果没有就初始化
        if (activityHandler == null) {
            //查询活动条件
            List<ActivityConditionDetail> conditionDetails = conditionDetailService.list(Wrappers.<ActivityConditionDetail>lambdaQuery()
                    .eq(ActivityConditionDetail::getActivityId, handlerConditionVo.getActivityId()));

            List<Integer> conditionIds = conditionDetails.stream().map(ActivityConditionDetail::getActivityConditionId).collect(Collectors.toList());
            //查询活动条件对应的类
            List<ActivityConditionClass> activityConditionClasses = conditionClassService.listByIds(conditionIds);

            //装配这些活动
            //创建哑结点，找第0个节点创建
            IActivityHandler headHandler = (IActivityHandler) Class.forName(activityConditionClasses.get(0).getConditionClass()).newInstance();

            //创建前置节点，轮询用
            IActivityHandler preHandler = headHandler;
            for (int i = 1; i < activityConditionClasses.size(); i++) {
                IActivityHandler handler = (IActivityHandler) Class.forName(activityConditionClasses.get(i).getConditionClass()).newInstance();
                preHandler.nextHandler = handler;
                preHandler = preHandler.nextHandler;
                //重新赋值
                activityCache.put(handlerConditionVo.getActivityId(), activityHandler);
                activityHandler = headHandler;
            }
        }
        return activityHandler.handle(handlerConditionVo);
    }

}
