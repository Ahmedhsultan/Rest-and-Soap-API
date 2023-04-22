package com.example.demo.servicies;

import com.example.demo.repository.UnitOfWork;
import com.example.demo.repository.entities.Film;
import com.example.demo.repository.entities.Inventory;
import com.example.demo.repository.entities.Store;
import com.example.demo.repository.repos.InventoryRepo;
import com.example.demo.webservices.rest.DTOs.requests.InventoryDTOReq;
import com.example.demo.webservices.rest.DTOs.resources.InventoryDTOResp;
import com.example.demo.webservices.rest.exception.exceptions.OperationFaildException;
import jakarta.persistence.PersistenceException;

public class InventoryService extends BaseService<Inventory, InventoryDTOResp, InventoryRepo, InventoryDTOReq> {
    @Override
    public Inventory post(InventoryDTOReq inventoryDTOReq) throws PersistenceException {
        //Fetch film and store from db
        Film file = UnitOfWork.getInstance().getFilmRepo().find(inventoryDTOReq.getFilmId());
        Store store = UnitOfWork.getInstance().getStoreRepo().find(inventoryDTOReq.getStoreId());

        //Create Inventory
        Inventory inventory = new Inventory();
        inventory.setFilm(file);
        inventory.setStore(store);

        //Save this inventory
        try {
            UnitOfWork.getInstance().getInventoryRepo().save(inventory);
        } catch (PersistenceException persistenceException) {
            throw new OperationFaildException("Can't save this inventory!!");
        }

        return inventory;
    }
}