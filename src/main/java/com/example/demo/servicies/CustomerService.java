package com.example.demo.servicies;

import com.example.demo.repository.entities.Address;
import com.example.demo.repository.entities.Customer;
import com.example.demo.repository.entities.Store;
import com.example.demo.repository.repos.CustomerRepo;
import com.example.demo.repository.UnitOfWork;
import com.example.demo.webservices.rest.DTOs.requests.CustomerDTOReq;
import com.example.demo.webservices.rest.DTOs.resources.CustomerDTOResp;
import com.example.demo.webservices.rest.exception.exceptions.OperationFaildException;
import jakarta.persistence.PersistenceException;
import org.modelmapper.ModelMapper;
import java.time.Instant;

public class CustomerService extends BaseService<Customer, CustomerDTOResp, CustomerRepo, CustomerDTOReq>{
    private ModelMapper modelMapper;
    public CustomerService(){
        this.modelMapper = new ModelMapper();
    }

    @Override
    public Customer post(CustomerDTOReq customerDTOReq) throws PersistenceException {
        //Fetch store and address from database
        Store store = UnitOfWork.storeRepo.find(customerDTOReq.getStore_ID());
        Address address = UnitOfWork.addressRepo.find("address", customerDTOReq.getAddress()).get(0);

        //Create new customer
        Customer customer = modelMapper.map(customerDTOReq, Customer.class);
        customer.setActive(true);
        customer.setStore(store);
        customer.setAddress(address);
        customer.setLastUpdate(Instant.now());

        //Save this customer
        try {
            UnitOfWork.customerRepo.save(customer);
        }catch (PersistenceException persistenceException){
            throw new OperationFaildException("Can't save this customer!!");
        }

        return customer;
    }
}

