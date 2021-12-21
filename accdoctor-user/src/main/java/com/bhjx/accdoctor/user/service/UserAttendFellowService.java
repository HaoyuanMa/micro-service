package com.bhjx.accdoctor.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bhjx.common.utils.PageUtils;
import com.bhjx.accdoctor.user.entity.UserAttendFellowEntity;
import org.apache.catalina.User;

import java.util.List;
import java.util.Map;

/**
 * 用户关注的陪诊员
 *
 * @author mhy
 * @email mhy@bit.edu.cn
 * @date 2021-12-07 17:40:13
 */
public interface UserAttendFellowService extends IService<UserAttendFellowEntity> {

    PageUtils queryPage(Map<String, Object> params);

    UserAttendFellowEntity queryOne(Long fellowId,Long userId);

    PageUtils queryByUserId(Long userId, Map<String, Object> params);
}

