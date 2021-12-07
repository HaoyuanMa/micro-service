package com.bhjx.accdoctor.user.dao;

import com.bhjx.accdoctor.user.entity.MemberAttendFellowEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户关注的陪诊员
 * 
 * @author mhy
 * @email mhy@bit.edu.cn
 * @date 2021-12-05 20:39:39
 */
@Mapper
public interface MemberAttendFellowDao extends BaseMapper<MemberAttendFellowEntity> {
	
}
