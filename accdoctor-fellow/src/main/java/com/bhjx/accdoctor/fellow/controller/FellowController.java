package com.bhjx.accdoctor.fellow.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.bhjx.accdoctor.fellow.entity.FellowCommentEntity;
import com.bhjx.accdoctor.fellow.service.FellowCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bhjx.accdoctor.fellow.entity.FellowEntity;
import com.bhjx.accdoctor.fellow.service.FellowService;
import com.bhjx.common.utils.PageUtils;
import com.bhjx.common.utils.R;



/**
 * 陪诊员
 *
 * @author mhy
 * @email mhy@bit.edu.cn
 * @date 2021-12-16 11:48:56
 */
@RestController
@RequestMapping("fellow/fellow")
public class FellowController {
    @Autowired
    private FellowService fellowService;
    @Autowired
    private FellowCommentService fellowCommentService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("fellow:fellow:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = fellowService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("fellow:fellow:info")
    public R info(@PathVariable("id") Long id){
		FellowEntity fellow = fellowService.getById(id);

        List<FellowCommentEntity> comments = fellowCommentService.queryList(null,id);
        int sum = comments.size();
        int good = 0;
        int in = 0;
        int poor = 0;
        for (FellowCommentEntity comment : comments) {
            if (comment.getCommentType() >= 4){
                good++;
            } else if(comment.getCommentType() == 3){
                in++;
            } else {
                poor++;
            }
        }
        if (sum == 0) sum = 1;
        int rate = (int) ((double)good / (double)sum * 100) ;
        return R.ok().put("fellow", fellow).put("replyCount", sum).put("replyChance", rate).put("reply",comments);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("fellow:fellow:save")
    public R save(@RequestBody FellowEntity fellow){
		fellowService.save(fellow);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("fellow:fellow:update")
    public R update(@RequestBody FellowEntity fellow){
		fellowService.updateById(fellow);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("fellow:fellow:delete")
    public R delete(@RequestBody Long[] ids){
		fellowService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
