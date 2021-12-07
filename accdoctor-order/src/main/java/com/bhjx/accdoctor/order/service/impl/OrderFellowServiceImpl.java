package com.bhjx.accdoctor.order.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bhjx.common.utils.PageUtils;
import com.bhjx.common.utils.Query;

import com.bhjx.accdoctor.order.dao.OrderFellowDao;
import com.bhjx.accdoctor.order.entity.OrderFellowEntity;
import com.bhjx.accdoctor.order.service.OrderFellowService;


@Service("orderFellowService")
public class OrderFellowServiceImpl extends ServiceImpl<OrderFellowDao, OrderFellowEntity> implements OrderFellowService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<OrderFellowEntity> page = this.page(
                new Query<OrderFellowEntity>().getPage(params),
                new QueryWrapper<OrderFellowEntity>()
        );

        return new PageUtils(page);
    }

}