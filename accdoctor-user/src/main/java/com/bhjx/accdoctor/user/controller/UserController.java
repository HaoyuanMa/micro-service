package com.bhjx.accdoctor.user.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;


import com.bhjx.accdoctor.user.entity.LoginEntity;
import com.bhjx.accdoctor.user.entity.RegisterEntity;
import com.bhjx.accdoctor.user.feign.OrderFeignService;
import com.bhjx.common.utils.JwtUtils;
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
        String mobile = loginEntity.account;
        String password = loginEntity.password;

        UserEntity user = userService.queryByMobile(mobile);
        if(user != null && user.getPassword().equals(password)){
            String token = JwtUtils.generateToken(user.getId(),user.getUsername());
            return R.ok().put("token",token);
        }
        return R.error(401,"登录失败");
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
        if (!JwtUtils.verify(token)){
            return R.error(401,"鉴权失败");
        }
		UserEntity user = userService.getById(JwtUtils.getUserIdFromToken(token));
        user.setPassword("****");

        return R.ok().put("user", user);
    }

    /**
     * 保存
     */
    @RequestMapping("/register")
    //@RequiresPermissions("user:user:save")
    public R save(@RequestBody RegisterEntity user){
        if(userService.queryByMobile(user.getMobile()) == null){
            UserEntity newUser = new UserEntity();
            newUser.setUsername(user.getUsername());
            newUser.setPassword(user.getPassword());
            newUser.setMobile(user.getMobile());
            newUser.setCreateTime(new Date());
            if(userService.save(newUser)) return R.ok();
        }
        return R.error(500,"failed");
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("user:user:update")
    public R update(@RequestBody UserEntity user,@RequestHeader("Authorization") String token){
        long userId = JwtUtils.getUserIdFromToken(token);
        if (userId <= 0) return R.error(401,"鉴权失败");

		if(userService.updateById(user)){
            return R.ok();
        }

        return R.error(500,"failed");
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
