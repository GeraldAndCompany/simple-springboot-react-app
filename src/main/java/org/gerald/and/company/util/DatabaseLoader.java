package org.gerald.and.company.util;

import org.gerald.and.company.entity.Customer;
import org.gerald.and.company.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader implements CommandLineRunner {

    private final CustomerRepository customerRepository;

    @Autowired
    public DatabaseLoader(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void run(String... strings) throws Exception {
        customerRepository.save(new Customer("Person", "McPersonFace"));
        customerRepository.save(new Customer("Someone", "Someoneson"));
    }
}
