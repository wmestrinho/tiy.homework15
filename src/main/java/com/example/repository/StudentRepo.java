package com.example.repository;

import com.example.data.Student;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by WagnerMestrinho on 2/4/17.
 */
public interface StudentRepo extends CrudRepository<Student, Long> {
}
