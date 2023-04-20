package com.example.demo.servicies;

import com.example.demo.repository.entities.Category;
import com.example.demo.repository.repos.CategoryRepo;
import com.example.demo.repository.UnitOfWork;
import com.example.demo.webservices.rest.DTOs.requests.CategoryDTOReq;
import com.example.demo.webservices.rest.DTOs.resources.CategoryDTOResp;
import com.example.demo.webservices.rest.exception.exceptions.OperationFaildException;
import jakarta.persistence.PersistenceException;
import org.modelmapper.ModelMapper;
import java.time.Instant;

public class CategoryService extends BaseService<Category, CategoryDTOResp, CategoryRepo, CategoryDTOReq>{
}
