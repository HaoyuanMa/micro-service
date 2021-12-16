package com.bhjx.accdoctor.fellow.controller;

import java.util.Arrays;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bhjx.accdoctor.fellow.entity.FellowAddressEntity;
import com.bhjx.accdoctor.fellow.service.FellowAddressService;
import com.bhjx.common.utils.PageUtils;
import com.bhjx.common.utils.R;



/**
 * 陪诊员地址
 *
 * @author mhy
 * @email mhy@bit.edu.cn
 * @date 2021-12-16 11:48:56
 */
@RestController
@RequestMapping("fellow/fellowaddress")
public class FellowAddressController {
    @Autowired
    private FellowAddressService fellowAddressService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("fellow:fellowaddress:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = fellowAddressService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("fellow:fellowaddress:info")
    public R info(@PathVariable("id") Long id){
		FellowAddressEntity fellowAddress = fellowAddressService.getById(id);

        return R.ok().put("fellowAddress", fellowAddress);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("fellow:fellowaddress:save")
    public R save(@RequestBody FellowAddressEntity fellowAddress){
		fellowAddressService.save(fellowAddress);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("fellow:fellowaddress:update")
    public R update(@RequestBody FellowAddressEntity fellowAddress){
		fellowAddressService.updateById(fellowAddress);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("fellow:fellowaddress:delete")
    public R delete(@RequestBody Long[] ids){
		fellowAddressService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
