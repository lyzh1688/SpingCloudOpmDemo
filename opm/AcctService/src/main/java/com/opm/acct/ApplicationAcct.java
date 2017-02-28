package com.opm.acct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * Created by kfzx-liuyz1 on 2016/10/21.
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class ApplicationAcct {
    public static void main(String[] args){
        SpringApplication.run(ApplicationAcct.class,args);
    }

}
