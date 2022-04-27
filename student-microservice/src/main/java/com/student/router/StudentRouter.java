package com.student.router;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import com.student.handler.StudentHandler;

import reactor.core.publisher.Mono;

@Configuration
public class StudentRouter {

	
	@Bean
	  public RouterFunction<ServerResponse> getString(StudentHandler showHandler) {
	    return RouterFunctions
	      .route(RequestPredicates.GET("/getAll").and(RequestPredicates.
	    		  accept(MediaType.APPLICATION_JSON)), showHandler::getStream);
	  }
	
	@Bean
	  public RouterFunction<ServerResponse> getAddress(StudentHandler showHandler) {
	    return RouterFunctions
	      .route(RequestPredicates.GET("/getAll/{id}").and(RequestPredicates.
	    		  accept(MediaType.APPLICATION_JSON)), showHandler::getById);
	  }
	
	
	 /**
  	 * Postdata.
  	 *
  	 * @param handler the handler
  	 * @return the router function
  	 */
  	@Bean
	  public RouterFunction<ServerResponse> postEmp(StudentHandler handler)
	  {
	 return RouterFunctions.route(RequestPredicates.POST("/postEmp").
			 and(RequestPredicates.contentType(MediaType.APPLICATION_JSON)), handler::postEmp);
}
}
