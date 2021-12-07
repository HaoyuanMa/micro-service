package com.bhjx.accdoctor.user.dao;

import com.bhjx.accdoctor.user.entity.UserAddressEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户地址
 * 
 * @author mhy
 * @email mhy@bit.edu.cn
 * @date 2021-12-07 17:40:13
 */
@Mapper
public interface UserAddressDao extends BaseMapper<UserAddressEntity> {
	
}
