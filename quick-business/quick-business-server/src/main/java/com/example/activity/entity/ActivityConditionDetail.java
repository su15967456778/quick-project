package com.example.activity.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 活动条件明细表
 * 
 * @author 
 * @email 
 * @date 2024-07-10 19:03:41
 */
@Data
@TableName("activity_condition_detail")
public class ActivityConditionDetail extends Model<ActivityConditionDetail> {

	/**
	 * 
	 */
	@TableId(type = IdType.AUTO)
	private Integer id;
	/**
	 * 活动id
	 */
	private Integer activityId;
	/**
	 * 活动责任类id
	 */
	private Integer activityConditionId;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 更新时间
	 */
	private Date updateTime;

}
