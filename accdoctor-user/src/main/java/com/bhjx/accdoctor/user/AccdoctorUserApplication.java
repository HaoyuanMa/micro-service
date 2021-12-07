package com.bhjx.accdoctor.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.bhjx.accdoctor.user.dao")
@SpringBootApplication
public class AccdoctorUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccdoctorUserApplication.class, args);
    }

}
