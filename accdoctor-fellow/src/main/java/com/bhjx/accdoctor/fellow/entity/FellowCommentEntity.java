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
	private String userNickName;
	/**
	 * 用户ip
	 */
	private String userIp;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 显示状态[0-不显示，1-显示]
	 */
	private Integer showStatus;
	/**
	 * 点赞数
	 */
	private Integer likesCount;
	/**
	 * 回复数
	 */
	private Integer replyCount;
	/**
	 * 评论图片/视频[json数据；[{type:文件类型,url:资源路径}]]
	 */
	private String resources;
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
