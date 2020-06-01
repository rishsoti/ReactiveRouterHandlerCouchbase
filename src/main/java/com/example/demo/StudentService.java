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
 private StudentRepository registrationRepository;
public Flux<Student> findAll() {
  return registrationRepository.findAll().switchIfEmpty(Flux.empty());
 }
public Mono<Student> findById(final String id) {
  return registrationRepository.findById(id);
 }
public Mono update(final String id, final Student student) {
  return registrationRepository.save(student);
 }
public Mono save(final Student student) {
  return registrationRepository.save(student);
 }
 
 public Mono delete(final String id) {
  final Mono<Student> dbStudent = findById(id);
  if (Objects.isNull(dbStudent)) {
   return Mono.empty();
  }
  return findById(id).switchIfEmpty(Mono.empty()).filter(Objects::nonNull).flatMap(studentToBeDeleted -> registrationRepository
    .delete(studentToBeDeleted).then(Mono.just(studentToBeDeleted)));
 }
 
 
 public Flux<Student> save(final Mono<Student> student) {
	  return registrationRepository.insert(student);
	 }
public void deleteById(Mono student_db) {
	registrationRepository.deleteById(student_db);
	
}
}