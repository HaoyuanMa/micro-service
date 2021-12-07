package com.bhjx.accdoctor.user.controller;

import java.util.Arrays;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bhjx.accdoctor.user.entity.UserAttendFellowEntity;
import com.bhjx.accdoctor.user.service.UserAttendFellowService;
import com.bhjx.common.utils.PageUtils;
import com.bhjx.common.utils.R;



/**
 * 用户关注的陪诊员
 *
 * @author mhy
 * @email mhy@bit.edu.cn
 * @date 2021-12-07 17:40:13
 */
@RestController
@RequestMapping("user/userattendfellow")
public class UserAttendFellowController {
    @Autowired
    private UserAttendFellowService userAttendFellowService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("user:userattendfellow:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = userAttendFellowService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("user:userattendfellow:info")
    public R info(@PathVariable("id") Long id){
		UserAttendFellowEntity userAttendFellow = userAttendFellowService.getById(id);

        return R.ok().put("userAttendFellow", userAttendFellow);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("user:userattendfellow:save")
    public R save(@RequestBody UserAttendFellowEntity userAttendFellow){
		userAttendFellowService.save(userAttendFellow);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("user:userattendfellow:update")
    public R update(@RequestBody UserAttendFellowEntity userAttendFellow){
		userAttendFellowService.updateById(userAttendFellow);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("user:userattendfellow:delete")
    public R delete(@RequestBody Long[] ids){
		userAttendFellowService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
