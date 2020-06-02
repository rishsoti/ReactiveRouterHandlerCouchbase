package com.example.demo;
import org.springframework.data.couchbase.repository.ReactiveCouchbaseRepository;
import org.springframework.stereotype.Repository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface StudentRepository extends  ReactiveCouchbaseRepository<Student, String>{

	

	Flux<Student> save(Mono<Student> student);

	
	
}