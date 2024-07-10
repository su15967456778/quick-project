package com.example.activity.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import lombok.Data;

/**
 * 活动时间表
 * 
 * @author 
 * @email 
 * @date 2024-07-10 19:03:41
 */
@Data
@TableName("activity_time_detail")
public class ActivityTimeDetail extends Model<ActivityTimeDetail> {

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
	 * 活动开始时间
	 */
	private LocalDateTime startTime;
	/**
	 * 活动结束时间
	 */
	private LocalDateTime endTime;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 更新时间
	 */
	private Date updateTime;

}
