package databaseManager;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


import cabbieManager.Passenger;

public class Database{
    private List<Passenger> passengers = new ArrayList<>();
    
    private final File file = new File("app/data/database.xml");


    public Database(){
    }

    public Database(boolean load){
        if(load){
            this.load();
        }
    }
    
    public List<Passenger> getPassengers(){
        return this.passengers;
    }

    public void insert(Object object){
        if(object instanceof Passenger){
            this.passengers.add((Passenger) object);
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
        if(object instanceof Passenger){
            this.update((Passenger)object, this.passengers);
        }else{
            return;
        }
        this.save();       
    }

    private void save(){
    }

    private void load(){
    }
}