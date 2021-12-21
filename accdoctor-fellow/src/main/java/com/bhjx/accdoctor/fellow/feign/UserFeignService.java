package com.bhjx.accdoctor.fellow.feign;

import com.bhjx.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("accdoctor-user")
public interface UserFeignService {
    @RequestMapping("user/user/info")
    public R info(@RequestHeader("Authorization") String token);
}
