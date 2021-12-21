package com.bhjx.accdoctor.fellow.controller;

import java.util.*;


import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import com.bhjx.accdoctor.fellow.entity.FellowCommentAddEntity;
import com.bhjx.accdoctor.fellow.feign.OrderFeignService;
import com.bhjx.accdoctor.fellow.feign.UserFeignService;
import com.bhjx.common.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @Autowired
    private OrderFeignService orderFeignService;
    @Autowired
    private UserFeignService userFeignService;

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
    @RequestMapping("/add")
    //@RequiresPermissions("fellow:fellowcomment:save")
    public R save(@RequestBody FellowCommentAddEntity fellowComment, @RequestHeader("Authorization") String token){
        long userId = JwtUtils.getUserIdFromToken(token);
        if (userId <= 0) return R.error(401,"鉴权失败");

        R res = userFeignService.info(token);
        LinkedHashMap user = (LinkedHashMap) res.get("user");


        FellowCommentEntity newComment = new FellowCommentEntity();

        newComment.setUserId(userId);
        newComment.setCreateTime(new Date());
        newComment.setUserIcon(user.get("header").toString());

        newComment.setFellowId(fellowComment.getFellowId());
        newComment.setFellowName(fellowComment.getFellowName());
        newComment.setUserNickName(fellowComment.getUserNickName());
        newComment.setContent(fellowComment.getContent());
        newComment.setCommentType(fellowComment.getCommentType());

        if(fellowCommentService.save(newComment)){
            Long orderId = fellowComment.getOrderId();
            orderFeignService.finishOrder(orderId,token);

            return R.ok();
        }

        return R.error(500,"faild");
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
