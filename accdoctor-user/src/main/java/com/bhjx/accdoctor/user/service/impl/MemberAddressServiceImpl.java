package com.bhjx.accdoctor.user.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bhjx.common.utils.PageUtils;
import com.bhjx.common.utils.Query;

import com.bhjx.accdoctor.user.dao.MemberAddressDao;
import com.bhjx.accdoctor.user.entity.MemberAddressEntity;
import com.bhjx.accdoctor.user.service.MemberAddressService;


@Service("memberAddressService")
public class MemberAddressServiceImpl extends ServiceImpl<MemberAddressDao, MemberAddressEntity> implements MemberAddressService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<MemberAddressEntity> page = this.page(
                new Query<MemberAddressEntity>().getPage(params),
                new QueryWrapper<MemberAddressEntity>()
        );

        return new PageUtils(page);
    }

}