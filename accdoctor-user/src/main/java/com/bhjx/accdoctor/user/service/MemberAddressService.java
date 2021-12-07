package com.bhjx.accdoctor.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bhjx.common.utils.PageUtils;
import com.bhjx.accdoctor.user.entity.MemberAddressEntity;

import java.util.Map;

/**
 * 用户地址
 *
 * @author mhy
 * @email mhy@bit.edu.cn
 * @date 2021-12-05 20:39:39
 */
public interface MemberAddressService extends IService<MemberAddressEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

