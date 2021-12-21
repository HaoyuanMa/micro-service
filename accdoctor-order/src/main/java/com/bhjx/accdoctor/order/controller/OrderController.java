package com.bhjx.accdoctor.order.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;


import com.bhjx.accdoctor.order.entity.OrderAddEntity;
import com.bhjx.common.utils.JwtUtils;
import com.bhjx.common.utils.OrderSnGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.bhjx.accdoctor.order.entity.OrderEntity;
import com.bhjx.accdoctor.order.service.OrderService;
import com.bhjx.common.utils.PageUtils;
import com.bhjx.common.utils.R;



/**
 * 订单
 *
 * @author mhy
 * @email mhy@bit.edu.cn
 * @date 2021-12-19 13:50:01
 */
@RestController
@RequestMapping("order/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @RequestMapping("/stats")
    public R stats(@RequestHeader("Authorization") String token){
        long userId = JwtUtils.getUserIdFromToken(token);
        if (userId <= 0) return R.error(401,"鉴权失败");

        int unpaid = orderService.queryListByStatus(userId,0).size();
        int paid = orderService.queryListByStatus(userId,1).size();
        int waitToComment = orderService.queryListByStatus(userId,2).size();
        int finished = orderService.queryListByStatus(userId,3).size();
        int total = unpaid + paid + waitToComment + finished;

        return R.ok()
                .put("unpaid",unpaid)
                .put("paid",paid)
                .put("waitToComment",waitToComment)
                .put("finished",finished)
                .put("total",total);

    }

    /**
     * 列表
     */
    @RequestMapping("/list/{status}")
    //@RequiresPermissions("order:order:list")
    public R list(@PathVariable("status") int status,@RequestHeader("Authorization") String token, @RequestParam Map<String, Object> params){
        long userId = JwtUtils.getUserIdFromToken(token);
        if (userId <= 0) return R.error(401,"鉴权失败");

        PageUtils page = orderService.queryPageByStatus(userId,status,params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("order:order:info")
    public R info(@PathVariable("id") Long id,@RequestHeader("Authorization") String token){
        long userId = JwtUtils.getUserIdFromToken(token);
        if (userId <= 0) return R.error(401,"鉴权失败");

        OrderEntity order = orderService.getById(id);
        if (userId != order.getUserId()) return R.error(401,"鉴权失败");

        return R.ok().put("order", order);
    }

    /**
     * 保存
     */
    @RequestMapping("/add")
    //@RequiresPermissions("order:order:save")
    public R save(@RequestBody OrderAddEntity order, @RequestHeader("Authorization") String token){
        long userId = JwtUtils.getUserIdFromToken(token);
        if (userId <= 0) return R.error(401,"鉴权失败");
        String userName = JwtUtils.getUserNameFromToken(token);
        if (userName == null) return R.error(401,"鉴权失败");

        String orderSn = OrderSnGenerator.getInstance().GenerateOrderSn();

        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setUserId(userId);
        orderEntity.setUsername(userName);
        orderEntity.setOrderSn(orderSn);
        orderEntity.setFellowId(order.getFellowId());
        orderEntity.setFellowName(order.getFellowName());
        orderEntity.setFellowHeader(order.getFellowHeader());
        orderEntity.setTotalAmount(order.getTotalAmount());
        orderEntity.setPayType(order.getPayType());
        orderEntity.setSourceType(order.getSourceType());
        orderEntity.setStatus(order.getStatus());
        orderEntity.setName(order.getName());
        orderEntity.setUserPhone(order.getUserPhone());
        orderEntity.setUserProvince(order.getUserProvince());
        orderEntity.setUserCity(order.getUserCity());
        orderEntity.setUserRegion(order.getUserRegion());
        orderEntity.setUserDetailAddress(order.getUserDetailAddress());
        orderEntity.setNote(order.getNote());
        orderEntity.setCreateTime(new Date());
        orderEntity.setCommentTime(null);
        orderEntity.setFinishTime(null);
        orderEntity.setPaymentTime(null);

        if (orderService.save(orderEntity)){
            OrderEntity justAdd = orderService.queryByOrderSn(orderSn);
            if (justAdd != null) return R.ok().put("orderId",justAdd.getId());
            //todo: fellow status
        }

        return R.error(500,"faild");
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("order:order:update")
    public R update(@RequestBody OrderEntity order,@RequestHeader("Authorization") String token){
        long userId = JwtUtils.getUserIdFromToken(token);
        if (userId <= 0) return R.error(401,"鉴权失败");

        int OldStatus = -1;
        OrderEntity OldOrder = orderService.getById(order.getId());
        if(OldOrder != null){
            OldStatus = OldOrder.getStatus();
        }
        if (OldOrder.getStatus() == 0 && order.getStatus() == 1){
            order.setPaymentTime(new Date());
        }
		if(orderService.updateById(order)){
            return R.ok();
        }
        return R.error(500,"保存失败");
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("order:order:delete")
    public R delete(@RequestBody Long[] ids,@RequestHeader("Authorization") String token){
        long userId = JwtUtils.getUserIdFromToken(token);
        if (userId <= 0) return R.error(401,"鉴权失败");
		orderService.removeByIds(Arrays.asList(ids));
        //todo： fellow status
        return R.ok();
    }

    @RequestMapping("/finishAcc/{id}")
    public R finishAcc(@PathVariable("id") Long id,@RequestHeader("Authorization") String token){
        long userId = JwtUtils.getUserIdFromToken(token);
        if (userId <= 0) return R.error(401,"鉴权失败");

        OrderEntity order = orderService.getById(id);
        if (userId != order.getUserId()) return R.error(401,"鉴权失败");

        order.setCommentTime(new Date());
        order.setStatus(2);
        //todo: free fellow
        if(orderService.updateById(order)){
            return R.ok();
        }
        return R.error(500,"failed");
    }


    @RequestMapping("/finishOrder/{id}")
    public R finishOrder(@PathVariable("id") Long id,@RequestHeader("Authorization") String token){
        long userId = JwtUtils.getUserIdFromToken(token);
        if (userId <= 0) return R.error(401,"鉴权失败");

        OrderEntity order = orderService.getById(id);
        if (userId != order.getUserId()) return R.error(401,"鉴权失败");

        order.setFinishTime(new Date());
        order.setStatus(3);

        if(orderService.updateById(order)){
            return R.ok();
        }
        return R.error(500,"failed");
    }
}
