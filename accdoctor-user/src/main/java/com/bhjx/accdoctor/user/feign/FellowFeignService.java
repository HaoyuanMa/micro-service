package com.bhjx.accdoctor.user.feign;

import com.bhjx.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("accdoctor-fellow")
public interface FellowFeignService {
    @RequestMapping("fellow/fellow/info/{id}")
    public R info(@PathVariable("id") Long id);
}
