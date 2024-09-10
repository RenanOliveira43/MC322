package cabbieManager;

public enum PaymentOption {
    CREDIT_CARD(0.06f, "CREDIT CARD"),
    DEBIT_CARD(0.04f, "Debit Card"),
    CASH(0.00f, "Cash"),
    PIX(0.01f, "Pix"),
    VOUCHER(0.03f, "Voucher");

    private final float rideValue;
    private final String method;
    
    private PaymentOption(Float rideValue, String method){
        this.rideValue = rideValue;
        this.method = method;
    }

    public float calculatePaymentFee(float rideValue) {
        return rideValue * this.rideValue;
    }

    public float getRideValue() {
        return rideValue;
    }

    public String getMethod() {
        return method;
    }
}