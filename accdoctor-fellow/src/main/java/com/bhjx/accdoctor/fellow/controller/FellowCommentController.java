package com.bhjx.accdoctor.fellow.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;


import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bhjx.accdoctor.fellow.entity.FellowCommentEntity;
import com.bhjx.accdoctor.fellow.service.FellowCommentService;
import com.bhjx.common.utils.PageUtils;
import com.bhjx.common.utils.R;



/**
 * 陪诊员评价
 *
 * @author mhy
 * @email mhy@bit.edu.cn
 * @date 2021-12-16 11:48:56
 */
@RestController
@RequestMapping("fellow/fellowcomment")
public class FellowCommentController {
    @Autowired
    private FellowCommentService fellowCommentService;

    @RequestMapping("/config")
    public R config(@RequestParam Map<String, Object> params){
        List<FellowCommentEntity> comments = fellowCommentService.queryList(params,0);
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
        int star = (int)(good * 4.5 + in * 3 + poor * 1.5)/sum;
        return R.ok().put("sum_count",sum)
                .put("good_count",good)
                .put("in_count",in)
                .put("poor_count",poor)
                .put("reply_chance",rate)
                .put("reply_star",star);
    }
    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("fellow:fellowcomment:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = fellowCommentService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("fellow:fellowcomment:info")
    public R info(@PathVariable("id") Long id){
		FellowCommentEntity fellowComment = fellowCommentService.getById(id);

        return R.ok().put("fellowComment", fellowComment);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("fellow:fellowcomment:save")
    public R save(@RequestBody FellowCommentEntity fellowComment){
		fellowCommentService.save(fellowComment);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("fellow:fellowcomment:update")
    public R update(@RequestBody FellowCommentEntity fellowComment){
		fellowCommentService.updateById(fellowComment);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("fellow:fellowcomment:delete")
    public R delete(@RequestBody Long[] ids){
		fellowCommentService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
