package com.bhjx.accdoctor.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bhjx.common.utils.PageUtils;
import com.bhjx.accdoctor.user.entity.UserAddressEntity;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 用户地址
 *
 * @author mhy
 * @email mhy@bit.edu.cn
 * @date 2021-12-07 17:40:13
 */
public interface UserAddressService extends IService<UserAddressEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<UserAddressEntity> queryList(Serializable id);

    UserAddressEntity queryDefault(Serializable id);
}

