package com.studentscore.demo.repository;

import com.studentscore.demo.entity.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long> {
}
