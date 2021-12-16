package com.bhjx.accdoctor.fellow.controller;

import java.util.Arrays;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bhjx.accdoctor.fellow.entity.FellowLoginLogEntity;
import com.bhjx.accdoctor.fellow.service.FellowLoginLogService;
import com.bhjx.common.utils.PageUtils;
import com.bhjx.common.utils.R;



/**
 * 会员登录记录
 *
 * @author mhy
 * @email mhy@bit.edu.cn
 * @date 2021-12-16 11:48:56
 */
@RestController
@RequestMapping("fellow/fellowloginlog")
public class FellowLoginLogController {
    @Autowired
    private FellowLoginLogService fellowLoginLogService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("fellow:fellowloginlog:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = fellowLoginLogService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("fellow:fellowloginlog:info")
    public R info(@PathVariable("id") Long id){
		FellowLoginLogEntity fellowLoginLog = fellowLoginLogService.getById(id);

        return R.ok().put("fellowLoginLog", fellowLoginLog);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("fellow:fellowloginlog:save")
    public R save(@RequestBody FellowLoginLogEntity fellowLoginLog){
		fellowLoginLogService.save(fellowLoginLog);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("fellow:fellowloginlog:update")
    public R update(@RequestBody FellowLoginLogEntity fellowLoginLog){
		fellowLoginLogService.updateById(fellowLoginLog);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("fellow:fellowloginlog:delete")
    public R delete(@RequestBody Long[] ids){
		fellowLoginLogService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
