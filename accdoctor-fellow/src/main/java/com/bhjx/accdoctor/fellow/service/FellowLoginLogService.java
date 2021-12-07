package com.bhjx.accdoctor.fellow.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bhjx.common.utils.PageUtils;
import com.bhjx.accdoctor.fellow.entity.FellowLoginLogEntity;

import java.util.Map;

/**
 * 会员登录记录
 *
 * @author mhy
 * @email mhy@bit.edu.cn
 * @date 2021-12-07 20:34:04
 */
public interface FellowLoginLogService extends IService<FellowLoginLogEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

