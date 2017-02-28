package com.opm.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.actuate.endpoint.SystemPublicMetrics;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by kfzx-liuyz1 on 2016/10/21.
 */
@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan({ "com.opm.core", "com.opm.common" })
@EnableEurekaClient
@EnableFeignClients
@RestController
public class ApplicationCore {

	@RequestMapping
	public String hello(HttpServletRequest request){
		request.getSession().setAttribute("testKey", request.getRequestURL());
		String sessionId = request.getSession().getId();
		Object testKey = request.getSession().getAttribute("testKey");
		System.out.println(sessionId);
		System.out.println(testKey.toString());
		return "HELLO WORLD";
	}

	public static void main(String[] args) {
		SpringApplication.run(ApplicationCore.class, args);
	}
}
