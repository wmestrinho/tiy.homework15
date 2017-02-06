package com.example.repository;

import com.example.data.Company;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by WagnerMestrinho on 2/4/17.
 */
public interface CompanyRepo extends CrudRepository<Company, Long>{
}
