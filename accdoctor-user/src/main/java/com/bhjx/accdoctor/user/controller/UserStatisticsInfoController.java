package com.bhjx.accdoctor.user.controller;

import java.util.Arrays;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bhjx.accdoctor.user.entity.UserStatisticsInfoEntity;
import com.bhjx.accdoctor.user.service.UserStatisticsInfoService;
import com.bhjx.common.utils.PageUtils;
import com.bhjx.common.utils.R;



/**
 * 用户统计信息
 *
 * @author mhy
 * @email mhy@bit.edu.cn
 * @date 2021-12-07 17:40:13
 */
@RestController
@RequestMapping("user/userstatisticsinfo")
public class UserStatisticsInfoController {
    @Autowired
    private UserStatisticsInfoService userStatisticsInfoService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("user:userstatisticsinfo:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = userStatisticsInfoService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("user:userstatisticsinfo:info")
    public R info(@PathVariable("id") Long id){
		UserStatisticsInfoEntity userStatisticsInfo = userStatisticsInfoService.getById(id);

        return R.ok().put("userStatisticsInfo", userStatisticsInfo);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("user:userstatisticsinfo:save")
    public R save(@RequestBody UserStatisticsInfoEntity userStatisticsInfo){
		userStatisticsInfoService.save(userStatisticsInfo);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("user:userstatisticsinfo:update")
    public R update(@RequestBody UserStatisticsInfoEntity userStatisticsInfo){
		userStatisticsInfoService.updateById(userStatisticsInfo);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("user:userstatisticsinfo:delete")
    public R delete(@RequestBody Long[] ids){
		userStatisticsInfoService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
