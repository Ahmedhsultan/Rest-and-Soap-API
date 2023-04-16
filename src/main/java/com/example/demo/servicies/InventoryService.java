package com.example.demo.servicies;

import com.example.demo.repository.entities.Film;
import com.example.demo.repository.entities.Inventory;
import com.example.demo.repository.entities.Store;
import com.example.demo.repository.repos.InventoryRepo;
import com.example.demo.repository.UnitOfWork;
import com.example.demo.webservices.rest.DTOs.requests.InventoryDTOReq;
import com.example.demo.webservices.rest.DTOs.resources.InventoryDTOResp;
import com.example.demo.webservices.rest.exception.exceptions.OperationFaildException;
import jakarta.persistence.PersistenceException;
import org.modelmapper.ModelMapper;
import java.time.Instant;

public class InventoryService extends BaseService<Inventory, InventoryDTOResp, InventoryRepo, InventoryDTOReq>{
    private ModelMapper modelMapper;
    public InventoryService(){
        this.modelMapper = new ModelMapper();
    }

    @Override
    public Inventory post(InventoryDTOReq inventoryDTOReq) throws PersistenceException {
        //Fetch film and store from db
        Film file = UnitOfWork.filmRepo.find("title", inventoryDTOReq.getFilmTitle()).get(0);
        Store store = UnitOfWork.storeRepo.find(inventoryDTOReq.getStoreId());

        //Create Inventory
        Inventory inventory = new Inventory();
        inventory.setFilm(file);
        inventory.setStore(store);
        inventory.setLastUpdate(Instant.now());

        //Save this inventory
        try {
            UnitOfWork.inventoryRepo.save(inventory);
        }catch (PersistenceException persistenceException){
            throw new OperationFaildException("Can't save this inventory!!");
        }

        return inventory;
    }
}