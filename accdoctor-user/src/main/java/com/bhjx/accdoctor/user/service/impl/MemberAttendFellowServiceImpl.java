package com.bhjx.accdoctor.user.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bhjx.common.utils.PageUtils;
import com.bhjx.common.utils.Query;

import com.bhjx.accdoctor.user.dao.MemberAttendFellowDao;
import com.bhjx.accdoctor.user.entity.MemberAttendFellowEntity;
import com.bhjx.accdoctor.user.service.MemberAttendFellowService;


@Service("memberAttendFellowService")
public class MemberAttendFellowServiceImpl extends ServiceImpl<MemberAttendFellowDao, MemberAttendFellowEntity> implements MemberAttendFellowService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<MemberAttendFellowEntity> page = this.page(
                new Query<MemberAttendFellowEntity>().getPage(params),
                new QueryWrapper<MemberAttendFellowEntity>()
        );

        return new PageUtils(page);
    }

}