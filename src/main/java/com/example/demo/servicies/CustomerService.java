package com.example.demo.servicies;

import com.example.demo.repository.entities.Address;
import com.example.demo.repository.entities.Customer;
import com.example.demo.repository.entities.Store;
import com.example.demo.repository.repos.AddressRepo;
import com.example.demo.repository.repos.CustomerRepo;
import com.example.demo.repository.repos.StoreRepo;
import com.example.demo.webserviceies.rest.DTOs.CustomerDTO;
import jakarta.persistence.PersistenceException;
import org.modelmapper.ModelMapper;
import java.time.Instant;

public class CustomerService extends BaseService<Customer, CustomerRepo>{
    private CustomerRepo customerRepo;
    private StoreRepo storeRepo;
    private AddressRepo addressRepo;
    private ModelMapper modelMapper;
    public CustomerService(){
        super(new CustomerRepo());
        this.storeRepo = new StoreRepo();
        this.addressRepo = new AddressRepo();
        this.customerRepo = new CustomerRepo();
        this.modelMapper = new ModelMapper();
    }

    public Customer create(CustomerDTO customerDTO) throws PersistenceException {
        //Fetch store and address from database
        Store store = storeRepo.getById(customerDTO.getStore_ID());
        Address address = addressRepo.getByName("address", customerDTO.getAddress());

        //Create new customer
        Customer customer = modelMapper.map(customerDTO, Customer.class);
        customer.setActive(true);
        customer.setStore(store);
        customer.setAddress(address);
        customer.setLastUpdate(Instant.now());

        //Save this customer
        try {
            customerRepo.save(customer);
        }catch (PersistenceException persistenceException){
            throw new PersistenceException("Can't save this customer!!");
        }

        return customer;
    }
}

