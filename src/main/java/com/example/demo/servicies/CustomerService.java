package com.example.demo.servicies;

import com.example.demo.repository.UnitOfWork;
import com.example.demo.repository.entities.Address;
import com.example.demo.repository.entities.Customer;
import com.example.demo.repository.entities.Store;
import com.example.demo.repository.repos.CustomerRepo;
import com.example.demo.webservices.rest.DTOs.requests.CustomerDTOReq;
import com.example.demo.webservices.rest.DTOs.resources.CustomerDTOResp;
import com.example.demo.webservices.rest.exception.exceptions.OperationFaildException;
import jakarta.persistence.PersistenceException;

public class CustomerService extends BaseService<Customer, CustomerDTOResp, CustomerRepo, CustomerDTOReq>{
    @Override
    public Customer post(CustomerDTOReq customerDTOReq) throws PersistenceException {
        //Fetch store and address from database
        Store store = UnitOfWork.getInstance().getStoreRepo().find(customerDTOReq.getStoreId());
        Address address = UnitOfWork.getInstance().getAddressRepo().find(customerDTOReq.getAddressId());

        //Create new customer
        Customer customer = new Customer();
        customer.setFirstName(customerDTOReq.getFirstName());
        customer.setLastName(customerDTOReq.getLastName());
        customer.setEmail(customerDTOReq.getEmail());
        customer.setActive(true);
        customer.setStore(store);
        customer.setAddress(address);

        //Save this customer
        try {
            UnitOfWork.getInstance().getCustomerRepo().save(customer);
        }catch (PersistenceException persistenceException){
            throw new OperationFaildException("Can't save this customer!!");
        }

        return customer;
    }
}

