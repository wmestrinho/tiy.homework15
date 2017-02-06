package com.example.repository;

import com.example.data.Instructor;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by WagnerMestrinho on 2/4/17.
 */
public interface InstructorRepo extends CrudRepository<Instructor, Long>{
}
