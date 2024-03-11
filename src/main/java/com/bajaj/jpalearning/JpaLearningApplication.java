package com.bajaj.jpalearning;

import com.bajaj.jpalearning.entities.Address;
import com.bajaj.jpalearning.entities.Customer;
import com.bajaj.jpalearning.repositories.AddressRepository;
import com.bajaj.jpalearning.repositories.CartItemRepository;
import com.bajaj.jpalearning.repositories.CustomerRepository;
import com.bajaj.jpalearning.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class JpaLearningApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(JpaLearningApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        // Insert operation

        /*
        Customer customer1 = new Customer("Radhika", 22, "radhika@gmail.com", "radhika");
        customerRepository.save(customer1);
        Customer customer2 = new Customer("Sampada", 23, "sampada@gmail.com", "sampada");
        customerRepository.save(customer2);
        Customer customer3 = new Customer("Akash", 24, "akash@gmail.com", "akash");
        customerRepository.save(customer3);
         */

        // Select
/*
        List<Customer> customerList = customerRepository.findAll();
        customerList.forEach(
                (customer -> {
                    System.out.println("Customers" + customer);
                }));

 */
        // Where - select operation for single element based on id
        /*
         Optional<Customer> customer = customerRepository.findById(1L); // If customer with that id is not present hence take it as Optional

         if(customer.isPresent()) {
             System.out.println(customer.get());
        } else {
             System.out.println("Customer not found");
         }
         */

        // Find customer with Email id

        /*
        Optional<Customer> customer1 = customerRepository.findByEmailId("radhika@gmail.com"); // If customer with that id is not present hence take it as Optional

        if(customer1.isPresent()) {
            System.out.println(customer1.get());
        } else {
            System.out.println("Customer not found");
        }

         */
        // Find customer with Email id and age
        /*
        Optional<Customer> customer2 = customerRepository.findByEmailIdAndAge("radhika@gmail.com", 22); // If customer with that id is not present hence take it as Optional

        if(customer2.isPresent()) {
            System.out.println(customer2.get());
        } else {
            System.out.println("Customer not found");
        }
        */


        // Find customer with Email id or age

       /*
        List<Customer> customerList = customerRepository.findByEmailIdOrAge("malika@gmail.com", 22); // If customer with that id is not present hence take it as Optional
        customerList.forEach(
                (customer -> {
                    System.out.println("Customers" + customer);
                }));
        */

        /*
        List<Customer> customerList = customerRepository.findCustomers("Radhika", 22); // If customer with that id is not present hence take it as Optional
        customerList.forEach(
                (customer -> {
                    System.out.println("Customers" + customer);
                }));
         */

        // Finding and Updating
/*
        Optional<Customer> customer = customerRepository.findById(2L);

        if (customer.isPresent()) {
            Customer c = customer.get();
            c.setEmailId("saurabh@gmail.com");
            customerRepository.save(c);
            System.out.println("c");
        } else {
            System.out.println("Customer not found");
        }

 */
//        Customer customer = new Customer("Krishna",23,"krishna@gmail.com","krishna");
//
//        Address address1 = new Address(1,"pune",431101);
//        address1.setCustomer(customer);
//
//        Address address2 = new Address(2,"Mumbai",43123);
//        address2.setCustomer(customer);
//
//        customer.getAddresses().add(address1);
//        customer.getAddresses().add(address2);

//        List<Address>  addresses = new ArrayList<>();
//        addresses.add(address1);
//        addresses.add(address2);
//        customer.setAddresses(addresses);

//        customerRepository.save(customer);

    }

}
