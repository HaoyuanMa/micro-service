package com.bhjx.accdoctor.fellow.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 陪诊员地址
 * 
 * @author mhy
 * @email mhy@bit.edu.cn
 * @date 2021-12-16 11:48:56
 */
@Data
@TableName("fms_fellow_address")
public class FellowAddressEntity implements Serializable {
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
	 * 陪诊员姓名
	 */
	private String name;
	/**
	 * 电话
	 */
	private String phone;
	/**
	 * 邮政编码
	 */
	private String postCode;
	/**
	 * 省份/直辖市
	 */
	private String province;
	/**
	 * 城市
	 */
	private String city;
	/**
	 * 区
	 */
	private String region;
	/**
	 * 详细地址(街道)
	 */
	private String detailAddress;
	/**
	 * 省市区代码
	 */
	private String areacode;
	/**
	 * 是否默认
	 */
	private Integer defaultStatus;

}
