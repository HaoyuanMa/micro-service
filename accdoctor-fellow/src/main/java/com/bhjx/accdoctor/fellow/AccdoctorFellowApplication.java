package com.bhjx.accdoctor.fellow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class AccdoctorFellowApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccdoctorFellowApplication.class, args);
    }

}
