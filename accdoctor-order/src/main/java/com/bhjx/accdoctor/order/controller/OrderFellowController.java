package com.bhjx.accdoctor.order.controller;

import java.util.Arrays;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bhjx.accdoctor.order.entity.OrderFellowEntity;
import com.bhjx.accdoctor.order.service.OrderFellowService;
import com.bhjx.common.utils.PageUtils;
import com.bhjx.common.utils.R;



/**
 * 接单陪诊员
 *
 * @author mhy
 * @email mhy@bit.edu.cn
 * @date 2021-12-19 13:50:01
 */
@RestController
@RequestMapping("order/orderfellow")
public class OrderFellowController {
    @Autowired
    private OrderFellowService orderFellowService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("order:orderfellow:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = orderFellowService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("order:orderfellow:info")
    public R info(@PathVariable("id") Long id){
		OrderFellowEntity orderFellow = orderFellowService.getById(id);

        return R.ok().put("orderFellow", orderFellow);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("order:orderfellow:save")
    public R save(@RequestBody OrderFellowEntity orderFellow){
		orderFellowService.save(orderFellow);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("order:orderfellow:update")
    public R update(@RequestBody OrderFellowEntity orderFellow){
		orderFellowService.updateById(orderFellow);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("order:orderfellow:delete")
    public R delete(@RequestBody Long[] ids){
		orderFellowService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
