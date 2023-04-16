package com.example.demo.repository;

import com.example.demo.repository.repos.*;
import lombok.Data;

@Data
public class UnitOfWork {
    private UnitOfWork(){
        actorRepo = new ActorRepo();
        addressRepo = new AddressRepo();
        categoryRepo = new CategoryRepo();
        cityRepo = new CityRepo();
        countryRepo = new CountryRepo();
        customerRepo = new CustomerRepo();
        filmActorRepo = new FilmActorRepo();
        filmCategoryRepo = new FilmCategoryRepo();
        filmRepo = new FilmRepo();
        filmTextRepo = new FilmTextRepo();
        inventoryRepo = new InventoryRepo();
        languageRepo = new LanguageRepo();
        paymentRepo = new PaymentRepo();
        rentalRepo = new RentalRepo();
        staffRepo = new StaffRepo();
        storeRepo = new StoreRepo();
    }
    private static UnitOfWork unitOfWork;

    private ActorRepo actorRepo;
    private AddressRepo addressRepo;
    private CategoryRepo categoryRepo;
    private CityRepo cityRepo;
    private CountryRepo countryRepo;
    private CustomerRepo customerRepo;
    private FilmActorRepo filmActorRepo;
    private FilmCategoryRepo filmCategoryRepo;
    private FilmRepo filmRepo;
    private FilmTextRepo filmTextRepo;
    private InventoryRepo inventoryRepo;
    private LanguageRepo languageRepo;
    private PaymentRepo paymentRepo;
    private RentalRepo rentalRepo;
    private StaffRepo staffRepo;
    private StoreRepo storeRepo;

    public static UnitOfWork getInstance(){
        if (unitOfWork == null)
            return new UnitOfWork();
        return unitOfWork;
    }
}
