package com.example.demo.servicies;

import com.example.demo.repository.entities.Address;
import com.example.demo.repository.entities.Staff;
import com.example.demo.repository.entities.Store;
import com.example.demo.repository.repos.AddressRepo;
import com.example.demo.repository.repos.StaffRepo;
import com.example.demo.repository.repos.StoreRepo;
import com.example.demo.webservices.rest.DTOs.requests.StaffDTOReq;
import com.example.demo.webservices.rest.DTOs.resources.StaffDTOResp;
import com.example.demo.webservices.rest.exception.exceptions.OperationFaildException;
import jakarta.persistence.PersistenceException;
import org.modelmapper.ModelMapper;

import java.time.Instant;

public class StaffService extends BaseService<Staff, StaffDTOResp, StaffRepo>{
    private StaffRepo staffRepo;
    private AddressRepo addressRepo;
    private StoreRepo storeRepo;
    private ModelMapper modelMapper;

    public StaffService(){
        super(new StaffRepo(), StaffDTOResp.class);
        //Create objects from repositories
        this.modelMapper = new ModelMapper();
        this.staffRepo = new StaffRepo();
        this.storeRepo = new StoreRepo();
        this.addressRepo = new AddressRepo();
    }

    public Staff create(StaffDTOReq staffDTOReq) throws PersistenceException {
        //Fetch Address and store from db
        Address address = addressRepo.getByName("address", staffDTOReq.getAddress());
        Store store = storeRepo.getById(staffDTOReq.getStoreId());

        //Create object of staff
        Staff staff = modelMapper.map(staffDTOReq, Staff.class);
        staff.setStore(store);
        staff.setAddress(address);
        staff.setLastUpdate(Instant.now());

        //Save this staff
        try {
            staffRepo.save(staff);
        }catch (PersistenceException persistenceException){
            throw new OperationFaildException("Can't save this staff!!");
        }

        return staff;
    }
}
