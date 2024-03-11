package com.bajaj.jpalearning.Services;

import com.bajaj.jpalearning.entities.Address;
import com.bajaj.jpalearning.entities.Customer;
import com.bajaj.jpalearning.exceptions.EntityIsAlreadyExistException;
import com.bajaj.jpalearning.repositories.AddressRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    public List<Address> getAll() {
        return addressRepository.findAll();
    }

    public Address getAddressesByItsId(Long id) {
        Optional<Address> address = addressRepository.findById(id);
        if (address.isPresent()) {
            return address.get();
        }
        throw new EntityNotFoundException("Address with given ID is not present");
    }

    public Address createAddress(Address address) {
        Address newAddressOfCustomer = addressRepository.save(address);
        return newAddressOfCustomer;
    }

    public void deleteAddressById(Long id) {
        Optional<Address> address = addressRepository.findById(id);
        if (address.isPresent()) {
            addressRepository.deleteById(id);
        }
    }

    public Address updateAddress(Long id, Address address) {
        address.setId(id);

        if (addressRepository.findById(address.getId()).isPresent()) {
            addressRepository.save(address);
            return address;
        }

//        List<Address> addresses = addressRepository.findAll();
//        address.setId(id);
//        addresses = addresses.stream().map( addr-> {
//            if (addr.getId() == address.getId()) {
//                address.setPincode(address.getPincode());
//            }
//            return addr;
//        }).collect(Collectors.toList());
//
//        if (addressRepository.findById(address.getId()).isPresent()) {
//            addressRepository.save(address);
//            return address;
//        }
        throw new EntityNotFoundException("Address with given ID is not present");
    }
}
