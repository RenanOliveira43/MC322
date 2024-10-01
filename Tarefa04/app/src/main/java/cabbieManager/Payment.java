package cabbieManager;

/**
 * Interface representing a payment system.
 * This interface defines the methods required for calculating and processing payments.
 */
public interface Payment {

    /**
     * Calculates the value of the payment.
     * 
     * @return the total value of the payment as a float.
     */
    public float calculateValue();

    /**
     * Processes the payment.
     * This method is responsible for handling the actual transaction logic.
     */
    public void processPayment();
}
