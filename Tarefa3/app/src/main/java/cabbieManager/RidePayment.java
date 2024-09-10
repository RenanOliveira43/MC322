package cabbieManager;
import java.util.UUID;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class RidePayment implements Payment{
    
    private String paymentId;
    private String rideId;
    private LocalDateTime rideStartTime;
    private float rideDistance;
    private float amount;
    private PaymentOption paymentMethod;


    public RidePayment(String rideId, LocalDateTime startTime, float rideDistance, PaymentOption paymentOption) {
        this.rideStartTime = startTime;
        this.rideDistance = rideDistance;
        this.paymentMethod = paymentOption;
    }

    public float calculateValue(float rideDistance) {
        float initialFare = 0.0f; // Valor inicial
        float farePerKm = 0.0f;   // Valor por km
        LocalTime startNight = LocalTime.of(18, 0); // 18:00 horas
        LocalTime endNight = LocalTime.of(6, 0);    // 06:00 horas

        // Verificando se o horário está entre 18:00 e 06:00
        boolean isNightRide = this.rideStartTime.isAfter(startNight) || this.rideStartTime.isBefore(endNight);

        // Aplicar as tarifas com base na distância e se é corrida noturna
        if (rideDistance <= 5) {
            if (isNightRide) {
                initialFare = 6.00f;
                farePerKm = 2.50f;
            } else {
                initialFare = 5.00f;
                farePerKm = 2.00f;
            }
        } else if (rideDistance <= 10) {
            if (isNightRide) {
                initialFare = 5.00f;
                farePerKm = 3.00f;
            } else {
                initialFare = 4.00f;
                farePerKm = 2.50f;
            }
        } else if (rideDistance <= 15) {
            if (isNightRide) {
                initialFare = 4.50f;
                farePerKm = 3.50f;
            } else {
                initialFare = 3.50f;
                farePerKm = 3.00f;
            }
        } else if (rideDistance <= 20) {
            if (isNightRide) {
                initialFare = 4.00f;
                farePerKm = 4.50f;
            } else {
                initialFare = 3.00f;
                farePerKm = 4.00f;
            }
        } else { // Para distâncias maiores que 20 km
            if (isNightRide) {
                initialFare = 3.50f;
                farePerKm = 4.00f;
            } else {
                initialFare = 2.50f;
                farePerKm = 3.50f;
            }
        }

        // Cálculo do valor total da corrida
        float totalValue = (initialFare + (farePerKm * rideDistance)) * paymentMethod.calculatePaymentFee(totalValue);
        this.amount = totalValue;
        
        return totalValue;
    }

    
    /**
     * Processa o pagamento da corrida.
    */
    public void processPayment() {
        // IMPLEMENTAR METODO PROCESS PAYMENT
    }
}
