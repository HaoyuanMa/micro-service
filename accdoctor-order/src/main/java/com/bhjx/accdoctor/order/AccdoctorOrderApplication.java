package com.bhjx.accdoctor.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(basePackages = "com.bhjx.accdoctor.order.feign")
@EnableDiscoveryClient
@SpringBootApplication
public class AccdoctorOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccdoctorOrderApplication.class, args);
    }

}
