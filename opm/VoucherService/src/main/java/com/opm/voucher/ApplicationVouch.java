package com.opm.voucher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by kfzx-liuyz1 on 2016/10/21.
 */
@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan({"com.opm.voucher","com.opm.common"})
@EnableEurekaClient
@EnableFeignClients
public class ApplicationVouch {
    public static void main(String[] args){
        SpringApplication.run(ApplicationVouch.class,args);
    }

}
