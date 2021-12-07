package com.bhjx.accdoctor.fellow.dao;

import com.bhjx.accdoctor.fellow.entity.CommentReplayEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 评价回复关系
 * 
 * @author mhy
 * @email mhy@bit.edu.cn
 * @date 2021-12-07 20:34:03
 */
@Mapper
public interface CommentReplayDao extends BaseMapper<CommentReplayEntity> {
	
}
