package cabbieManager;

/**
 * Enum representing various payment options available in the system.
 * <p>
 * Each payment option includes a name and a corresponding fee multiplier that affects 
 * the total payment amount. The supported payment options are:
 * <ul>
 *   <li>{@code CREDIT_CARD} - A credit card payment method with an associated fee.</li>
 *   <li>{@code CASH} - A cash payment method with no additional fees.</li>
 *   <li>{@code DEBIT_CARD} - A debit card payment method with a slight fee.</li>
 *   <li>{@code VOUCHER} - A voucher payment method with a small fee.</li>
 *   <li>{@code PIX} - A digital payment method with the lowest fee.</li>
 * </ul>
 * </p>
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
     * Constructs a {@code PaymentOption} with the specified name and fee.
     * 
     * @param name The display name of the payment option.
     * @param fee  The fee multiplier associated with this payment option.
     */
    PaymentOption(String name, float fee) {
        this.name = name;
        this.fee = fee;
    }
    
    /**
     * Returns the PaymentOption corresponding to the given name, or null if none is found.
     * @param name The name of the payment option to find.
     * @return The PaymentOption with the given name, or null if none is found.
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
     * Calculates the payment fee for a given value.
     *
     * @param value The value to calculate the fee for.
     * @return The calculated payment fee.
     */

    float calculatePaymentFee(float value) {
        return value * fee;
    }
}