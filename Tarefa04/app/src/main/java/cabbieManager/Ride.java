package cabbieManager;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import com.google.common.base.Objects;

import utils.LocalDateTimeAdapter;

@XmlRootElement(name="ride")
public class Ride {
    
    private String rideId;
    private String passengerId;
    private String cabbieId;
    private String vehicleId;
    private String status;

    // Adcionar campos do Trabalho3
    private Location pickupLocation;
    private Location dropLocation;
    private LocalDateTime startTime;
    private float distance;


    //Adicionar os métodos da classe Ride
    public Ride(){

    }

    public Ride(String passengerId) {
        this.passengerId = passengerId;
    }

    /**
     * Requests a ride by a passenger.
     * 
     * @param pickupLocation  the location where the passenger wants to be picked up
     * @param dropLocation    the location where the passenger wants to be dropped off
     * 
     * The ride status is set to "REQUESTED".
     * The startTime is set to the current time.
     * 
     * A message is printed to the console with the information of the ride.
     */

    public void requestRide(String pickupLocation, String dropLocation) {

        this.rideId = UUID.randomUUID().toString();
        this.pickupLocation = this.returnLocation(pickupLocation);
        this.dropLocation= this.returnLocation(dropLocation);
        this.startTime = LocalDateTime.now();

        System.out.println("Corrida chamada por pessoa passageira " + this.passengerId + " de " + pickupLocation + " para " + dropLocation);
        this.updateRideStatus("CHAMADA", null, null);

        this.distance = this.calculateDistance();

    }


    /**
     * Returns a Location given a location name.
     * 
     * @param locationName  the name of the location
     * 
     * If the location is not found, a default value of AEROPORTO is returned.
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


    /**
     * Atualiza o status da corrida.
     * 
     * Se o status for "ACEPTED", armazena o ID do motorista e do veiculo que
     * aceitou a corrida.
     * 
     * @param status  o novo status da corrida
     * @param cabbieId o ID do motorista que aceitou a corrida, se status for
     *                "ACCEPTED"
     * @param vehicleId o ID do veiculo que aceitou a corrida, se status for
     *                  "ACCEPTED"
     */
    public void updateRideStatus(String status, String cabbieId, String vehicleId) {
        this.status = status;

        if (status.equals("ACEITA")) {
            this.cabbieId = cabbieId;
            this.vehicleId = vehicleId;
            System.out.println(("Corrida aceita por pessoa motorista " + this.cabbieId));
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
     * Retrieves the passenger ID associated with this ride.
     *
     * @return the passenger ID as a string.
     */
    @XmlElement
    public String getPassengerId() {
        return passengerId;
    }

    /**
     * Sets the passenger ID for this ride.
     *
     * @param passengerId The new passenger ID.
     */
    public void setPassengerId(String passengerId) {
        this.passengerId = passengerId;
    }

    /**
     * Retrieves the cabbie ID associated with this ride.
     *
     * @return the cabbie ID as a string.
     */
    @XmlElement(name="cabbieId")
    public String getCabbieId() {
        return cabbieId;
    }

    /**
     * Sets the cabbie ID for this ride.
     *
     * @param cabbieId The new cabbie ID.
     */
    public void setCabbieId(String cabbieId) {
        this.cabbieId = cabbieId;
    }

    /**
     * Retrieves the vehicle ID associated with this ride.
     *
     * @return the vehicle ID as a string.
     */
    @XmlElement(name="vehicleId")
    public String getVehicleId() {
        return vehicleId;
    }

    /**
     * Sets the vehicle ID for this ride.
     *
     * @param vehicleId The new vehicle ID.
     */
    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
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
