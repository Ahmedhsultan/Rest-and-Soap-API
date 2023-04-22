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
import java.util.List;
import java.util.stream.Collectors;

public class RentalService extends BaseService<Rental, RentalDTOResp, RentalRepo, RentalDTOReq>{
    @Override
    public Rental post(RentalDTOReq rentalDTOReq) throws PersistenceException {

        //Fetch film and store from db
        Staff staff = UnitOfWork.getInstance().getStaffRepo().find(rentalDTOReq.getStaffId());
        Inventory inventory = UnitOfWork.getInstance().getInventoryRepo().find(rentalDTOReq.getInventoryId());
        Customer customer = UnitOfWork.getInstance().getCustomerRepo().find(rentalDTOReq.getCustomerId());

        //Check if inventory rented or customer inactive
        if(!customer.getActive())
            throw new OperationFaildException("Customer isn't active!!");
        if(isRented(inventory))
            throw new OperationFaildException("Inventory is rented!!");

        //Create rental
        Rental rental = new Rental();
        rental.setInventory(inventory);
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

    public boolean isRented(Inventory inventory){
        try {
            //Get all rentals history for this inventory
            List<Rental> rentalsHistory = UnitOfWork.getInstance().getRentalRepo().find("inventory", inventory);
            //Check if one of them still rented and the rented date after now
            List<Rental> rentals = rentalsHistory.stream().filter(x -> x.getRentalDate().isAfter(Instant.now())).toList();
            if (rentals.stream().count()>0)
                return true;
        }catch (IndexOutOfBoundsException exception){
            return false;
        }
        return false;
    }
}