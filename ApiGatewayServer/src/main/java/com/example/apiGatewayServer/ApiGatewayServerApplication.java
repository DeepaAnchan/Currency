package com.example.apiGatewayServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class ApiGatewayServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayServerApplication.class, args);
	}
	
	@Bean
	public RouteLocator myRoutes(RouteLocatorBuilder builder) {

		return builder.routes()
				.route(p -> p.path("/get")
						.filters(f -> f.addRequestHeader("Hello", "World").addRequestParameter("Param", "Param1"))
						.uri("http://httpbin.org:80"))
				.route(p -> p.path("/manage-currency-conversion/**")
						.uri("lb://manage-currency-conversion/"))
				.route(p -> p.path("/convert-currency-service/**")
						.uri("lb://convert-currency-service"))
				.build();
	}
}
