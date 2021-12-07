package com.bhjx.accdoctor.order.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 接单陪诊员
 * 
 * @author mhy
 * @email mhy@bit.edu.cn
 * @date 2021-12-07 20:25:58
 */
@Data
@TableName("oms_order_fellow")
public class OrderFellowEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private Long id;
	/**
	 * order_id
	 */
	private Long orderId;
	/**
	 * order_sn
	 */
	private String orderSn;
	/**
	 * fellow_id
	 */
	private Long fellowId;
	/**
	 * fellow姓名
	 */
	private String fellowName;
	/**
	 * fellow手机号码
	 */
	private String fellowMobile;
	/**
	 * fellow头像
	 */
	private String fellowPic;

}
