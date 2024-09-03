public class Ride {
    private String rideId;
    private String userId;
    private String cabbieId;
    private String vehicleId;
    private String pickupLocation;
    private String dropLocation;
    private String status;  // status da corrida: "Solicitada", "Em andamento", "Finalizada"
    private float fare;

    // Getters e Setters
    public String getRideId() {
        return rideId;
    }

    public void setRideId(String rideId) {
        this.rideId = rideId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCabbieId() {
        return cabbieId;
    }

    public void setCabbieId(String cabbieId) {
        this.cabbieId = cabbieId;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getPickupLocation() {
        return pickupLocation;
    }

    public void setPickupLocation(String pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    public String getDropLocation() {
        return dropLocation;
    }

    public void setDropLocation(String dropLocation) {
        this.dropLocation = dropLocation;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public float getFare() {
        return fare;
    }

    public void setFare(float fare) {
        this.fare = fare;
    }

    public void requestRide(String rideId, String userId, String cabbieId, String vehicleId, String pickupLocation, String dropLocation) {
        this.rideId = rideId;
        this.userId = userId;
        this.cabbieId = cabbieId;
        this.vehicleId = vehicleId;
        this.pickupLocation = pickupLocation;
        this.dropLocation = dropLocation;
        this.status = "Solicitada";  // status inicial da corrida
    }

    public void calculateFare() {

    }

    public void updateRideStatus(String newStatus) {
        this.status = newStatus;
    }

    public void completeRide() {
        this.status = "Finalizada";
    }

    @Override
    public String toString() {
        return "Ride {" +
                "Ride ID='" + rideId + '\'' +
                ", User ID='" + userId + '\'' +
                ", Cabbie ID='" + cabbieId + '\'' +
                ", Vehicle ID='" + vehicleId + '\'' +
                ", Pickup Location='" + pickupLocation + '\'' +
                ", Drop Location='" + dropLocation + '\'' +
                ", Status='" + status + '\'' +
                ", Fare=" + fare +
                '}';
    }
}
