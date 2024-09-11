package cabbieManager;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class RidePayment implements Payment{
    
    private String paymentId;
    private String rideId;
    private LocalDateTime rideStartTime;
    private float rideDistance;
    private float amount;
    private PaymentOption paymentMethod;

    public String getPaymentId() {
        return paymentId;
    }

    public String getRideId() {
        return rideId;
    }

    public LocalDateTime getRideStartTime() {
        return rideStartTime;
    }

    public float getRideDistance() {
        return rideDistance;
    }

    public float getAmount() {
        return amount;
    }

    public PaymentOption getPaymentMethod() {
        return paymentMethod;
    }

    public RidePayment(String rideId, LocalDateTime startTime, float rideDistance, String paymentOption) {
        this.rideStartTime = startTime;
        this.rideDistance = rideDistance;
        this.paymentMethod = PaymentOption.valueOf(paymentOption.toUpperCase());
    }

    public float calculateValue(float rideDistance) {
        float initialFee = 0.0f;
        float feePerKm = 0.0f; 
        LocalTime startNight = LocalTime.of(18, 0); // 18:00 horas
        LocalTime endNight = LocalTime.of(6, 0);    // 06:00 horas

        // verificando se o horário está entre 18:00 e 06:00
        boolean isNightRide = this.rideStartTime.toLocalTime().isAfter(startNight) || this.rideStartTime.toLocalTime().isBefore(endNight);

        // aplicar as tarifas com base na distância e se é corrida noturna
        if (rideDistance <= 5) {
            if (isNightRide) {
                initialFee = 6.00f;
                feePerKm = 2.50f;
            } else {
                initialFee = 5.00f;
                feePerKm = 2.00f;
            }
        } else if (rideDistance <= 10) {
            if (isNightRide) {
                initialFee = 5.00f;
                feePerKm = 3.00f;
            } else {
                initialFee = 4.00f;
                feePerKm = 2.50f;
            }
        } else if (rideDistance <= 15) {
            if (isNightRide) {
                initialFee = 4.50f;
                feePerKm = 3.50f;
            } else {
                initialFee = 3.50f;
                feePerKm = 3.00f;
            }
        } else if (rideDistance <= 20) {
            if (isNightRide) {
                initialFee = 4.00f;
                feePerKm = 4.50f;
            } else {
                initialFee = 3.00f;
                feePerKm = 4.00f;
            }
        } else { // Para distâncias maiores que 20 km
            if (isNightRide) {
                initialFee = 3.50f;
                feePerKm = 4.00f;
            } else {
                initialFee = 2.50f;
                feePerKm = 3.50f;
            }
        }

        // calculo do valor total da corrida
        float totalValue = initialFee + (feePerKm * rideDistance);
        totalValue = totalValue + paymentMethod.calculatePaymentFee(totalValue);
        this.amount = totalValue;
        
        return totalValue;
    }

    public void processPayment() {
        // IMPLEMENTAR METODO PROCESS PAYMENT
    }
}
