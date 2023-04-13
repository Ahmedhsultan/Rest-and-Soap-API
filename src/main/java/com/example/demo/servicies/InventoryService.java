package com.example.demo.servicies;

import com.example.demo.repository.entities.Film;
import com.example.demo.repository.entities.Inventory;
import com.example.demo.repository.entities.Store;
import com.example.demo.repository.repos.FilmRepo;
import com.example.demo.repository.repos.InventoryRepo;
import com.example.demo.repository.repos.StoreRepo;
import com.example.demo.webserviceies.rest.DTOs.requests.InventoryDTOReq;
import com.example.demo.webserviceies.rest.DTOs.resources.InventoryDTOResp;
import jakarta.persistence.PersistenceException;
import org.modelmapper.ModelMapper;
import java.time.Instant;

public class InventoryService extends BaseService<Inventory, InventoryDTOResp, InventoryRepo>{
    private StoreRepo storeRepo;
    private FilmRepo filmRepo;
    private InventoryRepo inventoryRepo;
    private ModelMapper modelMapper;
    public InventoryService(){
        super(new InventoryRepo(), InventoryDTOResp.class);
        this.filmRepo = new FilmRepo();
        this.storeRepo = new StoreRepo();
        this.inventoryRepo = new InventoryRepo();
        this.modelMapper = new ModelMapper();
    }

    public Inventory create(InventoryDTOReq inventoryDTOReq) throws PersistenceException {
        //Fetch film and store from db
        Film file = filmRepo.getByName("title", inventoryDTOReq.getFilmTitle());
        Store store = storeRepo.getById(inventoryDTOReq.getStoreId());

        //Create Inventory
        Inventory inventory = new Inventory();
        inventory.setFilm(file);
        inventory.setStore(store);
        inventory.setLastUpdate(Instant.now());

        //Save this inventory
        try {
            inventoryRepo.save(inventory);
        }catch (PersistenceException persistenceException){
            throw new PersistenceException("Can't save this inventory!!");
        }

        return inventory;
    }
}