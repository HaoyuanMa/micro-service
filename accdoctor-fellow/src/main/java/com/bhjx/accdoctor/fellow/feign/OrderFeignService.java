package com.bhjx.accdoctor.fellow.feign;

import com.bhjx.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("accdoctor-order")
public interface OrderFeignService {
    @RequestMapping("order/order/finishOrder/{id}")
    //@RequiresPermissions("order:order:info")
    public R finishOrder(@PathVariable("id") Long id,@RequestHeader("Authorization") String token);
}
