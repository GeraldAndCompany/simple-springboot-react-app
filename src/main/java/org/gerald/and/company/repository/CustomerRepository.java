package org.gerald.and.company.repository;

import org.gerald.and.company.entity.Customer;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long> {
    List<Customer> findByLastName(String lastName);
}
