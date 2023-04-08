package com.example.demo.servicies;

import com.example.demo.repository.entities.City;
import com.example.demo.repository.entities.Country;
import com.example.demo.repository.repos.CityRepo;
import com.example.demo.repository.repos.CountryRepo;
import com.example.demo.webserviceies.rest.DTOs.CityDTO;
import jakarta.persistence.PersistenceException;
import org.modelmapper.ModelMapper;
import java.time.Instant;

public class CityService {
    private CityRepo cityRepo;
    private CountryRepo countryRepo;
    private ModelMapper modelMapper;
    public CityService(){
        this.countryRepo = new CountryRepo();
        this.cityRepo = new CityRepo();
        this.modelMapper = new ModelMapper();
    }

    public City createCity(CityDTO cityDTO) throws PersistenceException {

        Country country = countryRepo.getByName("country", cityDTO.getCountry());

        City city = new City();
        city.setCountry(country);
        city.setCity(cityDTO.getCity());
        city.setLastUpdate(Instant.now());

        //Save this city
        try {
            cityRepo.save(city);
        }catch (PersistenceException persistenceException){
            throw new PersistenceException("Can't save this city!!");
        }

        return city;
    }
}