package io.swagger.implement;

import io.swagger.model.Customer;
import io.swagger.service.CustomerService;
import io.swagger.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImplementCustomer implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Customer findById(Integer id) {

        return customerRepository.findByID(id);
    }

    @Override
    public List<Customer> findAll() {

        return  (List<Customer>) customerRepository.findAll();
    }

    @Override
    public void saveCustomer(Customer c) {

        customerRepository.save(c);

    }

    @Override
    public void updateCustomer(Customer c) {

        Customer customer = findById(c.getId());
        if(customer != null){

            customer.setName(c.getName());
            customer.setEmail(c.getEmail());
            customer.setCreationDate(c.getCreationDate());
            customerRepository.save(customer);
        }

    }

    @Override
    public void deletebyId(Integer id) {

        Customer delCustomer = findById(id);
        if(delCustomer.getId() != null){
            customerRepository.deleteById(id);
        }

    }

    @Override
    public void deleteAll() {

        customerRepository.deleteAll();

    }
}
