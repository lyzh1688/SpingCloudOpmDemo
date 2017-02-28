package com.opm.data;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by kfzx-liuyz1 on 2016/10/21.
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@RestController
public class Application {
    @RequestMapping("/hello")
    public String getUserName() {
        return " hello Liu YueZhi";
    }

    public static void main(String[] args){
        SpringApplication.run(Application.class,args);
    }

}
