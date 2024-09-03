// Renan Neves de Oliveira 257364

import java.util.Random;
import java.util.Scanner;

public class Payment {
    private int paymentId;
    private int rideId;
    private float amount;
    private String paymentMethod;
    private String[] paymentMethods = {"Credit Card", "Debit Card", "Cash"};

    public int getPaymentId() {
        return paymentId;
    }

    public int getRideId() {
        return rideId;
    }

    public float getAmount() {
        return amount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public void setRideId(int rideId) {
        this.rideId = rideId;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void processPayment(Scanner input, int rideId, float fare) {
        Random random = new Random();
        this.paymentId = random.nextInt(100);
        this.rideId = rideId;
        this.amount = fare;

        boolean validMethod = false;
        while (!validMethod) {
            System.out.println("Digite a forma de pagamento (Credit Card, Debit Card, Cash):");
            String method = input.nextLine();

            // validar a forma de pagamento
            for (String valid : paymentMethods) {
                if (method.equalsIgnoreCase(valid)) {
                    validMethod = true;
                    this.paymentMethod = method;
                    
                    System.out.println("Forma de pagamento aceita.");
                    break;
                }
            }

            if (!validMethod) {
                System.out.println("Forma de pagamento não reconhecida!");
            }
        }
    }
}
