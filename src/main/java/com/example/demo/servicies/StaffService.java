package com.example.demo.servicies;

import com.example.demo.repository.entities.Address;
import com.example.demo.repository.entities.Staff;
import com.example.demo.repository.entities.Store;
import com.example.demo.repository.repos.StaffRepo;
import com.example.demo.repository.UnitOfWork;
import com.example.demo.webservices.rest.DTOs.requests.StaffDTOReq;
import com.example.demo.webservices.rest.DTOs.resources.StaffDTOResp;
import com.example.demo.webservices.rest.exception.exceptions.OperationFaildException;
import jakarta.persistence.PersistenceException;
import org.modelmapper.ModelMapper;

import java.time.Instant;

public class StaffService extends BaseService<Staff, StaffDTOResp, StaffRepo, StaffDTOReq>{
    private ModelMapper modelMapper;

    public StaffService(){
        //Create objects from repositories
        this.modelMapper = new ModelMapper();
    }

    @Override
    public Staff post(StaffDTOReq staffDTOReq) throws PersistenceException {
        //Fetch Address and store from db
        Address address = UnitOfWork.getInstance().getAddressRepo().find("address", staffDTOReq.getAddress()).get(0);
        Store store = UnitOfWork.getInstance().getStoreRepo().find(staffDTOReq.getStoreId());

        //Create object of staff
        Staff staff = modelMapper.map(staffDTOReq, Staff.class);
        staff.setStore(store);
        staff.setAddress(address);
        staff.setLastUpdate(Instant.now());

        //Save this staff
        try {
            UnitOfWork.getInstance().getStaffRepo().save(staff);
        }catch (PersistenceException persistenceException){
            throw new OperationFaildException("Can't save this staff!!");
        }

        return staff;
    }
}
