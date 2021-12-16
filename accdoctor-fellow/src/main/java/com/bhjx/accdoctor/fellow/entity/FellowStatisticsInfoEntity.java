package com.bhjx.accdoctor.fellow.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 用户统计信息
 * 
 * @author mhy
 * @email mhy@bit.edu.cn
 * @date 2021-12-16 11:48:56
 */
@Data
@TableName("fms_fellow_statistics_info")
public class FellowStatisticsInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private Long id;
	/**
	 * fellow_id
	 */
	private Long fellowId;
	/**
	 * 累计收入金额
	 */
	private BigDecimal inputAmount;
	/**
	 * 订单数量
	 */
	private Integer orderCount;
	/**
	 * 评价数
	 */
	private Integer commentCount;
	/**
	 * 退货数量
	 */
	private Integer returnOrderCount;
	/**
	 * 登录次数
	 */
	private Integer loginCount;
	/**
	 * 关注数量
	 */
	private Integer attendCount;

}
