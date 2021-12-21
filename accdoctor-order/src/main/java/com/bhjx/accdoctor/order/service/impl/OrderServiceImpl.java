package com.bhjx.accdoctor.order.service.impl;

import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bhjx.common.utils.PageUtils;
import com.bhjx.common.utils.Query;

import com.bhjx.accdoctor.order.dao.OrderDao;
import com.bhjx.accdoctor.order.entity.OrderEntity;
import com.bhjx.accdoctor.order.service.OrderService;


@Service("orderService")
public class OrderServiceImpl extends ServiceImpl<OrderDao, OrderEntity> implements OrderService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<OrderEntity> page = this.page(
                new Query<OrderEntity>().getPage(params),
                new QueryWrapper<OrderEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public OrderEntity queryByOrderSn(String orderSn) {
        QueryWrapper<OrderEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("order_sn",orderSn);
        if (queryWrapper.isEmptyOfWhere()) return null;
        return getOne(queryWrapper);
    }

    @Override
    public List<OrderEntity> queryListByStatus(Long userId, int status) {
        QueryWrapper<OrderEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("status",status).eq("user_id",userId);
        if (queryWrapper.isEmptyOfWhere()) return Collections.emptyList();
        return list(queryWrapper);
    }

    @Override
    public PageUtils queryPageByStatus(Long userId, int status, Map<String, Object> params) {
        QueryWrapper<OrderEntity> queryWrapper = new QueryWrapper<OrderEntity>();
        queryWrapper.eq("user_id",userId);
        if (status >= 0) queryWrapper.eq("status",status);
        IPage<OrderEntity> page = this.page(
                new Query<OrderEntity>().getPage(params),
                queryWrapper
        );
        return new PageUtils(page);
    }

}