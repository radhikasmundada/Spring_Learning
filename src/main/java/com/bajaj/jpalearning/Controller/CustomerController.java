package com.bajaj.jpalearning.Controller;

import com.bajaj.jpalearning.Services.CustomerService;
import com.bajaj.jpalearning.beans.ResponseHandler;
import com.bajaj.jpalearning.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

/*
    @GetMapping("/")
    public ResponseEntity<List<Customer>> getCustomers() {
        return new ResponseEntity<>(customerService.getAll(), HttpStatus.OK);
   }

 */
    @GetMapping("/")
    public ResponseEntity<Object> getCustomers() {
        List<Customer> customer = customerService.getAllCustomers();
        return ResponseHandler.createResponse("", HttpStatus.OK, customer);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCustomerById(@PathVariable Long id) {
        Customer customer = customerService.getCustomerById(id);
        return ResponseHandler.createResponse("Customer found", HttpStatus.OK,  customer);
        /*
        if (customer.isPresent()) {
            return ResponseHandler.createResponse("Customer Found", HttpStatus.OK, customer.get());
        } else {
//            Map<String,Object> response = new HashMap<>();
//            response.put("message", "Customer Not Found");

            return ResponseHandler.createResponse("Customer Not found", HttpStatus.NOT_FOUND, null);
        }
         */
    }

    @PostMapping("/create")
    public ResponseEntity<Object> createCustomer(@RequestBody Customer customer) {
        Object createdCustomer = customerService.createCustomer(customer);
        return ResponseHandler.createResponse("New customer is created", HttpStatus.CREATED, createdCustomer);

       /* if (createdCustomer != null) {
            return ResponseHandler.createResponse("New customer is created", HttpStatus.CREATED, createdCustomer);
        } else {
            return ResponseHandler.createResponse("Customer Already exist", HttpStatus.CONFLICT, null);
        }*/
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCustomerById(@PathVariable Long id) {
        Customer customer = customerService.getCustomerById(id);
        customerService.deleteCustomerById(id);
        return ResponseHandler.createResponse("Customer Deleted", HttpStatus.OK,  customer);
    }

    @PutMapping("/updateCustomer")
    public  Object update(@RequestBody Customer customer){
        Object customer1 = customerService.updateCustomer(customer);
        return ResponseHandler.createResponse("Customer name updated", HttpStatus.OK, customer1);
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<Object> updateCustomer(@PathVariable Long id, @RequestBody Customer customer) {
//        Customer updatedCustomer = customerService.updateCustomer(id, customer);
//        return ResponseHandler.createResponse("Customer updated", HttpStatus.OK, updatedCustomer);
//    }

}
