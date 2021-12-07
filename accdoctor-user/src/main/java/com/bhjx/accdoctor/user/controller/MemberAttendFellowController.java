package com.bhjx.accdoctor.user.controller;

import java.util.Arrays;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bhjx.accdoctor.user.entity.MemberAttendFellowEntity;
import com.bhjx.accdoctor.user.service.MemberAttendFellowService;
import com.bhjx.common.utils.PageUtils;
import com.bhjx.common.utils.R;



/**
 * 用户关注的陪诊员
 *
 * @author mhy
 * @email mhy@bit.edu.cn
 * @date 2021-12-05 21:59:17
 */
@RestController
@RequestMapping("user/memberattendfellow")
public class MemberAttendFellowController {
    @Autowired
    private MemberAttendFellowService memberAttendFellowService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("user:memberattendfellow:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = memberAttendFellowService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("user:memberattendfellow:info")
    public R info(@PathVariable("id") Long id){
		MemberAttendFellowEntity memberAttendFellow = memberAttendFellowService.getById(id);

        return R.ok().put("memberAttendFellow", memberAttendFellow);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("user:memberattendfellow:save")
    public R save(@RequestBody MemberAttendFellowEntity memberAttendFellow){
		memberAttendFellowService.save(memberAttendFellow);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("user:memberattendfellow:update")
    public R update(@RequestBody MemberAttendFellowEntity memberAttendFellow){
		memberAttendFellowService.updateById(memberAttendFellow);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("user:memberattendfellow:delete")
    public R delete(@RequestBody Long[] ids){
		memberAttendFellowService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
