// Renan Neves de Oliveira 257364

package cabbieManager;
import java.util.Random;
import java.util.Scanner;

public class Ride {
    private int rideId;
    private int userId;
    private int cabbieId;
    private int vehicleId;
    private String pickupLocation;
    private String dropLocation;
    private String status;  // status da corrida: "Solicitada", "Em andamento", "Finalizada"
    private float fare;

    public int getRideId() {
        return rideId;
    }

    public void setRideId(int rideId) {
        this.rideId = rideId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getCabbieId() {
        return cabbieId;
    }

    public void setCabbieId(int cabbieId) {
        this.cabbieId = cabbieId;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
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

    public Ride(int userId, int cabbieId, int vehicleId) {
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
