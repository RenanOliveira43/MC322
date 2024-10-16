package cabbieManager;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.google.common.base.Objects;

import utils.LocalDateTimeAdapter;

/**
 * Represents a ride requested by a passenger.
 * <p>
 * The {@code Ride} class encapsulates the details of a ride, including the passenger ID, 
 * pickup and drop-off locations, start time, distance, and ride status. It provides 
 * functionality for requesting a ride and managing ride-related information.
 * </p>
 */
@XmlRootElement(name = "ride")
public class Ride {
    private String rideId;
    private Passenger passenger;
    private Cabbie cabbie;
    private Vehicle vehicle;
    private String status;
    private Location pickupLocation;
    private Location dropLocation;
    private LocalDateTime startTime;
    private float distance;

    public Ride() {

    }

    public Ride(Passenger passenger) {
        this.passenger = passenger;
    }

    /**
     * Requests a ride by a passenger.
     * 
     * @param pickupLocation  The location where the passenger wants to be picked up.
     * @param dropLocation    The location where the passenger wants to be dropped off.
     * 
     * <p>
     * The ride status is set to "CHAMADA", and the start time is set to the current time. 
     * A message is printed to the console with the information of the ride.
     * </p>
     * 
     * @throws IllegalArgumentException If the pickup or drop location is invalid.
     */
    public void requestRide(String pickupLocation, String dropLocation) {

        this.rideId = UUID.randomUUID().toString();
        this.pickupLocation = this.returnLocation(pickupLocation);
        this.dropLocation= this.returnLocation(dropLocation);
        this.startTime = LocalDateTime.now();

        if (this.pickupLocation == null) {
            throw new IllegalArgumentException("Invalid location name: " + pickupLocation);
        }

        if (this.dropLocation == null) {
            throw new IllegalArgumentException("Invalid location name: " + dropLocation);
        }

        System.out.println("Corrida chamada por pessoa passageira " + this.passenger.getPassengerId() + " de " + pickupLocation + " para " + dropLocation);
        this.updateRideStatus("CHAMADA", null, null);

        this.distance = this.calculateDistance();
    }

    /**
     * Returns a Location given a location name.
     * 
     * @param locationName  the name of the location
     * 
     * If the location is not found, null is returned.
     * 
     * @return a Location object
     */
    private Location returnLocation(String locationName) {
        return Location.valueOfName(locationName);
    }

    /**
     * Calculates the distance between the pickup and drop locations.
     * 
     * The distance is calculated as the Euclidean distance between the two points.
     * 
     * @return the calculated distance.
     */
    public float calculateDistance() {
        
        int x_pickup = pickupLocation.getX();
        int y_pickup = pickupLocation.getY();

        int x_drop = dropLocation.getX();
        int y_drop = dropLocation.getY();

        float distance = (float) Math.sqrt(Math.pow(x_drop - x_pickup, 2) + Math.pow(y_drop - y_pickup, 2));
        distance = Math.round(distance * 100) / 100.0f;
                
        System.out.println(("Distância calculada: " + distance));
        return distance;
    }


    public void updateRideStatus(String status, Cabbie cabbie, Vehicle vehicle) {
        this.status = status;

        if (status.equals("ACEITA")) {
            this.cabbie = cabbie;
            this.vehicle = vehicle;
            System.out.println(("Corrida aceita por pessoa motorista " + this.cabbie.getCabbieId()));
        } else {
            System.out.println("Status da corrida: " + this.status);
        }
    }

   /**
     * Finalizes the ride by updating its status to "FINALIZADA" 
     * and printing a message indicating the ride has been completed.
     */
    public void completeRide() {
        this.status = "FINALIZADA";
        System.out.println("Corrida finalizada");
    }

    /**
     * Retrieves the pickup location of this ride.
     *
     * @return the pickup location as a Location object.
     */
    @XmlElement(name="pickupLocation")
    public Location getPickLocation() {
        return this.pickupLocation;
    }

    /**
     * Sets the pickup location of this ride.
     *
     * @param pickupLocation The new pickup location.
     */
    public void setPickupLocation(Location pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    /**
     * Retrieves the drop location of this ride.
     *
     * @return the drop location as a Location object.
     */
    @XmlElement(name="dropLocation")
    public Location getDropLocation() {
        return this.dropLocation;
    }

    /**
     * Sets the drop location of this ride.
     *
     * @param dropLocation The new drop location.
     */
    public void setDropLocation(Location dropLocation) {
        this.dropLocation = dropLocation;
    }

    /**
     * Retrieves the ID of this ride.
     *
     * @return the ID of this ride as a UUID string.
     */
    @XmlElement(name="rideId")
    public String getRideId() {
        return this.rideId;
    }

    /**
     * Sets the ID of this ride.
     *
     * @param rideId The new ride ID.
     */
    public void setRideId(String rideId) {
        this.rideId = rideId;
    }

    /**
     * Retrieves the start time of this ride.
     *
     * @return the start time of this ride as a LocalDateTime object.
     */
    @XmlJavaTypeAdapter(value = LocalDateTimeAdapter.class)
    @XmlElement(name="startTime")
    public LocalDateTime getStartTime() {
        return this.startTime;
    }

    /**
     * Retrieves the distance of this ride.
     *
     * @return the distance of this ride as a float value.
     */
    @XmlElement(name="distance")
    public float getRideDistance() {
        return this.distance;
    }

    /**
     * Gets the Passenger object.
     * 
     * @return the passenger object
     */
    @XmlElement(name="passenger")
    public Passenger getPassenger() {
        return passenger;
    }

    /**
     * Sets the Passenger object.
     * 
     * @param passenger the passenger to set
     */
    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    /**
     * Gets the Cabbie id.
     * 
     * @return the cabbie id
     */
    @XmlElement(name="cabbie")
    public Cabbie getCabbie() {
        return this.cabbie;
    }

    /**
     * Sets the Cabbie object.
     * 
     * @param cabbie the cabbie to set
     */
    public void setCabbie(Cabbie cabbie) {
        this.cabbie = cabbie;
    }

    /**
     * Gets the Vehicle id.
     * 
     * @return the vehicle id
     */
    @XmlElement(name="vehicle")
    public Vehicle getVehicle() {
        return this.vehicle;
    }

    /**
     * Sets the Vehicle object.
     * 
     * @param vehicle the vehicle to set
     */
    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    /**
     * Retrieves the current status of this ride.
     *
     * @return the status of this ride as a string.
     */
    @XmlElement(name="status")
    public String getStatus() {
        return status;
    }

    /**
     * Sets the status of this ride.
     *
     * @param status The new status for the ride.
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Sets the distance of this ride.
     *
     * @param distance The new distance for the ride.
     */
    public void setDistance(float distance) {
        this.distance = distance;
    }

    /**
     * Compares this ride to another object for equality.
     *
     * @param o the object to compare with this ride.
     * @return true if the specified object is equal to this ride; false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        Ride pas = (Ride) o;
        return Objects.equal(this.rideId, pas.getRideId());
    }

    /**
     * Returns a string representation of this ride.
     *
     * @return a string that represents this ride, including its ID.
     */
    @Override
    public String toString() {
        return "Ride: " + this.rideId;
    }
}
