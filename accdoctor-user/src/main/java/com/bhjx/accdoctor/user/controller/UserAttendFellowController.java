package com.bhjx.accdoctor.user.controller;

import java.util.*;

import com.bhjx.accdoctor.user.feign.FellowFeignService;
import com.bhjx.common.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @Autowired
    private FellowFeignService fellowFeignService;

    @RequestMapping("/get/{id}")
    public R get(@PathVariable("id") Long fellowId, @RequestHeader("Authorization") String token) {
        long userId = JwtUtils.getUserIdFromToken(token);
        if (userId <= 0) return R.ok().put("status",false);
        UserAttendFellowEntity attend = userAttendFellowService.queryOne(fellowId,userId);
        if (attend != null){
            return R.ok().put("status",true);
        } else {
            return R.ok().put("status",false);
        }
    }

    @RequestMapping("/set/{id}")
    public R set(@PathVariable("id") Long fellowId, @RequestHeader("Authorization") String token) {
        long userId = JwtUtils.getUserIdFromToken(token);
        if (userId <= 0) return R.error(401, "鉴权失败");
        UserAttendFellowEntity attend = userAttendFellowService.queryOne(fellowId,userId);
        if (attend == null){
            R res = fellowFeignService.info(fellowId);
            UserAttendFellowEntity newAttend = new UserAttendFellowEntity();
            LinkedHashMap fellow = (LinkedHashMap) res.get("fellow");
            String fellowName = fellow.get("username").toString();
            Object fellowHeader = fellow.get("header");
            fellowHeader = fellowHeader==null ? " " : fellowHeader.toString();
            newAttend.setFellowId(fellowId);
            newAttend.setUserId(userId);
            newAttend.setFellowName(fellowName);
            newAttend.setFellowImg(fellowHeader.toString());
            newAttend.setCreateTime(new Date());
            if(userAttendFellowService.save(newAttend)){
                return R.ok();
            }
        } else {
            ArrayList<Long> ids = new ArrayList<>();
            ids.add(attend.getId());
            if(userAttendFellowService.removeByIds(ids)){
                return R.ok();
            }
        }
        return R.error(500,"faild");
    }
    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("user:userattendfellow:list")
    public R list(@RequestHeader("Authorization") String token,@RequestParam Map<String, Object> params){
        long userId = JwtUtils.getUserIdFromToken(token);
        if (userId <= 0) return R.error(401, "鉴权失败");

        PageUtils page = userAttendFellowService.queryByUserId(userId,params);

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
     * 删除
     * */
    @RequestMapping("/delete")
    //@RequiresPermissions("user:userattendfellow:delete")
    public R delete(@RequestBody Long[] ids){
        userAttendFellowService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

//    /**
//     * 保存
//     */
//    @RequestMapping("/save")
//    //@RequiresPermissions("user:userattendfellow:save")
//    public R save(@RequestBody UserAttendFellowEntity userAttendFellow){
//		userAttendFellowService.save(userAttendFellow);
//
//        return R.ok();
//    }
//
//    /**
//     * 修改
//     */
//    @RequestMapping("/update")
//    //@RequiresPermissions("user:userattendfellow:update")
//    public R update(@RequestBody UserAttendFellowEntity userAttendFellow){
//		userAttendFellowService.updateById(userAttendFellow);
//
//        return R.ok();
//    }
}
