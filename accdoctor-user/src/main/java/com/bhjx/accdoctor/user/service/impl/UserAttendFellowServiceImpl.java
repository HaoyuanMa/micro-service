package com.bhjx.accdoctor.user.service.impl;

import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bhjx.common.utils.PageUtils;
import com.bhjx.common.utils.Query;

import com.bhjx.accdoctor.user.dao.UserAttendFellowDao;
import com.bhjx.accdoctor.user.entity.UserAttendFellowEntity;
import com.bhjx.accdoctor.user.service.UserAttendFellowService;


@Service("userAttendFellowService")
public class UserAttendFellowServiceImpl extends ServiceImpl<UserAttendFellowDao, UserAttendFellowEntity> implements UserAttendFellowService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<UserAttendFellowEntity> page = this.page(
                new Query<UserAttendFellowEntity>().getPage(params),
                new QueryWrapper<UserAttendFellowEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public UserAttendFellowEntity queryOne(Long fellowId, Long userId) {
        QueryWrapper<UserAttendFellowEntity> queryWrapper = new QueryWrapper<UserAttendFellowEntity>();
        queryWrapper.eq("user_id",userId).eq("fellow_id",fellowId);
        if (queryWrapper.isEmptyOfWhere()) return null;
        return getOne(queryWrapper);
    }

    @Override
    public PageUtils queryByUserId(Long userId,Map<String, Object> params) {
        QueryWrapper<UserAttendFellowEntity> queryWrapper = new QueryWrapper<UserAttendFellowEntity>();
        queryWrapper.eq("user_id",userId);
        IPage<UserAttendFellowEntity> page = this.page(
                new Query<UserAttendFellowEntity>().getPage(params),
                queryWrapper
        );
        return new PageUtils(page);
    }

}