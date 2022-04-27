package com.address.service.router;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.address.service.domain.Address;
import com.address.service.handler.AddressHandler;
import com.address.service.service.AddressService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController

public class AddressController {

	
	@Autowired
	AddressService service;
	
	@Autowired
	private ServerProperties serverProperties;
	
	 Logger logger = LoggerFactory.getLogger(AddressController.class);
	
	@GetMapping("/path")
	public String disp()
	{
		return "hello";
	}
	
	@PostMapping("/saveAddress")
	public Mono<Address> addNewAddress(@RequestBody Address address) {
		   
		return service.addNewAddress(address);
	  }
	
	@GetMapping("/getAddress/{id}")
	public Mono<Address> getAddress(@PathVariable String id) {
		   
		logger.info("this is address id :{} ",serverProperties.getPort());
		return service.getAddressById(id);
	  }
	
	@GetMapping("/getAllAddress")
	public Flux<Address> getAllAddress() {
		   
		logger.info("this is address id :{} ",serverProperties.getPort());
		return service.getAllAddress();
	  }
	
}
