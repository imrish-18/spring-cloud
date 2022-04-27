

package com.address.service.router;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.address.service.handler.AddressHandler;

@Configuration
public class AddressRouter {

	@Bean
	 public RouterFunction<ServerResponse> getAllAddressRouter(AddressHandler handler)
	 {
		
		return RouterFunctions.route()
				   .nest(RequestPredicates.path("/v1/address"),builder->{
					   builder.POST("/save",req->handler.addNewAddress(req));
//					   .GET("/movies",req->handler.getReview(req))
//				       .PUT("/{id}",req->handler.updateReview(req))
//				       .DELETE("/{id}",req->handler.deleteReview(req));
				   })
				   .build();
	 }
	@Bean
	  public RouterFunction<ServerResponse> postEmp(AddressHandler handler)
	  {
	 return RouterFunctions.route(RequestPredicates.POST("/postAdd").
			 and(RequestPredicates.contentType(MediaType.APPLICATION_JSON)), handler::addNewAddress);
}
}
