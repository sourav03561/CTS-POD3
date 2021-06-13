package com.cts.pmsm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EmployeeCreationMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeCreationMicroserviceApplication.class, args);
	}

}
