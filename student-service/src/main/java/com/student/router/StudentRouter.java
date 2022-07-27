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
	      .route(RequestPredicates.GET("/getAllAddress").and(RequestPredicates.
	    		  accept(MediaType.APPLICATION_JSON)), showHandler::getAllAddress);
	  }
	
	@Bean
	  public RouterFunction<ServerResponse> getStudent(StudentHandler showHandler) {
	    return RouterFunctions
	      .route(RequestPredicates.GET("/getStudent/{id}").and(RequestPredicates.
	    		  accept(MediaType.APPLICATION_JSON)), showHandler::getStduentById);
	  }
	
	@Bean
	  public RouterFunction<ServerResponse> updateStudent(StudentHandler showHandler) {
	    return RouterFunctions
	      .route(RequestPredicates.PUT("/updateStudent/{id}").and(RequestPredicates.
	    		  accept(MediaType.APPLICATION_JSON)), showHandler::updateById);
	  }
	 /**
  	 * Postdata.
  	 *
  	 * @param handler the handler
  	 * @return the router function
  	 */
  	@Bean
	  public RouterFunction<ServerResponse> addNewStudent(StudentHandler handler)
	  {
	 return RouterFunctions.route(RequestPredicates.POST("/save/student").
			 and(RequestPredicates.contentType(MediaType.APPLICATION_JSON)), handler::saveNewStudent);
}
}
