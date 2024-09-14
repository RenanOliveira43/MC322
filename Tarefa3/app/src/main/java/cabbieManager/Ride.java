// Renan Neves de Oliveira 257364

package cabbieManager;
import java.time.Duration;
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
        
        this.startTime = LocalDateTime.now(); // pega a data e o horario que a corrida é solicitada
        
        this.pickupLocation = validateLocation(input, "Digite o ponto de partida:");
        this.dropLocation = validateLocation(input, "Digite o destino:");

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
        float speed = 60.0f; // considera que a velocidade media da corrida foi de 60 km/h
        float rideTimeHours = distance / speed; // calcula o tempo da corrida em horas 
        long rideTimeMinutes = (long)(rideTimeHours * 60); // converte de horas para minutos 

        this.endTime = startTime.plus(Duration.ofMinutes(rideTimeMinutes)); // soma o tempo em startRide e atribui o valor a endTime
        this.status = "Finalizada";
        
        System.out.printf("Status da corrida: %s.\n", status);
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
    
    // metodo auxiliar para requestRide
    private Location validateLocation(Scanner input, String mensagem) { 
        while (true) {
            try {
                System.out.println(mensagem);
                String local = input.nextLine().toUpperCase().replace(" ", "_");
                return Location.valueOf(local); // retorna a localização se for válida
            } 
            catch (IllegalArgumentException e) {
                System.out.println("Local inválido! Tente novamente.");
            }
        }
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
