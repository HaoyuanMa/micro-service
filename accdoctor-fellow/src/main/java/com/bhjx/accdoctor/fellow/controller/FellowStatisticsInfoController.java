package com.bhjx.accdoctor.fellow.controller;

import java.util.Arrays;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bhjx.accdoctor.fellow.entity.FellowStatisticsInfoEntity;
import com.bhjx.accdoctor.fellow.service.FellowStatisticsInfoService;
import com.bhjx.common.utils.PageUtils;
import com.bhjx.common.utils.R;



/**
 * 用户统计信息
 *
 * @author mhy
 * @email mhy@bit.edu.cn
 * @date 2021-12-07 20:34:04
 */
@RestController
@RequestMapping("fellow/fellowstatisticsinfo")
public class FellowStatisticsInfoController {
    @Autowired
    private FellowStatisticsInfoService fellowStatisticsInfoService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("fellow:fellowstatisticsinfo:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = fellowStatisticsInfoService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("fellow:fellowstatisticsinfo:info")
    public R info(@PathVariable("id") Long id){
		FellowStatisticsInfoEntity fellowStatisticsInfo = fellowStatisticsInfoService.getById(id);

        return R.ok().put("fellowStatisticsInfo", fellowStatisticsInfo);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("fellow:fellowstatisticsinfo:save")
    public R save(@RequestBody FellowStatisticsInfoEntity fellowStatisticsInfo){
		fellowStatisticsInfoService.save(fellowStatisticsInfo);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("fellow:fellowstatisticsinfo:update")
    public R update(@RequestBody FellowStatisticsInfoEntity fellowStatisticsInfo){
		fellowStatisticsInfoService.updateById(fellowStatisticsInfo);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("fellow:fellowstatisticsinfo:delete")
    public R delete(@RequestBody Long[] ids){
		fellowStatisticsInfoService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
