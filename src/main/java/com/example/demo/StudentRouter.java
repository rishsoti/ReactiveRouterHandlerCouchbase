package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;

@Configuration
public class StudentRouter {

	@Bean // bean of type routerfuctions
	RouterFunction<?> routes(StudentsHandler handlers)
	{
		return RouterFunctions.route(RequestPredicates.GET("/hr/students"),handlers::getAll)
		               .andRoute(RequestPredicates.GET("/hr/students/{id}"),handlers::getById)
		               .andRoute(RequestPredicates.POST("/hr/students"),handlers::postStudent)
		               .andRoute(RequestPredicates.PUT("/hr/update"),handlers::updateStudent)
		               .andRoute(RequestPredicates.DELETE("/hr/delete"),handlers::deleteStudent);
		

	}

}
