package com.bhjx.accdoctor.user.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;


import com.bhjx.accdoctor.user.entity.UserAddressAddEntity;
import com.bhjx.common.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.bhjx.accdoctor.user.entity.UserAddressEntity;
import com.bhjx.accdoctor.user.service.UserAddressService;
import com.bhjx.common.utils.PageUtils;
import com.bhjx.common.utils.R;



/**
 * 用户地址
 *
 * @author mhy
 * @email mhy@bit.edu.cn
 * @date 2021-12-07 17:40:13
 */
@RestController
@RequestMapping("user/useraddress")
public class UserAddressController {
    @Autowired
    private UserAddressService userAddressService;

    @RequestMapping("/default")
    //@RequiresPermissions("user:useraddress:list")
    public R getDefault(@RequestHeader("Authorization") String token){
        long id = JwtUtils.getUserIdFromToken(token);
        UserAddressEntity defaultAddress = userAddressService.queryDefault(id);

        return R.ok().put("data", defaultAddress);
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("user:useraddress:list")
    public R list(@RequestHeader("Authorization") String token){
        long id = JwtUtils.getUserIdFromToken(token);
        List<UserAddressEntity> userAddress = userAddressService.queryList(id);

        return R.ok().put("data", userAddress);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("user:useraddress:info")
    public R info(@PathVariable("id") Long id){
		UserAddressEntity userAddress = userAddressService.getById(id);

        return R.ok().put("userAddress", userAddress);
    }

    /**
     * 保存
     */
    @RequestMapping("/add")
    //@RequiresPermissions("user:useraddress:save")
    public R save(@RequestBody UserAddressAddEntity userAddress,@RequestHeader("Authorization") String token){
        long userId = JwtUtils.getUserIdFromToken(token);
        if (userAddress.defaultStatus){
            UserAddressEntity defaultAddress = userAddressService.queryDefault(userId);
            defaultAddress.setDefaultStatus(0);
            userAddressService.updateById(defaultAddress);
        }
        UserAddressEntity newAddress = new UserAddressEntity();
        newAddress.setUserId(userId);
        newAddress.setName(userAddress.name);
        newAddress.setPhone(userAddress.phone);
        newAddress.setProvince(userAddress.province);
        newAddress.setCity(userAddress.city);
        newAddress.setRegion(userAddress.region);
        newAddress.setDetailAddress(userAddress.detailAddress);
        newAddress.setDefaultStatus(userAddress.defaultStatus ? 1 : 0 );
        userAddressService.save(newAddress);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("user:useraddress:update")
    public R update(@RequestBody UserAddressEntity userAddress){
		userAddressService.updateById(userAddress);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("user:useraddress:delete")
    public R delete(@RequestBody Long[] ids){
		userAddressService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
