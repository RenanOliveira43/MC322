package cabbieManager;

public enum PaymentOption {
    CREDIT_CARD(0.06f, "Credit Card"),
    DEBIT_CARD(0.04f, "Debit Card"),
    CASH(0.00f, "Cash"),
    PIX(0.01f, "Pix"),
    VOUCHER(0.03f, "Voucher");

    private final float paymentFee;
    private final String paymentMethod;
    
    private PaymentOption(float paymentFee, String method){
        this.paymentFee = paymentFee;
        this.paymentMethod = method;
    }

    public float calculatePaymentFee(float rideValue) {
        return rideValue * this.paymentFee;
    }

    public float getPaymentFee() {
        return paymentFee;
    }

    public String getMethod() {
        return paymentMethod;
    }
}
