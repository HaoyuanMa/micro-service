package com.bhjx.accdoctor.fellow.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bhjx.common.utils.PageUtils;
import com.bhjx.accdoctor.fellow.entity.FellowAddressEntity;

import java.util.Map;

/**
 * 陪诊员地址
 *
 * @author mhy
 * @email mhy@bit.edu.cn
 * @date 2021-12-07 20:34:04
 */
public interface FellowAddressService extends IService<FellowAddressEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

