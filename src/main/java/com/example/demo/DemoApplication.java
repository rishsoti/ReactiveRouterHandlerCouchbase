package com.example.demo;

import java.util.UUID;
import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@Bean
	CommandLineRunner employees(StudentRepository  employeeRepository) {

		return args -> {
			employeeRepository
					.deleteAll()
			.subscribe(null, null, () -> {
				

				Stream.of(
						 new Student(UUID.randomUUID().toString(),"Kevin", "Peterson")
						,new Student(UUID.randomUUID().toString(),"Ross", "Taylor")
						,new Student(UUID.randomUUID().toString(),"Stuart", "Broad")
						,new Student(UUID.randomUUID().toString(),"Chris", "Harris")
						,new Student(UUID.randomUUID().toString(),"David", "Warner")
						,new Student(UUID.randomUUID().toString(),"Ricky", "Ponting")
						,new Student(UUID.randomUUID().toString(),"Steve", "Smith")
						,new Student(UUID.randomUUID().toString(),"Tim", "Southee")
						)
						.forEach(student -> {
				         employeeRepository
						.save(student)
						.subscribe(System.out::println);

						});

			})
			;
		};

	}



}
