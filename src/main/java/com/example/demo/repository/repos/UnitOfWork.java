package com.example.demo.repository.repos;

import lombok.Data;

@Data
public class UnitOfWork {
    public static ActorRepo actorRepo;
    public static AddressRepo addressRepo;
    public static CategoryRepo categoryRepo;
    public static CityRepo cityRepo;
    public static CountryRepo countryRepo;
    public static CustomerRepo customerRepo;
    public static FilmActorRepo filmActorRepo;
    public static FilmCategoryRepo filmCategoryRepo;
    public static FilmRepo filmRepo;
    public static FilmTextRepo filmTextRepo;
    public static InventoryRepo inventoryRepo;
    public static LanguageRepo languageRepo;
    public static PaymentRepo paymentRepo;
    public static RentalRepo rentalRepo;
    public static StaffRepo staffRepo;
    public static StoreRepo storeRepo;

    public static void create(){
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
}
