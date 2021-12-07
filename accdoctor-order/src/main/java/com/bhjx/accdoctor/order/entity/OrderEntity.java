package com.bhjx.accdoctor.order.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 订单
 * 
 * @author mhy
 * @email mhy@bit.edu.cn
 * @date 2021-12-07 20:25:58
 */
@Data
@TableName("oms_order")
public class OrderEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private Long id;
	/**
	 * member_id
	 */
	private Long memberId;
	/**
	 * 订单号
	 */
	private String orderSn;
	/**
	 * create_time
	 */
	private Date createTime;
	/**
	 * 用户名
	 */
	private String userUsername;
	/**
	 * 订单总额
	 */
	private BigDecimal totalAmount;
	/**
	 * 应付总额
	 */
	private BigDecimal payAmount;
	/**
	 * 支付方式【1->支付宝；2->微信；3->银联； 4->货到付款；】
	 */
	private Integer payType;
	/**
	 * 订单来源[0->PC订单；1->app订单]
	 */
	private Integer sourceType;
	/**
	 * 订单状态【0->待付款；1->待接单；2->已接单；3->已完成；4->已关闭；5->无效订单】
	 */
	private Integer status;
	/**
	 * 用户姓名
	 */
	private String userName;
	/**
	 * 用户电话
	 */
	private String userPhone;
	/**
	 * 省份/直辖市
	 */
	private String userProvince;
	/**
	 * 城市
	 */
	private String userCity;
	/**
	 * 区
	 */
	private String userRegion;
	/**
	 * 详细地址
	 */
	private String userDetailAddress;
	/**
	 * 订单备注
	 */
	private String note;
	/**
	 * 删除状态【0->未删除；1->已删除】
	 */
	private Integer deleteStatus;
	/**
	 * 支付时间
	 */
	private Date paymentTime;
	/**
	 * 接单时间
	 */
	private Date deliveryTime;
	/**
	 * 结单时间
	 */
	private Date finishTime;
	/**
	 * 评价时间
	 */
	private Date commentTime;
	/**
	 * 修改时间
	 */
	private Date modifyTime;

}
