package com.example.activity.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 活动表
 * 
 * @author 
 * @email 
 * @date 2024-07-10 19:03:41
 */
@Data
@TableName("activity")
public class Activity extends Model<Activity> {

	/**
	 * 
	 */
	@TableId(type = IdType.AUTO)
	private Integer id;
	/**
	 * 活动名称
	 */
	private String activityName;
	/**
	 * 折扣
	 */
	private BigDecimal discount;
	/**
	 * 状态0未开始 1进行中 2已结束
	 */
	private Integer status;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 更新时间
	 */
	private Date updateTime;

}
