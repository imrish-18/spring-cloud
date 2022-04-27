package com.address.service.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.address.service.domain.Address;
import com.address.service.service.AddressService;


import reactor.core.publisher.Mono;

@Component
public class AddressHandler {

	
	@Autowired
	AddressService service;
	
	public Mono<ServerResponse> addNewAddress(ServerRequest serverRequest) {
		   
		 return serverRequest.bodyToMono(Address.class).flatMap(empl->{
				return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).
			body(service.addNewAddress(empl), Address.class);
			});
	  }
}
