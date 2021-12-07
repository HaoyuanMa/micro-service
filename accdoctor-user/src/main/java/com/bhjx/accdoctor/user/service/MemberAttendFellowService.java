package com.bhjx.accdoctor.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bhjx.common.utils.PageUtils;
import com.bhjx.accdoctor.user.entity.MemberAttendFellowEntity;

import java.util.Map;

/**
 * 用户关注的陪诊员
 *
 * @author mhy
 * @email mhy@bit.edu.cn
 * @date 2021-12-05 20:39:39
 */
public interface MemberAttendFellowService extends IService<MemberAttendFellowEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

