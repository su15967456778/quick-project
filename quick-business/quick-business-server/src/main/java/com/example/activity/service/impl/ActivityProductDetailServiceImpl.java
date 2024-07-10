package com.example.activity.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.activity.entity.ActivityProductDetail;
import com.example.activity.mapper.ActivityProductDetailMapper;
import com.example.activity.service.ActivityProductDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("activityProductDetailService")
public class ActivityProductDetailServiceImpl extends ServiceImpl<ActivityProductDetailMapper, ActivityProductDetail> implements ActivityProductDetailService {


}