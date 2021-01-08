package com.iv.p404.repository;

import com.iv.p404.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {

    Optional<Customer> getCustomerById(Integer id);

}
