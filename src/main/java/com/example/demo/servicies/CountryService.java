package com.example.demo.servicies;

import com.example.demo.repository.entities.Country;
import com.example.demo.repository.repos.CountryRepo;
import com.example.demo.repository.UnitOfWork;
import com.example.demo.webservices.rest.DTOs.requests.CountryDTOReq;
import com.example.demo.webservices.rest.DTOs.resources.CountryDTOResp;
import com.example.demo.webservices.rest.exception.exceptions.OperationFaildException;
import jakarta.persistence.PersistenceException;
import org.modelmapper.ModelMapper;
import java.time.Instant;

public class CountryService extends BaseService<Country, CountryDTOResp, CountryRepo, CountryDTOReq>{
}
