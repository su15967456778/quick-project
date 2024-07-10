package com.example.activity.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.activity.entity.ActivityConditionClass;
import com.example.activity.mapper.ActivityConditionClassMapper;
import com.example.activity.service.ActivityConditionClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("activityConditionClassService")
public class ActivityConditionClassServiceImpl extends ServiceImpl<ActivityConditionClassMapper, ActivityConditionClass> implements ActivityConditionClassService {


}