package com.example.demo.servicies;

import com.example.demo.repository.entities.City;
import com.example.demo.repository.entities.Country;
import com.example.demo.repository.repos.CityRepo;
import com.example.demo.repository.repos.CountryRepo;
import com.example.demo.webservices.rest.DTOs.requests.CityDTOReq;
import com.example.demo.webservices.rest.DTOs.resources.CityDTOResp;
import com.example.demo.webservices.rest.exception.exceptions.OperationFaildException;
import jakarta.persistence.PersistenceException;
import org.modelmapper.ModelMapper;
import java.time.Instant;

public class CityService extends BaseService<City, CityDTOResp, CityRepo>{
    private CityRepo cityRepo;
    private CountryRepo countryRepo;
    private ModelMapper modelMapper;
    public CityService(){
        super(new CityRepo());
        this.countryRepo = new CountryRepo();
        this.cityRepo = new CityRepo();
        this.modelMapper = new ModelMapper();
    }

    public City createCity(CityDTOReq cityDTOReq) throws PersistenceException {

        Country country = countryRepo.find("country", cityDTOReq.getCountry()).get(0);

        City city = new City();
        city.setCountry(country);
        city.setCity(cityDTOReq.getCity());
        city.setLastUpdate(Instant.now());

        //Save this city
        try {
            cityRepo.save(city);
        }catch (PersistenceException persistenceException){
            throw new OperationFaildException("Can't save this city!!");
        }

        return city;
    }
}
