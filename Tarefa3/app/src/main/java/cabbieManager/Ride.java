// Renan Neves de Oliveira 257364

package cabbieManager;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.Scanner;

public class Ride {
    private String rideId;
    private String userId;
    private String cabbieId;
    private String vehicleId;
    private Location pickupLocation;
    private Location dropLocation;
    private String status;  // status da corrida: "Solicitada", "Em andamento", "Finalizada"
    private float fare;
    private float distance;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

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

    public Location getPickupLocation() {
        return pickupLocation;
    }

    public void setPickupLocation(Location pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    public Location getDropLocation() {
        return dropLocation;
    }

    public void setDropLocation(Location dropLocation) {
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

    public Ride(String userId, String cabbieId, String vehicleId) {
        Random ran = new Random();
        this.rideId = ran.nextInt(100);
        this.userId = userId;
        this.cabbieId = cabbieId;
        this.vehicleId = vehicleId;  
    }

    public void requestRide(Scanner input) {
        calculateFare();
        
        System.out.println("Digite o ponto de partida:");
        
        
        this.pickupLocation = input.nextLine();
        
        System.out.println("Digite o destino:");
        this.dropLocation = input.nextLine();
        
        System.out.printf("Corrida solicitada por passageiro %d de %s para %s.\n", getUserId(), getPickupLocation(), getDropLocation());
        System.out.printf("Corrida atendida por motorista %d.\n", getCabbieId());
        System.out.printf("Valor da corrida definido: R$%.2f.\n", getFare());
        
        this.status = "Solicitada";  // status inicial da corrida
    }

    public void calculateFare() {
        float fare = (float)(Math.random() * ((100 - 20) + 1)) + 20;
        setFare(fare);
    }

    public void updateRideStatus(String newStatus) {
        this.status = newStatus;
    }

    public void completeRide() {
        this.status = "Finalizada";
        System.out.println("Corrida finaliza");

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
