package com.student.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.reactive.ReactorLoadBalancerExchangeFilterFunction;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.student.model.Address;
import com.student.model.Student;
import com.student.proxy.FeignClientProxy;
import com.student.repo.StudentRepo;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class StudentService 
{
	

	/*
	 * @Autowired(required = true) FeignClientProxy proxy;
	 *  feign client is not supported with spring web flux
	 */
	
	@Autowired
	private ReactorLoadBalancerExchangeFilterFunction lbFunction;
	
	 Logger logger = LoggerFactory.getLogger(StudentService.class);
	@Autowired
	WebClient webClient;
	@Autowired
	StudentRepo repo;
	
	private String street="";
	private String city="";
	
	public Flux<Student> getString()
	{
		return repo.findAll();
		//return Mono.just("hello this....");
	}
	
	public Mono<Student> addNewStudent(Student student)
	{
		
		return repo.save(student);
	}
	
   @CircuitBreaker(name="addressService"	)
	public Flux<Address> getAllAddress()
	{
//		logger.info("this is id :{}",id);
//		String url="http://ADDRESS-SERVICE/getAddress/"+id;
		
		return WebClient.builder().filter(lbFunction)
		.build()
		.get()
		.uri("http://address-service/getAllAddress")
		//s.accept(MediaType.APPLICATION_JSON)ss
        .retrieve()
        .bodyToFlux(Address.class);
		
	}
   
 public Address  fallbackById(String adressId,Throwable th)
 {
	 return new Address();
 }
	public Mono<Address> getAddressById(String id)
	{
		String url="http://address-service/getAddress/"+id;
		return WebClient.create()
		.get()
		.uri(url)
		.retrieve()
		.bodyToMono(Address.class);
	}
	
	public Mono<Student> getStudentById(String id)
	{
		Mono<Address> address=getAddressById(id).map(res->{
			logger.info("this is street",res.getStreet());
			return res;
		});
		return repo.findById(id);
	}
	
	/**
	 * Update.
	 *
	 * @param id the id
	 * @return the mono
	 */
	
	
	public Mono<Student> updateStudentById(String id)
	{
//		var address=getAddressById(id).map(res->{
//			city=res.getCity()+"us";
//			street=res.getStreet();
//			return res;
//		}).subscribe();
//		
		//System.out.println(city+" "+street+" "+address);
		return repo.findById(id).map(obj->{
	    obj.setAddress(street);
	    obj.setCity(city);
		return obj;
		}).flatMap(ob->{
			
			return repo.save(ob);
		});
	}

}
