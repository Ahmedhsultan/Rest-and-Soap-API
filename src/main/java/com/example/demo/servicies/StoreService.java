package com.example.demo.servicies;

import com.example.demo.repository.entities.Store;
import com.example.demo.repository.repos.StaffRepo;
import com.example.demo.repository.repos.StoreRepo;
import com.example.demo.webserviceies.rest.DTOs.resources.StoreDTOResp;
import org.modelmapper.ModelMapper;

public class StoreService extends BaseService<Store, StoreDTOResp, StoreRepo>{
    private StaffRepo staffRepo;
    private StoreRepo storeRepo;
    private ModelMapper modelMapper;

    public StoreService(){
        super(new StoreRepo(), StoreDTOResp.class);
        //Create objects from repositories
        this.modelMapper = new ModelMapper();
        this.staffRepo = new StaffRepo();
        this.storeRepo = new StoreRepo();
    }
}
