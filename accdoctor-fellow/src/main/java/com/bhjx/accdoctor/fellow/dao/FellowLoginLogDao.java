package com.bhjx.accdoctor.fellow.dao;

import com.bhjx.accdoctor.fellow.entity.FellowLoginLogEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员登录记录
 * 
 * @author mhy
 * @email mhy@bit.edu.cn
 * @date 2021-12-16 11:48:56
 */
@Mapper
public interface FellowLoginLogDao extends BaseMapper<FellowLoginLogEntity> {
	
}
