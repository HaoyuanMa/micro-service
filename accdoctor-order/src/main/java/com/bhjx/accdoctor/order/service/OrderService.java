package com.bhjx.accdoctor.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bhjx.common.utils.PageUtils;
import com.bhjx.accdoctor.order.entity.OrderEntity;

import java.util.Map;

/**
 * 订单
 *
 * @author mhy
 * @email mhy@bit.edu.cn
 * @date 2021-12-07 20:25:58
 */
public interface OrderService extends IService<OrderEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

