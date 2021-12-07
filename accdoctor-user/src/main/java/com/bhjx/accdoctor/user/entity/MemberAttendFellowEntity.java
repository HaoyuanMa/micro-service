package com.bhjx.accdoctor.user.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 用户关注的陪诊员
 * 
 * @author mhy
 * @email mhy@bit.edu.cn
 * @date 2021-12-05 20:39:39
 */
@Data
@TableName("ums_member_attend_fellow")
public class MemberAttendFellowEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private Long id;
	/**
	 * 用户id
	 */
	private Long memberId;
	/**
	 * 陪诊员id
	 */
	private Long fellowId;
	/**
	 * 陪诊员name
	 */
	private String fellowName;
	/**
	 * 陪诊员img
	 */
	private String fellowImg;
	/**
	 * create_time
	 */
	private Date createTime;

}
