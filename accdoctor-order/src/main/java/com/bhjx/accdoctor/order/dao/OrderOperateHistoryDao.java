package com.bhjx.accdoctor.order.dao;

import com.bhjx.accdoctor.order.entity.OrderOperateHistoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单操作历史记录
 * 
 * @author mhy
 * @email mhy@bit.edu.cn
 * @date 2021-12-07 20:25:58
 */
@Mapper
public interface OrderOperateHistoryDao extends BaseMapper<OrderOperateHistoryEntity> {
	
}
