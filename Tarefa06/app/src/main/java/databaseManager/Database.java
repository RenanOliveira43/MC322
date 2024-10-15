package databaseManager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import cabbieManager.BusinessPassenger;
import cabbieManager.Cabbie;
import cabbieManager.Passenger;
import cabbieManager.Ride;
import cabbieManager.RidePayment;
import cabbieManager.VIPPassenger;
import cabbieManager.Vehicle;
import exceptions.*;

/**
 * Represents the database for the cabbie management system.
 * This class manages lists of passengers, cabbies, vehicles, rides, and payment methods,
 * and provides methods for inserting, updating, and saving data to an XML file.
 */
@XmlRootElement(name="database")
public class Database{
    private List<Cabbie> cabbies = new ArrayList<>();
    private List<Passenger> passengers = new ArrayList<>();
    private List<Vehicle> vehicles = new ArrayList<>();
    private List<Ride> rides = new ArrayList<>();
    private List<RidePayment> payments = new ArrayList<>();
    
    private final File file = new File("Tarefa06\\app\\data\\database.xml");

    public Database(){
    }

    /**
     * Constructs a Database object. If load is true, it loads the database from a file.
     *
     * @param load If true, the database will be loaded from a file.
     */
    public Database(boolean load){
        if(load){
            this.load();
        }
    }
    
    /**
     * Retrieves the list of passengers.
     *
     * @return a list of Passenger objects.
     */
    @XmlElementWrapper(name="passengers")
    @XmlElement(name="passenger")
    public List<Passenger> getPassengers() {
        return this.passengers;
    }

    /**
     * Retrieves the list of cabbies.
     *
     * @return a list of Cabbie objects.
     */
    @XmlElementWrapper(name="cabbies")
    @XmlElement(name="cabbie")
    public List<Cabbie> getCabbies() {
        return this.cabbies;
    }

    /**
     * Retrieves the list of vehicles.
     *
     * @return a list of Vehicle objects.
     */
    @XmlElementWrapper(name="vehicles")
    @XmlElement(name="vehicle")
    public List<Vehicle> getVehicles() {
        return this.vehicles;
    }

    /**
     * Retrieves the list of rides.
     *
     * @return a list of Ride objects.
     */
    @XmlElementWrapper(name="rides")
    @XmlElement(name="ride")
    public List<Ride> getRides() {
        return this.rides;
    }

    /**
     * Retrieves the list of payment methods.
     *
     * @return a list of RidePayment objects.
     */
    @XmlElementWrapper(name="payments")
    @XmlElement(name="payment")
    public List<RidePayment> getPayments() {
        return this.payments;
    }

    /**
     * Inserts an object into the appropriate list based on its type.
     * <p>
     * This method supports insertion of the following object types:
     * <ul>
     *   <li>{@code Cabbie}</li>
     *   <li>{@code Passenger}</li>
     *   <li>{@code Vehicle}</li>
     *   <li>{@code Ride}</li>
     *   <li>{@code RidePayment}</li>
     * </ul>
     * If the object type is not supported, an {@code UnsupportedObjectTypeException} is thrown.
     * After insertion, the method triggers a save operation.
     * </p>
     * 
     * @param object The object to be inserted. It must be an instance of one of the supported types.
     * 
     * @throws UnsupportedObjectTypeException If the object is not one of the supported types for insertion.
     */
    public void insert(Object object) throws UnsupportedObjectTypeException {
        if (object instanceof Cabbie) {
            this.cabbies.add((Cabbie) object);
        } else if (object instanceof Passenger) {
            this.passengers.add((Passenger) object);
        } else if (object instanceof Vehicle) {
            this.vehicles.add((Vehicle) object);
        } else if (object instanceof Ride) {
            this.rides.add((Ride) object);
        } else if (object instanceof RidePayment) {
            this.payments.add((RidePayment) object);
        } else {
            throw new UnsupportedObjectTypeException("Trying to insert unsupported object type for database insertion");
        }
    
        this.save();
    }
    
    /**
     * Updates an existing item in the specified data list if it exists.
     *
     * @param newItem The new item to replace the existing one.
     * @param data The list of items where the update will be performed.
     * @param <T> The type of the items in the list.
     */
    private <T> void update(T newItem, List<T> data){
        for(int i=0;i<data.size();i++){
            Object item = data.get(i);

            if(item.equals(newItem)){
                data.set(i, newItem);
            }
        }
    }

    /**
     * Updates an existing object in the appropriate list based on its type.
     * <p>
     * This method supports updating objects of the following types:
     * <ul>
     *   <li>{@code Cabbie}</li>
     *   <li>{@code Passenger}</li>
     *   <li>{@code Vehicle}</li>
     *   <li>{@code Ride}</li>
     *   <li>{@code RidePayment}</li>
     * </ul>
     * If the object type is not supported, an {@code UnsupportedObjectTypeException} is thrown.
     * After updating the object, the method triggers a save operation.
     * </p>
     * 
     * @param object The object to be updated. It must be an instance of one of the supported types.
     * 
     * @throws UnsupportedObjectTypeException If the object is not one of the supported types for updating.
     */
    public void update(Object object) throws UnsupportedObjectTypeException {
        if(object instanceof Cabbie){
            this.update((Cabbie)object, this.cabbies);
        }else if(object instanceof Passenger){
            this.update((Passenger)object, this.passengers);
        }else if (object instanceof BusinessPassenger) {
            this.update((BusinessPassenger)object, this.passengers);
        }else if (object instanceof VIPPassenger) {
            this.update((VIPPassenger)object, this.passengers);
        }else if(object instanceof Vehicle){
            this.update((Vehicle)object, this.vehicles);
        }else if(object instanceof Ride){
            this.update((Ride)object, this.rides);
        }else if(object instanceof RidePayment){
            this.update((RidePayment)object, this.payments);
        }else{
            throw new UnsupportedObjectTypeException("Trying to update unsupported object type in the database");
        }
        this.save();       
    }

    /**
     * Saves the current state of the database to an XML file.
     * <p>
     * This method uses JAXB to marshal the current instance of the {@code Database} class into XML format 
     * and writes it to a specified file. The output is formatted for readability. If an error occurs during 
     * the marshalling or file I/O process, the exception stack trace is printed.
     * </p>
     * 
     * @throws JAXBException If an error occurs while marshalling the database object to XML.
     * @throws IOException   If an I/O error occurs during file operations.
     */
    private void save(){
        try{
            JAXBContext context = JAXBContext.newInstance(Database.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            OutputStream outputStream = new FileOutputStream(this.file);
            marshaller.marshal(this, outputStream);
            outputStream.close();
        }catch(JAXBException | IOException e){
            e.printStackTrace();
        }
    }

    /**
     * Loads the state of the database from an XML file.
     * <p>
     * This method checks if the specified file exists and, if so, uses JAXB to unmarshal the XML content
     * into a {@code Database} object. The loaded data, including cabbies, passengers, rides, vehicles, 
     * and payments, is then assigned to the current instance. If an error occurs during unmarshalling or 
     * file I/O operations, the exception stack trace is printed.
     * </p>
     * 
     * @throws JAXBException If an error occurs while unmarshalling the XML content.
     * @throws IOException   If an I/O error occurs during file operations.
     */
    private void load(){
        if(file.exists()){
            try{
                JAXBContext context = JAXBContext.newInstance(Database.class);
                Unmarshaller unmarshaller = context.createUnmarshaller();

                InputStream inputStream = new FileInputStream(this.file);
                Database db = (Database) unmarshaller.unmarshal(inputStream);
                inputStream.close();
                
                this.cabbies = db.getCabbies();
                this.passengers = db.getPassengers();
                this.rides = db.getRides();
                this.vehicles = db.getVehicles();
                this.payments = db.getPayments();
            }catch(JAXBException | IOException e){
                e.printStackTrace();
            }
        }
    }
}