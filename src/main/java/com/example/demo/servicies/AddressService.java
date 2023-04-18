package com.example.demo.servicies;

import com.example.demo.repository.entities.Address;
import com.example.demo.repository.entities.City;
import com.example.demo.repository.repos.AddressRepo;
import com.example.demo.repository.UnitOfWork;
import com.example.demo.webservices.rest.DTOs.requests.AddressDTOReq;
import com.example.demo.webservices.rest.DTOs.resources.AddressDTOResp;
import com.example.demo.webservices.rest.exception.exceptions.OperationFaildException;
import jakarta.persistence.PersistenceException;
import org.modelmapper.ModelMapper;

import java.time.Instant;

public class AddressService extends BaseService<Address, AddressDTOResp, AddressRepo, AddressDTOReq>{
    private ModelMapper modelMapper;
    public AddressService(){
        this.modelMapper = new ModelMapper();
    }

    @Override
    public Address post(AddressDTOReq addressDTOReq) throws PersistenceException{
        //Fetch city from db
        City city = UnitOfWork.getInstance().getCityRepo().find(addressDTOReq.getCityId());

        //create address
        Address address = modelMapper.map(addressDTOReq, Address.class);
        address.setCity(city);
        address.setId(null);

        //Save this address
        try {
            UnitOfWork.getInstance().getAddressRepo().save(address);
        }catch (PersistenceException persistenceException){
            throw new OperationFaildException("Can't save this address!!");
        }

        return address;
    }
}
