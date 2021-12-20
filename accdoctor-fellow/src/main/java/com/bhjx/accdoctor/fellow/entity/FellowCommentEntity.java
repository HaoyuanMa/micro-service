package com.bhjx.accdoctor.fellow.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 陪诊员评价
 * 
 * @author mhy
 * @email mhy@bit.edu.cn
 * @date 2021-12-16 11:48:56
 */
@Data
@TableName("fms_fellow_comment")
public class FellowCommentEntity implements Serializable {
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
	 * 陪诊员名字
	 */
	private String fellowName;
	/**
	 * 用户昵称
	 */

	private Long userId;

	private String userNickName;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 内容
	 */
	private String content;
	/**
	 * 用户头像
	 */
	private String userIcon;
	/**
	 * 评论类型[0 - 对商品的直接评论，1 - 对评论的回复]
	 */
	private Integer commentType;

}
