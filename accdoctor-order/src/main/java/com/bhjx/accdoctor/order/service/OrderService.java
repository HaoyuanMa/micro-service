package com.bhjx.accdoctor.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bhjx.common.utils.PageUtils;
import com.bhjx.accdoctor.order.entity.OrderEntity;

import java.util.List;
import java.util.Map;

/**
 * 订单
 *
 * @author mhy
 * @email mhy@bit.edu.cn
 * @date 2021-12-19 13:50:01
 */
public interface OrderService extends IService<OrderEntity> {

    PageUtils queryPage(Map<String, Object> params);

    OrderEntity queryByOrderSn(String orderSn);

    List<OrderEntity> queryListByStatus(Long userId, int status);

    PageUtils queryPageByStatus(Long userId, int status, Map<String, Object> params);


}

