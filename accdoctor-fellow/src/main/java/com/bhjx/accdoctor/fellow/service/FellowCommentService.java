package com.bhjx.accdoctor.fellow.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bhjx.common.utils.PageUtils;
import com.bhjx.accdoctor.fellow.entity.FellowCommentEntity;

import java.util.Map;

/**
 * 陪诊员评价
 *
 * @author mhy
 * @email mhy@bit.edu.cn
 * @date 2021-12-07 20:34:04
 */
public interface FellowCommentService extends IService<FellowCommentEntity> {

    PageUtils queryPage(Map<String, Object> params);
}
