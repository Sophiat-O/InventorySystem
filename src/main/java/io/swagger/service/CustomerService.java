package io.swagger.service;

import io.swagger.model.Customer;

import java.util.List;

public interface CustomerService {

    Customer findById(Integer id);

    List<Customer> findAll();

    void saveCustomer(Customer c);

    void updateCustomer(Customer c);


    void deletebyId(Integer id);

    void deleteAll();

}
