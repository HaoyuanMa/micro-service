package com.bhjx.accdoctor.user.controller;

import java.util.Arrays;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bhjx.accdoctor.user.entity.MemberAddressEntity;
import com.bhjx.accdoctor.user.service.MemberAddressService;
import com.bhjx.common.utils.PageUtils;
import com.bhjx.common.utils.R;



/**
 * 用户地址
 *
 * @author mhy
 * @email mhy@bit.edu.cn
 * @date 2021-12-05 21:59:17
 */
@RestController
@RequestMapping("user/memberaddress")
public class MemberAddressController {
    @Autowired
    private MemberAddressService memberAddressService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("user:memberaddress:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = memberAddressService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("user:memberaddress:info")
    public R info(@PathVariable("id") Long id){
		MemberAddressEntity memberAddress = memberAddressService.getById(id);

        return R.ok().put("memberAddress", memberAddress);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("user:memberaddress:save")
    public R save(@RequestBody MemberAddressEntity memberAddress){
		memberAddressService.save(memberAddress);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("user:memberaddress:update")
    public R update(@RequestBody MemberAddressEntity memberAddress){
		memberAddressService.updateById(memberAddress);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("user:memberaddress:delete")
    public R delete(@RequestBody Long[] ids){
		memberAddressService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
