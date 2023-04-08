package com.example.demo.servicies;

import com.example.demo.repository.entities.Address;
import com.example.demo.repository.entities.City;
import com.example.demo.repository.entities.Country;
import com.example.demo.repository.repos.AddressRepo;
import com.example.demo.repository.repos.CityRepo;
import com.example.demo.webserviceies.rest.DTOs.AddressDTO;
import jakarta.persistence.PersistenceException;
import org.modelmapper.ModelMapper;

import java.time.Instant;

public class AddressService {

    private AddressRepo addressRepo;
    private CityRepo cityRepo;
    private ModelMapper modelMapper;
    public AddressService(){
        this.cityRepo = new CityRepo();
        this.addressRepo = new AddressRepo();
        this.modelMapper = new ModelMapper();
    }

    public Address createAddress(AddressDTO addressDTO) throws PersistenceException{
        //Fetch city from db
        City city = cityRepo.getByName("city", addressDTO.getCity());

        //create address
        Address address = modelMapper.map(addressDTO, Address.class);
        address.setLastUpdate(Instant.now());
        address.setCity(city);

        //Save this address
        try {
            addressRepo.save(address);
        }catch (PersistenceException persistenceException){
            throw new PersistenceException("Can't save this address!!");
        }

        return address;
    }
}
