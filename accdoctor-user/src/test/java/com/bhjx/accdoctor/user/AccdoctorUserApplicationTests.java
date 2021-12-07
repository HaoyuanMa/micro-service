package com.bhjx.accdoctor.user;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bhjx.accdoctor.user.entity.UserEntity;
import com.bhjx.accdoctor.user.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
class AccdoctorUserApplicationTests {

    @Autowired
    UserService userService;

    @Test
    void contextLoads() {
//        UserEntity userEntity = new UserEntity();
//        userEntity.setId(1L);
//        userEntity.setUsername("test-update");
        List<UserEntity> list = this.userService.list(new QueryWrapper<UserEntity>().eq("id", 1L));
        list.forEach((i)->{
            System.out.println(i);
        });
        System.out.println("保存成功...");
    }

}
