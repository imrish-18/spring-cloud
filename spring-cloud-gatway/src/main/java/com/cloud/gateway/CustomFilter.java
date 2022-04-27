package com.cloud.gateway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

// TODO: Auto-generated Javadoc
/**
 * The Class CustomFilter.
 */
@Configuration
public class CustomFilter implements GlobalFilter{

	 /** The log. */
 	private  Logger log = LoggerFactory.getLogger(this.getClass());

	/**
	 * Filter.
	 *
	 * @param exchange the exchange
	 * @param chain the chain
	 * @return the mono
	 */
	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		// TODO Auto-generated method stub
		
		ServerHttpRequest request=exchange.getRequest();
		log.info("Authorization.."+request.getHeaders().getFirst("Authorization").charAt(0));
		return chain.filter(exchange)
				.then(Mono.fromRunnable(()->{
					ServerHttpResponse response=exchange.getResponse();
					log.info("post filter = {}",response.getStatusCode());
				}));
	}
}
