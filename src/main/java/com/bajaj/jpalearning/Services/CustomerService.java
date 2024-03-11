package com.bajaj.jpalearning.Services;

import com.bajaj.jpalearning.entities.Customer;
import com.bajaj.jpalearning.exceptions.EntityIsAlreadyExistException;
import com.bajaj.jpalearning.exceptions.EntityNotFoundException;
import com.bajaj.jpalearning.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomerById(Long id) {
        Optional<Customer> customer = customerRepository.findById(id);
        if (customer.isPresent()) {
            return customer.get();
        }
        throw new EntityNotFoundException("Customer with given ID is not present");
    }

    public Customer createCustomer(Customer customer) {
        if (customerRepository.findByEmailId(customer.getEmailId()).isEmpty()) {
            Customer newCustomer = customerRepository.save(customer);
            newCustomer.setPassword(null);
            return newCustomer;
        }
        throw new EntityIsAlreadyExistException("Customer with given ID is already exist");
    }

    public void deleteCustomerById(Long id) {
        Optional<Customer> customer = customerRepository.findById(id);
        if (customer.isPresent()) {
            customerRepository.deleteById(id);
        }
    }

//    public Customer updateCustomer(Long id, Customer customer) {
//        List<Customer> customers = customerRepository.findAll();
//        customer.setId(id);
//        customers = customers.stream().map(cust -> {
//            if (cust.getId() == customer.getId()) {
//                cust.setName(customer.getName());
//                cust.setAddresses(customer.getAddresses());
//            }
//            return cust;
//        }).collect(Collectors.toList());
//
//        if (customerRepository.findById(customer.getId()).isPresent()) {
//            customerRepository.save(customer);
//            return customer;
//        }
//        throw new EntityNotFoundException("Customer with given ID is not present");
//    }

    public Customer updateCustomer(Customer customer) {

        Optional<Customer> customerOptional = customerRepository.findById(customer.getId());

        if (customerOptional.isPresent()) {
            customerOptional.get().setName(customer.getName());
            Customer updateCustomer = customerRepository.save(customerOptional.get());
            return updateCustomer;
        } else {
            throw new EntityIsAlreadyExistException("Customer with this email already exists");
        }


//        Optional<Customer> customerOptional = customerRepository.updateCustomerById(id, name);
//        return customerOptional;

    }
}
