package com.bhjx.accdoctor.order.dao;

import com.bhjx.accdoctor.order.entity.OrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单
 * 
 * @author mhy
 * @email mhy@bit.edu.cn
 * @date 2021-12-19 13:50:01
 */
@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {
	
}
