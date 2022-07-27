package com.student;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration

public class WebClientConfiguration {
	
	
	@Bean
	@LoadBalanced
	public WebClient.Builder loadBalancedWebClientBuilder() {
	   return WebClient.builder();
	}
	
	@Bean
    WebClient webClient(WebClient.Builder builder) {
        return builder.build();
    }
}
