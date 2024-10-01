package cabbieManager;

/**
 * Enum representing different payment options available for transactions.
 * Each payment option has an associated name and fee, which is applied to the total value.
 */
public enum PaymentOption {

    CREDIT_CARD("Cartão de Crédito", 1.06f),
    CASH("Dinheiro", 1.0f),
    DEBIT_CARD("Cartão de Débito", 1.04f),
    VOUCHER("Voucher", 1.03f),
    PIX("Pix", 1.01f);

    private final String name;
    private final float fee;

    /**
     * Constructs a PaymentOption with the given name and fee multiplier.
     * 
     * @param name The name of the payment option.
     * @param fee The fee multiplier to be applied to the total value of the payment.
     */
    PaymentOption(String name, float fee) {
        this.name = name;
        this.fee = fee;
    }

    /**
     * Returns the PaymentOption corresponding to the given name.
     * If no matching option is found, it returns {@code null}.
     *
     * @param name The name of the payment option to find.
     * @return The PaymentOption with the given name, or {@code null} if none is found.
     */
    public static PaymentOption valueOfName(String name) {
        for (PaymentOption paymentOption : PaymentOption.values()) {
            if (paymentOption.name.equals(name)) {
                return paymentOption;
            }
        }
        return null;
    }

    /**
     * Calculates the total payment value including the fee for the selected payment option.
     *
     * @param value The base value of the payment.
     * @return The total value after applying the fee.
     */
    float calculatePaymentFee(float value) {
        return value * fee;
    }
}
