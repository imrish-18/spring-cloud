package com.student.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.model.Address;
import com.student.model.Student;
import com.student.proxy.FeignClientProxy;
import com.student.repo.StudentRepo;

import reactor.core.publisher.Mono;

@Service
public class StudentService {

	@Autowired
	FeignClientProxy proxy;
	
	@Autowired
	StudentRepo repo;
	
	public Mono<String> getString()
	{
		return Mono.just("hello this....");
	}
	
	public Mono<Student> addNewStudent(Student student)
	{
		return repo.save(student);
	}
	
	public Mono<Address> getAddressById(String id)
	{
		return proxy.getAddress(id);
	}
}
