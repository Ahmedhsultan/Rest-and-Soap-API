package com.example.demo.servicies;

import com.example.demo.repository.entities.*;
import com.example.demo.repository.repos.*;
import com.example.demo.webserviceies.rest.DTOs.PaymentDTO;
import com.example.demo.webserviceies.rest.DTOs.RentalDTO;
import jakarta.persistence.PersistenceException;
import org.modelmapper.ModelMapper;

import java.time.Instant;

public class RentalService {
    private CustomerRepo customerRepo;
    private StaffRepo staffRepo;
    private RentalRepo rentalRepo;
    private InventoryRepo inventoryRepo;
    private ModelMapper modelMapper;
    public RentalService(){
        this.customerRepo = new CustomerRepo();
        this.staffRepo = new StaffRepo();
        this.rentalRepo = new RentalRepo();
        this.inventoryRepo = new InventoryRepo();
        this.modelMapper = new ModelMapper();
    }

    public Rental create(RentalDTO rentalDTO) throws PersistenceException {
        //Fetch film and store from db
        Staff staff = staffRepo.getByName("firstName", rentalDTO.getStaffFirstName());
        Inventory inventory = inventoryRepo.getById(rentalDTO.getInventoryId());
        Customer customer = customerRepo.getByName("firstName", rentalDTO.getCustomerFirstName());

        //Create rental
        Rental rental = new Rental();
        rental.setInventory(inventory);
        rental.setRentalDate(Instant.now());
        rental.setCustomer(customer);
        rental.setLastUpdate(Instant.now());
        rental.setStaff(staff);
        rental.setReturnDate(Instant.parse(rentalDTO.getReturnDateInstance()));

        //Save this rental
        try {
            rentalRepo.save(rental);
        }catch (PersistenceException persistenceException){
            throw new PersistenceException("Can't save this rental!!");
        }

        return rental;
    }
}