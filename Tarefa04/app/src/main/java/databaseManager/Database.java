package databaseManager;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import cabbieManager.Cabbie;
import cabbieManager.Passenger;
import cabbieManager.Ride;
import cabbieManager.RidePayment;
import cabbieManager.Vehicle;

@XmlRootElement(name="database")
public class Database {
    private List<Passenger> passengers = new ArrayList<>();
    private List<Cabbie> cabbies = new ArrayList<>();
    private List<Vehicle> vehicles = new ArrayList<>();
    private List<Ride> rides = new ArrayList<>();
    private List<RidePayment> paymentMethods = new ArrayList<>();

    private final File file = new File("Tarefa04\\app\\data\\database.xml");

    public Database(){
    }

    /**
     * Constructs a Database object. If load is true, it loads the database from a file.
     *
     * @param load If true, the database will be loaded from a file.
     */
    public Database(boolean load) {
        if (load) {
            this.load();
        }
    }

    /**
     * Retrieves the list of passengers.
     *
     * @return a list of Passenger objects.
     */
    @XmlElementWrapper(name="passengers")
    public List<Passenger> getPassengers() {
        return this.passengers;
    }

    /**
     * Retrieves the list of cabbies.
     *
     * @return a list of Cabbie objects.
     */
    @XmlElementWrapper(name="cabbies")
    public List<Cabbie> getCabbies() {
        return this.cabbies;
    }

    /**
     * Retrieves the list of vehicles.
     *
     * @return a list of Vehicle objects.
     */
    @XmlElementWrapper(name="vehicles")
    public List<Vehicle> getVehicles() {
        return this.vehicles;
    }

    /**
     * Retrieves the list of rides.
     *
     * @return a list of Ride objects.
     */
    @XmlElementWrapper(name="rides")
    public List<Ride> getRides() {
        return this.rides;
    }

    /**
     * Retrieves the list of payment methods.
     *
     * @return a list of RidePayment objects.
     */
    @XmlElementWrapper(name="payments")
    public List<RidePayment> getPaymentMethods() {
        return paymentMethods;
    }

    /**
     * Inserts a new object (Passenger, Cabbie, Vehicle, Ride, or RidePayment) into the database.
     *
     * @param object The object to be inserted into the database.
     */
    public void insert(Object object) {
        if (object instanceof Passenger) {
            this.passengers.add((Passenger) object);
        } else if (object instanceof Cabbie) {
            this.cabbies.add((Cabbie) object);
        } else if (object instanceof Vehicle) {
            this.vehicles.add((Vehicle) object);
        } else if (object instanceof Ride) {
            this.rides.add((Ride) object);
        } else if (object instanceof RidePayment) {
            this.paymentMethods.add((RidePayment) object);
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
    private <T> void update(T newItem, List<T> data) {
        for (int i = 0; i < data.size(); i++) {
            Object item = data.get(i);

            if (item.equals(newItem)) {
                data.set(i, newItem);
            }
        }
    }

    /**
     * Updates an existing object (Passenger, Cabbie, Vehicle, Ride, or RidePayment) in the database.
     *
     * @param object The object to be updated in the database.
     */
    public void update(Object object) {
        if (object instanceof Passenger) {
            this.update((Passenger) object, this.passengers);
        } else if (object instanceof Cabbie) {
            this.update((Cabbie) object, this.cabbies);
        } else if (object instanceof Vehicle) {
            this.update((Vehicle) object, this.vehicles);
        } else if (object instanceof Ride) {
            this.update((Ride) object, this.rides);
        } else if (object instanceof RidePayment) {
            this.update((RidePayment) object, this.paymentMethods);
        } else {
            return;
        }
        this.save();       
    }

    /**
     * Saves the current state of the database to an XML file.
     */
    private void save() {
        try {
            JAXBContext context = JAXBContext.newInstance(Database.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(this, file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Loads the database from an XML file if it exists.
     */
    private void load() {
        try {
            JAXBContext context = JAXBContext.newInstance(Database.class);
            File xmlFile = new File("Tarefa04\\app\\data\\database.xml");
            if (xmlFile.exists()) {
                Database loadedDatabase = (Database) context.createUnmarshaller().unmarshal(xmlFile);
                this.passengers = loadedDatabase.getPassengers();
                this.cabbies = loadedDatabase.getCabbies();
                this.vehicles = loadedDatabase.getVehicles();
                this.rides = loadedDatabase.getRides();
                this.paymentMethods = loadedDatabase.getPaymentMethods();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}