package com.address.service.repo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.address.service.domain.Address;


@Repository
public interface AddressRepo extends ReactiveMongoRepository<Address, String> {

}
