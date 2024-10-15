package cabbieManager;
import java.util.UUID;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import utils.LocalDateTimeAdapter;

import java.time.LocalDateTime;
import java.time.LocalTime;
import exceptions.*;

@XmlRootElement(name="PaymentMethod")
public class RidePayment implements Payment {
    
    private String paymentId;
    private Ride ride;
    private LocalDateTime rideStartTime;
    private float rideDistance;
    private float amount;
    private PaymentOption paymentMethod;

    public RidePayment(){
        
    }

    /**
     * Constructs a new {@code RidePayment} instance.
     * <p>
     * This constructor initializes a new payment for a ride by generating a unique payment ID and 
     * calculating the total amount based on the ride's distance and the payment method provided.
     * It performs validation on the ride's start time, distance, and payment method.
     * </p>
     * 
     * @param rideId         The unique identifier for the ride.
     * @param rideStartTime  The start time of the ride. Must not be {@code null}.
     * @param rideDistance   The distance traveled during the ride, in kilometers. Must be greater than zero.
     * @param paymentMethod  The payment method selected by the user (e.g., "credit", "cash").
     * 
     * @throws NullPointerException           If the ride start time or payment method is {@code null}.
     * @throws InvalidRideDistanceException   If the ride distance is less than or equal to zero.
     */
    public RidePayment(Ride ride, LocalDateTime rideStartTime, float rideDistance, String paymentMethod){

        this.paymentId = UUID.randomUUID().toString();
        this.ride = ride;
        this.rideStartTime = rideStartTime;
        this.rideDistance = rideDistance;
        this.paymentMethod = this.selectPaymentMethod(paymentMethod);
        
        if (this.rideStartTime == null) {
            throw new NullPointerException("Start time of the ride to be paid cannot be null");
        }
        
        if (this.rideDistance <= 0.0f) {
            throw new InvalidRideDistanceException("Ride distance must be greater than zero");
        }
        
        if (this.paymentMethod == null) {
            throw new NullPointerException("Payment option is not valid");
        }

        if (!this.ride.equals(ride)) {
            throw new UnsupportedObjectTypeException("Invalid object type for ride payment: " + ride);
        }
        
        System.out.println("Forma de pagamento selecionada: " + paymentMethod);
        this.amount = this.calculateValue();
    }

    /**
     * Selects a PaymentOption from a given string.
     * @param paymentMethod the name of the payment method
     * @return the selected PaymentOption
     */
    private PaymentOption selectPaymentMethod(String paymentMethod) {
        return PaymentOption.valueOfName(paymentMethod);
    }

    /**
     * Calculates the total amount of the ride payment.
     * 
     * <p>
     * The amount is calculated based on the ride distance and the payment method selected by the user.
     * The algorithm used is as follows:
     * <ol>
     * <li>Identify the distance range using the following intervals: [0, 5], [5, 10], [10, 15], [15, 20], [20, 25].</li>
     * <li>Select the initial and per km price based on the identified distance range and the time of day (day or night).</li>
     * <li>Calculate the total amount by adding the initial price and the price per km multiplied by the ride distance.</li>
     * <li>Apply the payment method fee to the total amount.</li>
     * </ol>
     * 
     * @return the calculated amount
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
        double discount = especialPassengerDiscount(this.ride.getPassenger());

        // calculates the total amount considering the payment method fee
        double _amount = this.paymentMethod.calculatePaymentFee(precoInicial + (this.rideDistance * precoPorKm));
        discount = _amount * discount;
        _amount = _amount - discount;
        this.amount = Math.round(_amount * 100) / 100.0f;

        return this.amount;
    }
    
    /**
     * Calculates the discount for a given passenger type.
     *
     * @param o the passenger object, which can be either a BusinessPassenger or a VIPPassenger
     * @return the discount amount for the specified passenger type, or 0.0 if the passenger type is unknown
     */
    private double especialPassengerDiscount(Object o) {
        if (o instanceof BusinessPassenger) {
            return ((BusinessPassenger)o).getDiscount();
        }
        if (o instanceof VIPPassenger) {
            return ((VIPPassenger)o).getDiscount();
        }
        
        return 0.0f;
    }

    /**
     * Checks if the ride start time is during nighttime hours.
     *
     * @return true if the ride starts before 6:00 AM or after 6:00 PM; false otherwise.
     */
    private boolean isHorarioNoturno() {
        return this.rideStartTime.toLocalTime().isBefore(LocalTime.of(6, 0)) || this.rideStartTime.toLocalTime().isAfter(LocalTime.of(18, 0));
    }

    /**
     * Processes the payment for the ride, displaying the amount set for the ride.
     */
    public void processPayment() {
        double discount = especialPassengerDiscount(this.ride.getPassenger());
        
        if (discount > 0.0f) {
            System.out.printf("Desconto aplicado: %.1f%%%n", discount * 100);
        }
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
    @XmlElement(name="ride")
    public Ride getRideId() {
        return ride;
    }

    /**
     * Sets the ride ID for this ride.
     *
     * @param rideId The new ride ID.
     */
    public void setRideId(Ride ride) {
        this.ride = ride;
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
