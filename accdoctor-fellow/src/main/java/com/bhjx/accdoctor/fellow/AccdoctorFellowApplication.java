package com.bhjx.accdoctor.fellow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


@EnableFeignClients(basePackages = "com.bhjx.accdoctor.fellow.feign")
@EnableDiscoveryClient
@SpringBootApplication
public class AccdoctorFellowApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccdoctorFellowApplication.class, args);
    }

}
