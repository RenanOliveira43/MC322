package cabbieManager;

public interface Payment {
    public float calculateValue(float distance);
    public void processPayment();
}