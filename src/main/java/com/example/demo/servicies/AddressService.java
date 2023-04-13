package com.example.demo.servicies;

import com.example.demo.repository.entities.Address;
import com.example.demo.repository.entities.City;
import com.example.demo.repository.repos.AddressRepo;
import com.example.demo.repository.repos.CityRepo;
import com.example.demo.webserviceies.rest.DTOs.requests.AddressDTOReq;
import com.example.demo.webserviceies.rest.DTOs.resources.AddressDTOResp;
import com.example.demo.webserviceies.rest.exception.exceptions.OperationFaildException;
import jakarta.persistence.PersistenceException;
import org.modelmapper.ModelMapper;

import java.time.Instant;

public class AddressService extends BaseService<Address, AddressDTOResp, AddressRepo>{

    private AddressRepo addressRepo;
    private CityRepo cityRepo;
    private ModelMapper modelMapper;
    public AddressService(){
        super(new AddressRepo(), AddressDTOResp.class);
        this.cityRepo = new CityRepo();
        this.addressRepo = new AddressRepo();
        this.modelMapper = new ModelMapper();
    }

    public Address createAddress(AddressDTOReq addressDTOReq) throws PersistenceException{
        //Fetch city from db
        City city = cityRepo.getByName("city", addressDTOReq.getCity());

        //create address
        Address address = modelMapper.map(addressDTOReq, Address.class);
        address.setLastUpdate(Instant.now());
        address.setCity(city);

        //Save this address
        try {
            addressRepo.save(address);
        }catch (PersistenceException persistenceException){
            throw new OperationFaildException("Can't save this address!!");
        }

        return address;
    }
}
