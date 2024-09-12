// Renan Neves de Oliveira 257364

package cabbieManager;
import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.UUID;

public class Ride {
    private String rideId;
    private String userId;
    private String cabbieId;
    private String vehicleId;
    private Location pickupLocation;
    private Location dropLocation;
    private float distance;
    private String status;
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

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public Ride(String userId) {
        this.rideId = UUID.randomUUID().toString();
        this.userId = userId;
    }

    public void requestRide(Scanner input, String cabbieId, String vehicleId) {
        this.cabbieId = cabbieId;
        this.vehicleId = vehicleId;
        this.status = "Solicitada";
        

        // adicionar forma de entar com startTime


        System.out.println("Digite o ponto de partida:");
        String pickUp = input.nextLine().toUpperCase().replace(" ", "_");
        this.pickupLocation = Location.valueOf(pickUp);

        
        System.out.println("Digite o destino:");
        String drop = input.nextLine().toUpperCase().replace(" ", "_");
        this.dropLocation = Location.valueOf(drop);

        System.out.printf("Corrida solicitada por passageiro %s de %s para %s.\n", userId, pickupLocation.getName(), dropLocation.getName());
        System.out.printf("Status da corrida: %s.\n", status);
        
        this.distance = calculateDistance();
        System.out.printf("Distancia calculada: %.2f.\n", distance);
        System.out.printf("Corrida atendida por motorista %s.\n", cabbieId);
    }

    public void updateRideStatus(String newStatus) {
        this.status = newStatus;
        System.out.printf("Status da corrida: %s.\n", status);
    }

    public void completeRide() {
        this.status = "Finalizada";
        System.out.printf("Status da corrida: %s.\n", status);

        // adicionar forma de entar com endTime
    }

    public float calculateDistance() {
        float px = this.pickupLocation.getX();
        float py = this.pickupLocation.getY();
        float qx = this.dropLocation.getX();
        float qy = this.dropLocation.getY();
    
        // calcula a diferença entre as coordenadas
        float deltaX = qx - px;
        float deltaY = qy - py;
    
        // calcula a distância euclidiana
        float distance = (float) Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));
        this.distance = Math.round(distance * 100) / 100.0f;
        
        return this.distance;
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
                '}';
    }
}
