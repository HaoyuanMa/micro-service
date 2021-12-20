package com.bhjx.accdoctor.user.service.impl;

import org.apache.catalina.User;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bhjx.common.utils.PageUtils;
import com.bhjx.common.utils.Query;

import com.bhjx.accdoctor.user.dao.UserDao;
import com.bhjx.accdoctor.user.entity.UserEntity;
import com.bhjx.accdoctor.user.service.UserService;


@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserDao, UserEntity> implements UserService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<UserEntity> page = this.page(
                new Query<UserEntity>().getPage(params),
                new QueryWrapper<UserEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public UserEntity queryByMobile(String mobile) {
        QueryWrapper<UserEntity> userQueryWrapper = new QueryWrapper<UserEntity>();
        userQueryWrapper.eq("mobile",mobile);
        UserEntity user = getOne(userQueryWrapper);
        return user;
    }

}