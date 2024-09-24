package databaseManager;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import cabbieManager.Cabbie;
import cabbieManager.Passenger;
import cabbieManager.Ride;
import cabbieManager.RidePayment;
import cabbieManager.Vehicle;

public class Database{
    private List<Passenger> passengers = new ArrayList<>();
    private List<Cabbie> cabbies = new ArrayList<>();
    private List<Vehicle> vehicles = new ArrayList<>();
    private List<Ride> rides = new ArrayList<>();
    private List<RidePayment> paymentMethods = new ArrayList<>();

    private final File file = new File("app/data/database.xml");


    public Database(){
    }

    public Database(boolean load){
        if(load){
            this.load();
        }
    }
    
    public List<Passenger> getPassengers() {
        return this.passengers;
    }

    public List<Cabbie> getCabbies() {
        return this.cabbies;
    }

    public List<Vehicle> getVehicles() {
        return this.vehicles;
    }

    public List<Ride> getRides() {
        return this.rides;
    }

    public List<RidePayment> getPaymentMethods() {
        return paymentMethods;
    }
    
    public void insert(Object object){
        if (object instanceof Passenger) {
            this.passengers.add((Passenger) object);
        }
        else if (object instanceof Cabbie) {
            this.cabbies.add((Cabbie) object);
        }
        else if (object instanceof Vehicle) {
            this.vehicles.add((Vehicle) object);
        }
        else if (object instanceof Ride) {
            this.rides.add((Ride) object);
        }
        else if (object instanceof RidePayment) {
            this.paymentMethods.add((RidePayment) object);
        }   
        
        this.save();
    }

    private <T> void update(T newItem, List<T> data){
        for(int i=0;i<data.size();i++){
            Object item = data.get(i);

            if(item.equals(newItem)){
                data.set(i, newItem);
            }
        }
    }

    public void update(Object object){
        if (object instanceof Passenger){
            this.update((Passenger)object, this.passengers);
        }
        else if (object instanceof Cabbie) {
            this.update((Cabbie)object, this.cabbies);
        }
        else if (object instanceof Vehicle) {
            this.update((Vehicle)object, this.vehicles);
        }
        else if (object instanceof Ride) {
            this.update((Ride)object, this.rides);
        }
        else if (object instanceof RidePayment) {
            this.update((RidePayment)object, this.paymentMethods);
        }
        else{
            return;
        }
        this.save();       
    }

    private void save() {
    
    }

    private void load() {

    }
}