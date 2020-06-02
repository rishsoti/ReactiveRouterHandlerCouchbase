package com.example.demo;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Service
@Transactional
@AllArgsConstructor
public class StudentService {
	@Autowired
	
	private StudentRepository repo;
	
	public Flux<Student> findAll() {
		return repo.findAll().switchIfEmpty(Flux.empty());
	}
	public Mono<Student> findById(final String id) {
		return repo.findById(id);
	}

	public Mono save(final Student student) {
		return repo.save(student);
	}

	public Mono delete(final String id) {
		final Mono<Student> dbStudent = findById(id);
		if (Objects.isNull(dbStudent)) {
			return Mono.empty();
		}
		return findById(id).switchIfEmpty(Mono.empty()).filter(Objects::nonNull).flatMap(studentToBeDeleted -> repo
				.delete(studentToBeDeleted).then(Mono.just(studentToBeDeleted)));
	}


	public Flux<Student> save(final Mono<Student> student) {
		return repo.insert(student);
	}
	
	public void deleteById(Mono student_db) {
		repo.deleteById(student_db);

	}


}