package com.example.demo.servicies;

import com.example.demo.repository.entities.Address;
import com.example.demo.repository.entities.Staff;
import com.example.demo.repository.entities.Store;
import com.example.demo.repository.repos.StoreRepo;
import com.example.demo.repository.UnitOfWork;
import com.example.demo.webservices.rest.DTOs.requests.StoreDTOReq;
import com.example.demo.webservices.rest.DTOs.resources.StoreDTOResp;
import com.example.demo.webservices.rest.exception.exceptions.OperationFaildException;
import jakarta.persistence.PersistenceException;
import org.modelmapper.ModelMapper;
import java.time.Instant;

public class StoreService extends BaseService<Store, StoreDTOResp, StoreRepo, StoreDTOReq>{
    private ModelMapper modelMapper;

    public StoreService(){
        //Create objects from repositories
        this.modelMapper = new ModelMapper();
    }

    @Override
    public Store post(StoreDTOReq storeDTOReq) throws PersistenceException {
        //Fetch Address and staffManger from db
        Staff staffManger = UnitOfWork.getInstance().getStaffRepo().find("firstName", storeDTOReq.getManagerStaffFirstName()).get(0);
        Address address = UnitOfWork.getInstance().getAddressRepo().find("address", storeDTOReq.getAddress()).get(0);

        //Create object of store
        Store store = new Store();
        store.setAddress(address);
        store.setManagerStaff(staffManger);
        store.setLastUpdate(Instant.now());

        //Save this store
        try {
            UnitOfWork.getInstance().getStoreRepo().save(store);
        }catch (PersistenceException persistenceException){
            throw new OperationFaildException("Can't save this store!!");
        }

        return store;
    }
}
