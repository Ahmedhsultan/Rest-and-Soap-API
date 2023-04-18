package com.example.demo.servicies;

import com.example.demo.repository.UnitOfWork;
import com.example.demo.repository.entities.*;
import com.example.demo.repository.repos.*;
import com.example.demo.webservices.rest.DTOs.requests.RentalDTOReq;
import com.example.demo.webservices.rest.DTOs.resources.RentalDTOResp;
import com.example.demo.webservices.rest.exception.exceptions.OperationFaildException;
import jakarta.persistence.PersistenceException;
import org.modelmapper.ModelMapper;

import java.time.Instant;

public class RentalService extends BaseService<Rental, RentalDTOResp, RentalRepo, RentalDTOReq>{
    private ModelMapper modelMapper;
    public RentalService(){
        this.modelMapper = new ModelMapper();
    }

    @Override
    public Rental post(RentalDTOReq rentalDTOReq) throws PersistenceException {
        //Fetch film and store from db
        Staff staff = UnitOfWork.getInstance().getStaffRepo().find(rentalDTOReq.getStaffId());
        Inventory inventory = UnitOfWork.getInstance().getInventoryRepo().find(rentalDTOReq.getInventoryId());
        Customer customer = UnitOfWork.getInstance().getCustomerRepo().find(rentalDTOReq.getCustomerId());

        //Create rental
        Rental rental = new Rental();
        rental.setInventory(inventory);
        rental.setRentalDate(Instant.now());
        rental.setCustomer(customer);
        rental.setStaff(staff);
        rental.setReturnDate(Instant.parse(rentalDTOReq.getReturnDateInstance()));

        //Save this rental
        try {
            UnitOfWork.getInstance().getRentalRepo().save(rental);
        }catch (PersistenceException persistenceException){
            throw new OperationFaildException("Can't save this rental!!");
        }

        return rental;
    }
}