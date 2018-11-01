package com.studentscore.demo.repository;

import com.studentscore.demo.entity.Test;
import org.springframework.data.repository.CrudRepository;

public interface TestRepository extends CrudRepository<Test, Long> {
}
