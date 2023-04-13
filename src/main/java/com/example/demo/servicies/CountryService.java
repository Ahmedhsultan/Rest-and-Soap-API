package com.example.demo.servicies;

import com.example.demo.repository.entities.Country;
import com.example.demo.repository.repos.CountryRepo;
import com.example.demo.webserviceies.rest.DTOs.requests.CountryDTOReq;
import com.example.demo.webserviceies.rest.DTOs.resources.CountryDTOResp;
import jakarta.persistence.PersistenceException;
import org.modelmapper.ModelMapper;
import java.time.Instant;

public class CountryService extends BaseService<Country, CountryDTOResp, CountryRepo>{
    private CountryRepo countryRepo;
    private ModelMapper modelMapper;
    public CountryService(){
        super(new CountryRepo(), CountryDTOResp.class);
        this.countryRepo = new CountryRepo();
        this.modelMapper = new ModelMapper();
    }

    public Country createCountry(CountryDTOReq countryDTOReq) throws PersistenceException {

        Country country = modelMapper.map(countryDTOReq, Country.class);
        country.setLastUpdate(Instant.now());

        //Save this actor
        try {
            countryRepo.save(country);
        }catch (PersistenceException persistenceException){
            throw new PersistenceException("Can't save this country!!");
        }

        return country;
    }
}
