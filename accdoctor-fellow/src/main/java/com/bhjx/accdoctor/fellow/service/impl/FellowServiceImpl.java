package com.bhjx.accdoctor.fellow.service.impl;

import com.bhjx.accdoctor.common.xss.SQLFilter;
import com.bhjx.common.utils.Constant;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bhjx.common.utils.PageUtils;
import com.bhjx.common.utils.Query;

import com.bhjx.accdoctor.fellow.dao.FellowDao;
import com.bhjx.accdoctor.fellow.entity.FellowEntity;
import com.bhjx.accdoctor.fellow.service.FellowService;


@Service("fellowService")
public class FellowServiceImpl extends ServiceImpl<FellowDao, FellowEntity> implements FellowService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        QueryWrapper<FellowEntity> queryWrapper = new QueryWrapper<FellowEntity>();
        String keyword = (String) params.get("keyword");
        String orderField = SQLFilter.sqlInject((String)params.get(Constant.ORDER_FIELD));
        String order = (String)params.get(Constant.ORDER);
        if (!keyword.isEmpty()){
            queryWrapper.like("username",keyword);
        }
        if (!order.isEmpty() && !orderField.isEmpty()){
            if(Constant.ASC.equalsIgnoreCase(order)){
                queryWrapper.orderByAsc(orderField);
            } else {
                queryWrapper.orderByDesc(orderField);
            }
        }


        IPage<FellowEntity> page = this.page(
                new Query<FellowEntity>().getPage(params),
                queryWrapper
        );

        return new PageUtils(page);
    }

}