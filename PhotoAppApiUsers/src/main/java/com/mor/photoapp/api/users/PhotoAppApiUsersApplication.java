package com.mor.photoapp.api.users;

import feign.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/*
you can use it to discover service instances from the Eureka Server
 */
//@EnableDiscoveryClient

/*
Using this annotation, we enable component scanning for interfaces
that declare they are Feign clients.
 */
@SpringBootApplication
@EnableFeignClients
public class PhotoAppApiUsersApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhotoAppApiUsersApplication.class, args);
	}

	/*
	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	*/

	@Bean
	public Logger.Level feignLogger() {
		return Logger.Level.FULL;
	}

}
