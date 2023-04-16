package com.example.demo.servicies;

import com.example.demo.repository.entities.Address;
import com.example.demo.repository.entities.City;
import com.example.demo.repository.repos.AddressRepo;
import com.example.demo.repository.repos.CityRepo;
import com.example.demo.repository.repos.UnitOfWork;
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
        City city = UnitOfWork.cityRepo.find("city", addressDTOReq.getCity()).get(0);

        //create address
        Address address = modelMapper.map(addressDTOReq, Address.class);
        address.setLastUpdate(Instant.now());
        address.setCity(city);

        //Save this address
        try {
            UnitOfWork.addressRepo.save(address);
        }catch (PersistenceException persistenceException){
            throw new OperationFaildException("Can't save this address!!");
        }

        return address;
    }
}
