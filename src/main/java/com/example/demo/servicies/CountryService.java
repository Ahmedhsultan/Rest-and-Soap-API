package com.example.demo.servicies;

import com.example.demo.repository.entities.Country;
import com.example.demo.repository.repos.CountryRepo;
import com.example.demo.repository.repos.UnitOfWork;
import com.example.demo.webservices.rest.DTOs.requests.CountryDTOReq;
import com.example.demo.webservices.rest.DTOs.resources.CountryDTOResp;
import com.example.demo.webservices.rest.exception.exceptions.OperationFaildException;
import jakarta.persistence.PersistenceException;
import org.modelmapper.ModelMapper;
import java.time.Instant;

public class CountryService extends BaseService<Country, CountryDTOResp, CountryRepo, CountryDTOReq>{
    private ModelMapper modelMapper;
    public CountryService(){
        this.modelMapper = new ModelMapper();
    }

    @Override
    public Country post(CountryDTOReq countryDTOReq) throws PersistenceException {

        Country country = modelMapper.map(countryDTOReq, Country.class);
        country.setLastUpdate(Instant.now());

        //Save this actor
        try {
            UnitOfWork.countryRepo.save(country);
        }catch (PersistenceException persistenceException){
            throw new OperationFaildException("Can't save this country!!");
        }

        return country;
    }
}
