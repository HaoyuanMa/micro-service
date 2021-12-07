package com.bhjx.accdoctor.user.dao;

import com.bhjx.accdoctor.user.entity.MemberAddressEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户地址
 * 
 * @author mhy
 * @email mhy@bit.edu.cn
 * @date 2021-12-05 20:39:39
 */
@Mapper
public interface MemberAddressDao extends BaseMapper<MemberAddressEntity> {
	
}
