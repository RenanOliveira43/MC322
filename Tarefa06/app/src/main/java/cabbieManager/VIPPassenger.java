package cabbieManager;

import java.time.LocalDateTime;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import utils.LocalDateTimeAdapter;
import utils.PassengerInfoGenerator;

/**
 * Represents a VIP passenger, which extends the Passenger class and implements the BenefitsControll interface.
 * This class includes functionality for registering a VIP passenger, managing VIP expiration, and retrieving discount information.
 */
@XmlRootElement(name = "vipPassenger")
public class VIPPassenger extends Passenger implements BenefitsControll {
    private LocalDateTime vipExpiration;

    PassengerInfoGenerator pass = new PassengerInfoGenerator();

    /**
     * Registers the VIP passenger by generating and assigning random passenger information.
     */
    @Override
    public void register() {
        this.name = pass.getName();
        this.email = pass.getEmail();
        this.phone = pass.getPhone();
        this.passengerId = pass.getPassengerId();
        this.vipExpiration = pass.getExpirationDate();
        System.out.println("Pessoa passageira(conta vip) " + this.passengerId + " (" + this.name + ") criada com sucesso");
    }

    /**
     * Sets the expiration date for the VIP status.
     *
     * @param vipExpiration the expiration date to set
     */
    public void setVipExpiration(LocalDateTime vipExpiration) {
        this.vipExpiration = vipExpiration;
    }

    /**
     * Gets the expiration date of the VIP status.
     *
     * @return the VIP expiration date
     */
    @XmlJavaTypeAdapter(value = LocalDateTimeAdapter.class)
    @XmlElement(name="vipExpiration")
    public LocalDateTime getVipExpiration() {
        return vipExpiration;
    }

    /**
     * Retrieves the discount available for the VIP passenger.
     *
     * @return the discount amount as a double
     */
    @Override
    public double getDiscount() {
        return pass.getDiscount();
    }
}
