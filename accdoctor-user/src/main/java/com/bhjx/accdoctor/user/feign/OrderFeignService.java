package com.bhjx.accdoctor.user.feign;

import com.bhjx.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("accdoctor-order")
public interface OrderFeignService {
    @RequestMapping("/order/order/user/list")
    public R UserOrders();
}
