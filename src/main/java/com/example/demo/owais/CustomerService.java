package com.example.demo.owais;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    public List<Customer> addCustomer(Customer customer) {
        customerRepository.save(customer);
        return customerRepository.findAll();
    }

    public List<Customer> deleteCustomer(Integer id) {
        customerRepository.deleteById(id);
        return customerRepository.findAll();
    }

    public Customer updateCustomer(Customer customer) {
        Optional<Customer> customerOptional = customerRepository.findById(customer.getId());
        if(customerOptional.isPresent()) {
            Customer customerFromDb = customerOptional.get();
            customerFromDb.setName(customer.getName());
            customerFromDb.setEmail(customer.getEmail());
            customerFromDb.setAge(customer.getAge());
            return customerRepository.save(customerFromDb);
        } else {
            throw new IllegalArgumentException("Customer with id: " + customer.getId() + ", was not found.");
        }

    }

}
