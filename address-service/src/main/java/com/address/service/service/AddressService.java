package com.address.service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.address.service.domain.Address;
import com.address.service.repo.AddressRepo;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class AddressService {

	
	@Autowired
	AddressRepo repo;
	
	
	public Mono<Address> addNewAddress(@RequestBody Address address)
	{
		return repo.save(address);
	}
	
	public Mono<Address> getAddressById(String id)
	{
		return repo.findById(id);
	}
	
	
	public Flux<Address> getAllAddress()
	{
		return repo.findAll();
	}
	
	
}
