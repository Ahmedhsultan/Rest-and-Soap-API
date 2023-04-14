package com.example.demo.servicies;

import com.example.demo.repository.entities.*;
import com.example.demo.repository.repos.*;
import com.example.demo.webservices.rest.DTOs.requests.RentalDTOReq;
import com.example.demo.webservices.rest.DTOs.resources.RentalDTOResp;
import com.example.demo.webservices.rest.exception.exceptions.OperationFaildException;
import jakarta.persistence.PersistenceException;
import org.modelmapper.ModelMapper;

import java.time.Instant;

public class RentalService extends BaseService<Rental, RentalDTOResp, RentalRepo>{
    private CustomerRepo customerRepo;
    private StaffRepo staffRepo;
    private RentalRepo rentalRepo;
    private InventoryRepo inventoryRepo;
    private ModelMapper modelMapper;
    public RentalService(){
        super(new RentalRepo());
        this.customerRepo = new CustomerRepo();
        this.staffRepo = new StaffRepo();
        this.rentalRepo = new RentalRepo();
        this.inventoryRepo = new InventoryRepo();
        this.modelMapper = new ModelMapper();
    }

    public Rental create(RentalDTOReq rentalDTOReq) throws PersistenceException {
        //Fetch film and store from db
        Staff staff = staffRepo.getByName("firstName", rentalDTOReq.getStaffFirstName()).get(0);
        Inventory inventory = inventoryRepo.getById(rentalDTOReq.getInventoryId());
        Customer customer = customerRepo.getByName("firstName", rentalDTOReq.getCustomerFirstName()).get(0);

        //Create rental
        Rental rental = new Rental();
        rental.setInventory(inventory);
        rental.setRentalDate(Instant.now());
        rental.setCustomer(customer);
        rental.setLastUpdate(Instant.now());
        rental.setStaff(staff);
        rental.setReturnDate(Instant.parse(rentalDTOReq.getReturnDateInstance()));

        //Save this rental
        try {
            rentalRepo.save(rental);
        }catch (PersistenceException persistenceException){
            throw new OperationFaildException("Can't save this rental!!");
        }

        return rental;
    }
}