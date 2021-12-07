package com.bhjx.accdoctor.fellow.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bhjx.common.utils.PageUtils;
import com.bhjx.common.utils.Query;

import com.bhjx.accdoctor.fellow.dao.FellowAddressDao;
import com.bhjx.accdoctor.fellow.entity.FellowAddressEntity;
import com.bhjx.accdoctor.fellow.service.FellowAddressService;


@Service("fellowAddressService")
public class FellowAddressServiceImpl extends ServiceImpl<FellowAddressDao, FellowAddressEntity> implements FellowAddressService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<FellowAddressEntity> page = this.page(
                new Query<FellowAddressEntity>().getPage(params),
                new QueryWrapper<FellowAddressEntity>()
        );

        return new PageUtils(page);
    }

}