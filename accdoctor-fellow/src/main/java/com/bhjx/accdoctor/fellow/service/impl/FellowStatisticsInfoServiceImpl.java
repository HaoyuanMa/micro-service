package com.bhjx.accdoctor.fellow.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bhjx.common.utils.PageUtils;
import com.bhjx.common.utils.Query;

import com.bhjx.accdoctor.fellow.dao.FellowStatisticsInfoDao;
import com.bhjx.accdoctor.fellow.entity.FellowStatisticsInfoEntity;
import com.bhjx.accdoctor.fellow.service.FellowStatisticsInfoService;


@Service("fellowStatisticsInfoService")
public class FellowStatisticsInfoServiceImpl extends ServiceImpl<FellowStatisticsInfoDao, FellowStatisticsInfoEntity> implements FellowStatisticsInfoService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<FellowStatisticsInfoEntity> page = this.page(
                new Query<FellowStatisticsInfoEntity>().getPage(params),
                new QueryWrapper<FellowStatisticsInfoEntity>()
        );

        return new PageUtils(page);
    }

}