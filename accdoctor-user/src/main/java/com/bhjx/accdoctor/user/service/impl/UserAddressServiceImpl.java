package com.bhjx.accdoctor.user.service.impl;

import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bhjx.common.utils.PageUtils;
import com.bhjx.common.utils.Query;

import com.bhjx.accdoctor.user.dao.UserAddressDao;
import com.bhjx.accdoctor.user.entity.UserAddressEntity;
import com.bhjx.accdoctor.user.service.UserAddressService;


@Service("userAddressService")
public class UserAddressServiceImpl extends ServiceImpl<UserAddressDao, UserAddressEntity> implements UserAddressService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<UserAddressEntity> page = this.page(
                new Query<UserAddressEntity>().getPage(params),
                new QueryWrapper<UserAddressEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<UserAddressEntity> queryList(Serializable id){
        QueryWrapper<UserAddressEntity> queryWrapper = new QueryWrapper<UserAddressEntity>();
        queryWrapper.eq("user_id",id);
        return list(queryWrapper);
    }

    @Override
    public UserAddressEntity queryDefault(Serializable id) {
        QueryWrapper<UserAddressEntity> queryWrapper = new QueryWrapper<UserAddressEntity>();
        queryWrapper.eq("user_id",id).eq("default_status",1);
        if (queryWrapper.isEmptyOfWhere()) return null;
        return getOne(queryWrapper);
    }


}