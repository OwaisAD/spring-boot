package com.example.demo.owais;

import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customer")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<Customer> getCustomers() {
        return customerService.getCustomers();
    }

    record NewCustomerRequest(String name, String email, Integer age) {}
    @PostMapping
    public List<Customer> addCustomer(@RequestBody NewCustomerRequest request) {
        Customer customer = new Customer();
        customer.setName(request.name());
        customer.setEmail(request.email());
        customer.setAge(request.age());

        return customerService.addCustomer(customer);
    }

    @DeleteMapping("{customerId}")
    public List<Customer> deleteCustomer(@PathVariable("customerId") Integer id) {
        return customerService.deleteCustomer(id);
    }

    @PutMapping("{customerId}")
    public Customer updateCustomer(@RequestBody NewCustomerRequest request, @PathVariable("customerId") Integer id) {
        Customer customerToBeUpdated = new Customer();
        customerToBeUpdated.setId(id);
        customerToBeUpdated.setName(request.name());
        customerToBeUpdated.setEmail(request.email());
        customerToBeUpdated.setAge(request.age());

        return customerService.updateCustomer(customerToBeUpdated);
    }
}
