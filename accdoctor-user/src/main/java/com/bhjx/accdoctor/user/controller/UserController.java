package com.bhjx.accdoctor.user.controller;

import java.util.Arrays;
import java.util.Map;


import com.bhjx.accdoctor.user.entity.LoginEntity;
import com.bhjx.accdoctor.user.feign.OrderFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.web.bind.annotation.*;

import com.bhjx.accdoctor.user.entity.UserEntity;
import com.bhjx.accdoctor.user.service.UserService;
import com.bhjx.common.utils.PageUtils;
import com.bhjx.common.utils.R;
import org.springframework.web.servlet.function.ServerRequest;


/**
 * 用户
 *
 * @author mhy
 * @email mhy@bit.edu.cn
 * @date 2021-12-07 17:40:13
 */
@RestController
@RequestMapping("user/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    OrderFeignService orderFeignService;

    @RequestMapping("/login")
    public R login(@RequestBody LoginEntity loginEntity){
        String username = loginEntity.username;
        String password = loginEntity.password;
        String vcode = loginEntity.vcode;

        //todo: validate




        return R.ok().put("token","1");
    }


    @RequestMapping("/orders")
    public R test(){
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername("mhy");
        R orders = orderFeignService.UserOrders();

        return R.ok().put("user",userEntity).put("order",orders.get("orders"));
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("user:user:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = userService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info")
    //@RequiresPermissions("user:user:info")
    public R info(@RequestHeader("Authorization") String token) {

		UserEntity user = userService.getById(Integer.parseInt(token));
        user.setPassword("****");

        return R.ok().put("user", user);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("user:user:save")
    public R save(@RequestBody UserEntity user){
		userService.save(user);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("user:user:update")
    public R update(@RequestBody UserEntity user){
		userService.updateById(user);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("user:user:delete")
    public R delete(@RequestBody Long[] ids){
		userService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
