package com.bajaj.jpalearning.Controller;

import com.bajaj.jpalearning.Services.AddressService;
import com.bajaj.jpalearning.beans.ResponseHandler;
import com.bajaj.jpalearning.entities.Address;
import com.bajaj.jpalearning.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/addresses")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping("/")
    public ResponseEntity<Object> getAllAddresses() {
        List<Address> addresses = addressService.getAll();
        return ResponseHandler.createResponse("", HttpStatus.OK, addresses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAddressesById(@PathVariable Long id) {
        Address addresses = addressService.getAddressesByItsId(id);
        return ResponseHandler.createResponse("Address found", HttpStatus.OK, addresses);
    }

    @PostMapping("/create")
    public ResponseEntity<Object> createAddress(@RequestBody Address address) {
        Object createdAddress = addressService.createAddress(address);
        return ResponseHandler.createResponse("New Address is created", HttpStatus.CREATED, createdAddress);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAddressById(@PathVariable Long id) {
        Address address = addressService.getAddressesByItsId(id);
        addressService.deleteAddressById(id);
        return ResponseHandler.createResponse("Address Deleted", HttpStatus.OK,  address);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateAddress(@PathVariable Long id, @RequestBody Address address) {
        Address updatedAddress = addressService.updateAddress(id,address);
        return ResponseHandler.createResponse("Address updated", HttpStatus.OK, updatedAddress);
    }
}
