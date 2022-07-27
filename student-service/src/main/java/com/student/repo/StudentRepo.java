package com.student.repo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.student.model.Student;

@Repository
public interface StudentRepo extends ReactiveMongoRepository<Student, String> {

}
