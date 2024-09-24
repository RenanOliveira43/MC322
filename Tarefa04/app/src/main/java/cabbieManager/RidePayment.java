package cabbieManager;
import java.util.UUID;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import utils.LocalDateTimeAdapter;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class RidePayment implements Payment{
    
    private String paymentId;
    private String rideId;
    private LocalDateTime rideStartTime;
    private float rideDistance;
    private float amount;
    private PaymentOption paymentMethod;

    public RidePayment(){
        
    }

    public RidePayment(String rideId, LocalDateTime rideStartTime, float rideDistance ,String paymentMethod) {

        this.paymentId = UUID.randomUUID().toString();
        this.rideId = rideId;
        this.rideStartTime = rideStartTime;
        this.rideDistance = rideDistance;
        this.paymentMethod = this.selectPaymentMethod(paymentMethod);
        System.out.println("Forma de pagamento selecionada: " + paymentMethod);
        this.amount = this.calculateValue();

    }


    /**
     * Selects a PaymentOption from a given string.
     * @param paymentMethod the name of the payment method
     * @return the selected PaymentOption
     * @throws IllegalArgumentException if paymentMethod is not a valid PaymentOption
     */
    private PaymentOption selectPaymentMethod(String paymentMethod) {
        return PaymentOption.valueOfName(paymentMethod);
    }

    /**
     * Calculates the value of the ride.
     * 
     * The value is calculated using the price table
     * 
     * @return the calculated value of the ride.
     */
    public float calculateValue() {

        final float[] PRECO_INICIAL_DIURNO = {5.00f, 4.00f, 3.50f, 3.00f, 2.50f};
        final float[] PRECO_POR_KM_DIURNO = {2.00f, 2.50f, 3.00f, 4.00f, 3.50f};
        final float[] PRECO_INICIAL_NOTURNO = {6.00f, 5.00f, 4.50f, 4.00f, 3.50f};
        final float[] PRECO_POR_KM_NOTURNO = {2.50f, 3.00f, 3.50f, 4.50f, 4.0f};
        final float DISTANCIAS_LIMITE[] = {5, 10, 15, 20, 25};


        // identifies the distance range
        int faixa = -1;

        for (int i = 0; i < DISTANCIAS_LIMITE.length; i++) {
            if (this.rideDistance <= DISTANCIAS_LIMITE[i]) {
                faixa = i;
                break;
            }
        }


        // stabilish the initial and per km price
        float precoInicial = isHorarioNoturno() ? PRECO_INICIAL_NOTURNO[faixa] : PRECO_INICIAL_DIURNO[faixa];
        float precoPorKm = isHorarioNoturno() ? PRECO_POR_KM_NOTURNO[faixa] : PRECO_POR_KM_DIURNO[faixa];

        // calculates the total amount considering the payment method fee
        float _amount = this.paymentMethod.calculatePaymentFee(precoInicial + (this.rideDistance * precoPorKm));
        this.amount = Math.round(_amount * 100) / 100.0f;

        return this.amount;
    }

    private boolean isHorarioNoturno() {
        return this.rideStartTime.toLocalTime().isBefore(LocalTime.of(6, 0)) || this.rideStartTime.toLocalTime().isAfter(LocalTime.of(18, 0));
    }

    
    /**
     * Processa o pagamento da corrida.
    */
    public void processPayment() {
        System.out.println("Valor da corrida definido: " + this.amount);
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getRideId() {
        return rideId;
    }

    public void setRideId(String rideId) {
        this.rideId = rideId;
    }

    @XmlJavaTypeAdapter(value = LocalDateTimeAdapter.class)
    public LocalDateTime getRideStartTime() {
        return rideStartTime;
    }

    public void setRideStartTime(LocalDateTime rideStartTime) {
        this.rideStartTime = rideStartTime;
    }

    public float getRideDistance() {
        return rideDistance;
    }

    public void setRideDistance(float rideDistance) {
        this.rideDistance = rideDistance;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public PaymentOption getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentOption paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
