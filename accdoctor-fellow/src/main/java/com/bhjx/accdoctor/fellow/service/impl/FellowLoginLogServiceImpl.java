package com.bhjx.accdoctor.fellow.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bhjx.common.utils.PageUtils;
import com.bhjx.common.utils.Query;

import com.bhjx.accdoctor.fellow.dao.FellowLoginLogDao;
import com.bhjx.accdoctor.fellow.entity.FellowLoginLogEntity;
import com.bhjx.accdoctor.fellow.service.FellowLoginLogService;


@Service("fellowLoginLogService")
public class FellowLoginLogServiceImpl extends ServiceImpl<FellowLoginLogDao, FellowLoginLogEntity> implements FellowLoginLogService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<FellowLoginLogEntity> page = this.page(
                new Query<FellowLoginLogEntity>().getPage(params),
                new QueryWrapper<FellowLoginLogEntity>()
        );

        return new PageUtils(page);
    }

}