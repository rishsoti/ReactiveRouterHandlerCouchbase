package com.example.demo;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Mono;

@Component
public class StudentsHandler {

	@Autowired
	StudentService service;

	//GETALL
	public Mono<ServerResponse> getAll(ServerRequest request) {
		
		
		return ServerResponse.ok().contentType(MediaType.TEXT_EVENT_STREAM).body(service.findAll().delayElements(Duration.ofSeconds(1)),Student.class);      //object,type of object
	}

	//GET BY ID
	public Mono<ServerResponse> getById(ServerRequest request) {

		String myId = request.pathVariable("id").toString();
		return ServerResponse.ok().body(service.findById(myId),Student.class);      
	}

	//ADD
	public Mono<ServerResponse> postStudent(ServerRequest request) {
		final Mono<Student> student = request.bodyToMono(Student.class);

		return ServerResponse.ok().body(service.save(student),Student.class); 
	}

	//UPDATE
	public Mono<ServerResponse> updateStudent(ServerRequest request) {
		
		String myId = request.pathVariable("id").toString();
		final Mono<Student> student = request.bodyToMono(Student.class);
		
		return ServerResponse.ok().body(student.map(ref -> new Student(myId, ref.getFirstName(),ref.getLastName())) 
		        .flatMap(service::save),Student.class);             
	}


	//REMOVE
	public Mono<ServerResponse> deleteStudent(ServerRequest request) {
		String myId = request.pathVariable("id").toString();

        return ServerResponse.ok().body(service.delete(myId),Student.class);   
		
	}



}
