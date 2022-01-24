package com.mor.photoapp.discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/*
It is a convenience annotation that combines the
@EnableAutoConfiguration, @Configuration and the @ComponentScan annotations.
*/
@SpringBootApplication

/*
Enable service registry where one dedicated server is responsible to maintain
the registry of all the Microservice that has been deployed and removed.
We don’t have to manually maintain address of other Microservices
 */
@EnableEurekaServer
public class PhotoAppDiscoveryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhotoAppDiscoveryServiceApplication.class, args);
	}

}
