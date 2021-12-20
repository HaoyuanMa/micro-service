package com.bhjx.accdoctor.order.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 订单退货申请
 * 
 * @author mhy
 * @email mhy@bit.edu.cn
 * @date 2021-12-19 13:50:01
 */
@Data
@TableName("oms_order_return_apply")
public class OrderReturnApplyEntity implements Serializable {
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
	 * fellow_id
	 */
	private Long fellowId;
	/**
	 * 订单编号
	 */
	private String orderSn;
	/**
	 * 申请时间
	 */
	private Date createTime;
	/**
	 * 用户名
	 */
	private String userUsername;
	/**
	 * 退款金额
	 */
	private BigDecimal returnAmount;
	/**
	 * 退款人姓名
	 */
	private String returnName;
	/**
	 * 退款人电话
	 */
	private String returnPhone;
	/**
	 * 申请状态[0->待处理；1->退款中；2->已完成；3->已拒绝]
	 */
	private Integer status;
	/**
	 * 处理时间
	 */
	private Date handleTime;
	/**
	 * 原因
	 */
	private String reason;
	/**
	 * 描述
	 */
	private String description;
	/**
	 * 凭证图片，以逗号隔开
	 */
	private String descPics;
	/**
	 * 处理备注
	 */
	private String handleNote;
	/**
	 * 处理人员
	 */
	private String handleMan;

}
