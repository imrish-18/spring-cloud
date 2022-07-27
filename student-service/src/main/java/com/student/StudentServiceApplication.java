package com.student;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.reactive.function.client.WebClient;

import com.student.model.Address;

import reactor.core.publisher.Flux;

@SpringBootApplication
@EnableFeignClients("com.student.proxy")
@EnableMongoRepositories("com.student.repo")
@EntityScan("com.student.model")
@EnableEurekaClient
public class StudentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentServiceApplication.class, args);
		
		System.out.println("hello this is student service class");
	}
	static Flux<Address> call(WebClient http, String url) {
	    return http.get().uri(url).retrieve().bodyToFlux(Address.class);
	}
}
