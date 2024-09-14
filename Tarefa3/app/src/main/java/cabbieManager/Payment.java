package cabbieManager;

import java.util.Scanner;

public interface Payment {
    public float calculateValue();
    public void processPayment(Scanner input);
}