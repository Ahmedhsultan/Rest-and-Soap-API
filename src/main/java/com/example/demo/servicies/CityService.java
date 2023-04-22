package com.example.demo.servicies;

import com.example.demo.repository.UnitOfWork;
import com.example.demo.repository.entities.City;
import com.example.demo.repository.entities.Country;
import com.example.demo.repository.repos.CityRepo;
import com.example.demo.webservices.rest.DTOs.requests.CityDTOReq;
import com.example.demo.webservices.rest.DTOs.resources.CityDTOResp;
import com.example.demo.webservices.rest.exception.exceptions.OperationFaildException;
import jakarta.persistence.PersistenceException;

public class CityService extends BaseService<City, CityDTOResp, CityRepo, CityDTOReq>{
    @Override
    public City post(CityDTOReq cityDTOReq) throws PersistenceException {

        Country country = UnitOfWork.getInstance().getCountryRepo().find(cityDTOReq.getCountryId());

        City city = new City();
        city.setCountry(country);
        city.setCity(cityDTOReq.getCity());

        //Save this city
        try {
            UnitOfWork.getInstance().getCityRepo().save(city);
        }catch (PersistenceException persistenceException){
            throw new OperationFaildException("Can't save this city!!");
        }

        return city;
    }
}
