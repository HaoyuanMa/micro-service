package com.bhjx.accdoctor.fellow.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bhjx.common.utils.PageUtils;
import com.bhjx.common.utils.Query;

import com.bhjx.accdoctor.fellow.dao.FellowCommentDao;
import com.bhjx.accdoctor.fellow.entity.FellowCommentEntity;
import com.bhjx.accdoctor.fellow.service.FellowCommentService;


@Service("fellowCommentService")
public class FellowCommentServiceImpl extends ServiceImpl<FellowCommentDao, FellowCommentEntity> implements FellowCommentService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<FellowCommentEntity> page = this.page(
                new Query<FellowCommentEntity>().getPage(params),
                new QueryWrapper<FellowCommentEntity>()
        );

        return new PageUtils(page);
    }

}