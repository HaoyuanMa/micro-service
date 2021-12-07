package com.bhjx.accdoctor.fellow.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bhjx.common.utils.PageUtils;
import com.bhjx.accdoctor.fellow.entity.FellowStatisticsInfoEntity;

import java.util.Map;

/**
 * 用户统计信息
 *
 * @author mhy
 * @email mhy@bit.edu.cn
 * @date 2021-12-07 20:34:04
 */
public interface FellowStatisticsInfoService extends IService<FellowStatisticsInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

