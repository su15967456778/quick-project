package com.example.activity.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.activity.entity.ActivityTimeDetail;
import com.example.activity.mapper.ActivityTimeDetailMapper;
import com.example.activity.service.ActivityTimeDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("activityTimeDetailService")
public class ActivityTimeDetailServiceImpl extends ServiceImpl<ActivityTimeDetailMapper, ActivityTimeDetail> implements ActivityTimeDetailService {


}