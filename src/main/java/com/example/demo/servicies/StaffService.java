package com.example.demo.servicies;

import com.example.demo.repository.entities.Address;
import com.example.demo.repository.entities.Staff;
import com.example.demo.repository.entities.Store;
import com.example.demo.repository.repos.AddressRepo;
import com.example.demo.repository.repos.StaffRepo;
import com.example.demo.repository.repos.StoreRepo;
import com.example.demo.webserviceies.rest.DTOs.StaffDTO;
import jakarta.persistence.PersistenceException;
import org.modelmapper.ModelMapper;

import java.time.Instant;

public class StaffService extends BaseService<Staff, StaffRepo>{
    private StaffRepo staffRepo;
    private AddressRepo addressRepo;
    private StoreRepo storeRepo;
    private ModelMapper modelMapper;

    public StaffService(){
        super(new StaffRepo());
        //Create objects from repositories
        this.modelMapper = new ModelMapper();
        this.staffRepo = new StaffRepo();
        this.storeRepo = new StoreRepo();
        this.addressRepo = new AddressRepo();
    }

    public Staff create(StaffDTO staffDTO) throws PersistenceException {
        //Fetch Address and store from db
        Address address = addressRepo.getByName("address", staffDTO.getAddress());
        Store store = storeRepo.getById(staffDTO.getStoreId());

        //Create object of staff
        Staff staff = modelMapper.map(staffDTO, Staff.class);
        staff.setStore(store);
        staff.setAddress(address);
        staff.setLastUpdate(Instant.now());

        //Save this staff
        try {
            staffRepo.save(staff);
        }catch (PersistenceException persistenceException){
            throw new PersistenceException("Can't save this staff!!");
        }

        return staff;
    }
}
