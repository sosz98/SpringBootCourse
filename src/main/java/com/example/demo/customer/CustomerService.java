package com.example.demo.customer;


import com.example.demo.exception.NotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
@Slf4j
public class CustomerService {

    private final CustomerRepository customerRepository;



    List<Customer> getCustomers() {
        log.info("getCostumers was called");
        return customerRepository.findAll();
    }




    Customer getCustomer(Long id) {
        return customerRepository
                .findById(id)
                .orElseThrow(() ->
                        new NotFoundException(
                                "Customer with id: " + id + " not found"));
    }

}
