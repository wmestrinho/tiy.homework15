package com.example.repository;

import com.example.data.Address;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by WagnerMestrinho on 2/4/17.
 */
public interface AddressRepo extends CrudRepository<Address, Long> {
}
