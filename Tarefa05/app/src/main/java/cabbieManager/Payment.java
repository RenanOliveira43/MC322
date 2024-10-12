package cabbieManager;
/**
 * Interface representing a payment system.
 * <p>
 * This interface defines the methods required for any payment implementation. Classes implementing 
 * this interface should provide specific details on how to calculate the payment value and how to 
 * process the payment.
 * </p>
 */
public interface Payment {
    
    /**
     * Calculates the value of the payment.
     * 
     * @return The calculated payment amount as a {@code float}.
     */
    public float calculateValue();

    /**
     * Processes the payment.
     * <p>
     * This method is responsible for handling the payment transaction, which may involve 
     * interactions with payment gateways or other services.
     * </p>
     */
    public void processPayment();
}

