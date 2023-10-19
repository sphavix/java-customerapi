package com.sphax.customerapi.customerapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomersController {
    @Autowired
    private CustomerRepository _customerRepo;

    @PostMapping("/add")
    public String addCustomer(@RequestParam String name, @RequestParam String surname){
        Customer customer = new Customer();
        customer.setFirstName(name);
        customer.setLastName(surname);

        _customerRepo.save(customer);
        return  "Customer has been added!";
    }

    @GetMapping("/list")
    public Iterable<Customer> getCustomers(){
        return _customerRepo.findAll();
    }

    @GetMapping("/find/{id}")
    public Customer findCustomerById(@PathVariable Integer id){
        return _customerRepo.findCustomerById(id);
    }
}
