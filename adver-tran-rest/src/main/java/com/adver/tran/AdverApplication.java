package com.adver.tran;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

//@SpringCloudApplication
//@EnableDiscoveryClient
@SpringBootApplication
public class AdverApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext cac = SpringApplication.run(AdverApplication.class);
	}

}
