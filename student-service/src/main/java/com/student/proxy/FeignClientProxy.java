package com.student.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.student.model.Address;

import reactor.core.publisher.Mono;

@FeignClient(name="student-feign-clienet",url="http://localhost:9000")
public interface FeignClientProxy {
	
	@GetMapping("/getAddress/{id}")
	public Mono<Address> getAddress(@PathVariable String id);
}
