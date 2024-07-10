package com.example.activity.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.activity.entity.ActivityStoreDetail;
import com.example.activity.mapper.ActivityStoreDetailMapper;
import com.example.activity.service.ActivityStoreDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("activityStoreDetailService")
public class ActivityStoreDetailServiceImpl extends ServiceImpl<ActivityStoreDetailMapper, ActivityStoreDetail> implements ActivityStoreDetailService {


}