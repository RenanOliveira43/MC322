package utils;
import java.util.*;


public class VehicleInfoGenerator implements InfoGenerator{

    private String[] models = {"Toyota", "Honda", "Ford", "Chevrolet", "Nissan", "Hyundai", "Volkswagen", "Subaru", "Mazda", "Kia"};
    private String[] registrationNumbers = {"ABC123", "DEF456", "GHI789", "JKL012", "MNO345", "PQR678", "STU901", "VWX234", "YZA567", "BCD890"};

    private int vehicleId;
    private String registrationNumber;
    private String model;
    private int year;

    public VehicleInfoGenerator() {
        this.generateRandomInfo();
    }

    public void generateRandomInfo() {

        Random ran = new Random();
        int idx = ran.nextInt(10);

        this.model = models[idx];
        this.registrationNumber = registrationNumbers[idx];
        this.vehicleId = 200 + ran.nextInt(100);
        this.year = ran.nextInt(34) + 1990;

        return;


    }

    public int getVehicleId() {
        return this.vehicleId;
    }

    public String getRegistrationNumber() {
        return this.registrationNumber;
    }

    public String getModel() {
        return this.model;
    }

    public int getYear() {
        return this.year;
    }
}

