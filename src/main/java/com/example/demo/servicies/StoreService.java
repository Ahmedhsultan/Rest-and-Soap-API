package com.example.demo.servicies;

import com.example.demo.repository.entities.Address;
import com.example.demo.repository.entities.Staff;
import com.example.demo.repository.entities.Store;
import com.example.demo.repository.repos.AddressRepo;
import com.example.demo.repository.repos.StaffRepo;
import com.example.demo.repository.repos.StoreRepo;
import com.example.demo.webservices.rest.DTOs.requests.StoreDTOReq;
import com.example.demo.webservices.rest.DTOs.resources.StoreDTOResp;
import com.example.demo.webservices.rest.exception.exceptions.OperationFaildException;
import jakarta.persistence.PersistenceException;
import org.modelmapper.ModelMapper;
import java.time.Instant;

public class StoreService extends BaseService<Store, StoreDTOResp, StoreRepo>{
    private StaffRepo staffRepo;
    private StoreRepo storeRepo;
    private AddressRepo addressRepo;
    private ModelMapper modelMapper;

    public StoreService(){
        super(new StoreRepo());
        //Create objects from repositories
        this.modelMapper = new ModelMapper();
        this.staffRepo = new StaffRepo();
        this.addressRepo = new AddressRepo();
        this.storeRepo = new StoreRepo();
    }

    public Store create(StoreDTOReq storeDTOReq) throws PersistenceException {
        //Fetch Address and staffManger from db
        Staff staffManger = staffRepo.find("firstName", storeDTOReq.getManagerStaffFirstName()).get(0);
        Address address = addressRepo.find("address", storeDTOReq.getAddress()).get(0);

        //Create object of store
        Store store = new Store();
        store.setAddress(address);
        store.setManagerStaff(staffManger);
        store.setLastUpdate(Instant.now());

        //Save this store
        try {
            storeRepo.save(store);
        }catch (PersistenceException persistenceException){
            throw new OperationFaildException("Can't save this store!!");
        }

        return store;
    }
}
