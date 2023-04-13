package com.example.demo.servicies;

import com.example.demo.repository.entities.Address;
import com.example.demo.repository.entities.Customer;
import com.example.demo.repository.entities.Store;
import com.example.demo.repository.repos.AddressRepo;
import com.example.demo.repository.repos.CustomerRepo;
import com.example.demo.repository.repos.StoreRepo;
import com.example.demo.webservices.rest.DTOs.requests.CustomerDTOReq;
import com.example.demo.webservices.rest.DTOs.resources.CustomerDTOResp;
import com.example.demo.webservices.rest.exception.exceptions.OperationFaildException;
import jakarta.persistence.PersistenceException;
import org.modelmapper.ModelMapper;
import java.time.Instant;

public class CustomerService extends BaseService<Customer, CustomerDTOResp, CustomerRepo>{
    private CustomerRepo customerRepo;
    private StoreRepo storeRepo;
    private AddressRepo addressRepo;
    private ModelMapper modelMapper;
    public CustomerService(){
        super(new CustomerRepo(), CustomerDTOResp.class);
        this.storeRepo = new StoreRepo();
        this.addressRepo = new AddressRepo();
        this.customerRepo = new CustomerRepo();
        this.modelMapper = new ModelMapper();
    }

    public Customer create(CustomerDTOReq customerDTOReq) throws PersistenceException {
        //Fetch store and address from database
        Store store = storeRepo.getById(customerDTOReq.getStore_ID());
        Address address = addressRepo.getByName("address", customerDTOReq.getAddress());

        //Create new customer
        Customer customer = modelMapper.map(customerDTOReq, Customer.class);
        customer.setActive(true);
        customer.setStore(store);
        customer.setAddress(address);
        customer.setLastUpdate(Instant.now());

        //Save this customer
        try {
            customerRepo.save(customer);
        }catch (PersistenceException persistenceException){
            throw new OperationFaildException("Can't save this customer!!");
        }

        return customer;
    }
}

