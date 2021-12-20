package com.bhjx.accdoctor.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bhjx.common.utils.PageUtils;
import com.bhjx.accdoctor.order.entity.OrderFellowEntity;

import java.util.Map;

/**
 * 接单陪诊员
 *
 * @author mhy
 * @email mhy@bit.edu.cn
 * @date 2021-12-19 13:50:01
 */
public interface OrderFellowService extends IService<OrderFellowEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

