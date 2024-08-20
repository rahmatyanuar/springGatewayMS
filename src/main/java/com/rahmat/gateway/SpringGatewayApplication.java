package com.rahmat.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.swagger.web.UiConfiguration;

@SpringBootApplication
public class SpringGatewayApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringGatewayApplication.class, args);
	}
	
	@Bean
	UiConfiguration uiConfig() {
		return new UiConfiguration("validatorUrl", "list", "alpha", "schema",
				UiConfiguration.Constants.DEFAULT_SUBMIT_METHODS, false, true, 60000L);
	}

}
