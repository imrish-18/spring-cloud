package com.student;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.student.model.Address;

import reactor.core.publisher.Flux;

//@Component
//class ConfiguredWebClientRunner {
//	
//	 Logger logger = LoggerFactory.getLogger(ConfiguredWebClientRunner.class);
//
//
//    ConfiguredWebClientRunner(WebClient http) {
//        call(http, "http://localhost:9000/getAddress/id").subscribe(greeting -> logger.info("configured: " + greeting.toString()));
//    }
//    
//    
//    static Flux<Address> call(WebClient http, String url) {
//        return http.get().uri(url).retrieve().bodyToFlux(Address.class);
//    }
//}
