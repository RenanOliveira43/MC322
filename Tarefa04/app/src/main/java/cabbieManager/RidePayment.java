package cabbieManager;
import java.util.UUID;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import utils.LocalDateTimeAdapter;

import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * Represents a payment for a ride in the cabbie management system.
 * This class holds information related to the payment for a ride, including
 * the payment ID, ride ID, ride details, payment amount, and the selected payment method.
 */
@XmlRootElement(name="ridePayment")
public class RidePayment implements Payment{
    
    private String paymentId;
    private String rideId;
    private LocalDateTime rideStartTime;
    private float rideDistance;
    private float amount;
    private PaymentOption paymentMethod;

    public RidePayment(){
        
    }

    /**
     * Constructs a RidePayment object with the specified parameters.
     *
     * @param rideId The ID of the ride.
     * @param rideStartTime The start time of the ride as a LocalDateTime.
     * @param rideDistance The distance of the ride in float.
     * @param paymentMethod The payment method selected for the ride.
     */
    public RidePayment(String rideId, LocalDateTime rideStartTime, float rideDistance, String paymentMethod) {
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

    /**
     * Checks if the ride start time is during nighttime hours.
     *
     * @return true if the ride starts before 6:00 AM or after 6:00 PM; false otherwise.
     */
    private boolean isHorarioNoturno() {
        return this.rideStartTime.toLocalTime().isBefore(LocalTime.of(6, 0)) || 
            this.rideStartTime.toLocalTime().isAfter(LocalTime.of(18, 0));
    }

    /**
     * Processes the payment for the ride, displaying the amount set for the ride.
     */
    public void processPayment() {
        System.out.println("Valor da corrida definido: " + this.amount);
    }

    /**
     * Retrieves the payment ID for this ride.
     *
     * @return the payment ID as a string.
     */
    @XmlElement(name="paymentId")
    public String getPaymentId() {
        return paymentId;
    }

    /**
     * Sets the payment ID for this ride.
     *
     * @param paymentId The new payment ID.
     */
    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    /**
     * Retrieves the ride ID for this ride.
     *
     * @return the ride ID as a string.
     */
    @XmlElement(name="rideid")
    public String getRideId() {
        return rideId;
    }

    /**
     * Sets the ride ID for this ride.
     *
     * @param rideId The new ride ID.
     */
    public void setRideId(String rideId) {
        this.rideId = rideId;
    }

    /**
     * Retrieves the start time of this ride.
     *
     * @return the start time as a LocalDateTime object.
     */
    @XmlJavaTypeAdapter(value = LocalDateTimeAdapter.class)
    @XmlElement(name="startTime")
    public LocalDateTime getRideStartTime() {
        return rideStartTime;
    }

    /**
     * Sets the start time for this ride.
     *
     * @param rideStartTime The new start time for the ride.
     */
    public void setRideStartTime(LocalDateTime rideStartTime) {
        this.rideStartTime = rideStartTime;
    }

    /**
     * Retrieves the distance of this ride.
     *
     * @return the distance of the ride as a float value.
     */
    @XmlElement(name="distance")
    public float getRideDistance() {
        return rideDistance;
    }

    /**
     * Sets the distance for this ride.
     *
     * @param rideDistance The new distance for the ride.
     */
    public void setRideDistance(float rideDistance) {
        this.rideDistance = rideDistance;
    }

    /**
     * Retrieves the amount charged for this ride.
     *
     * @return the amount as a float value.
     */
    @XmlElement(name="amount")
    public float getAmount() {
        return amount;
    }

    /**
     * Sets the amount charged for this ride.
     *
     * @param amount The new amount for the ride.
     */
    public void setAmount(float amount) {
        this.amount = amount;
    }

    /**
     * Retrieves the payment method used for this ride.
     *
     * @return the payment method as a PaymentOption object.
     */
    @XmlElement(name="paymentMethod")
    public PaymentOption getPaymentMethod() {
        return paymentMethod;
    }

    /**
     * Sets the payment method for this ride.
     *
     * @param paymentMethod The new payment method.
     */
    public void setPaymentMethod(PaymentOption paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}