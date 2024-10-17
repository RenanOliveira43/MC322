package cabbieManager;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;

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
     * Updates the value of a specific field for the current object. If the field is 
     * "vipExpiration", it parses the new value as a {@link LocalDateTime}. If the parsing 
     * fails, it logs an error message indicating an invalid format.
     * For other fields, it delegates the update operation to the superclass.
     *
     * @param field The name of the field to be updated. If it is "vipExpiration", 
     * he value is parsed as a {@link LocalDateTime}.
     * @param newValue The new value to set for the specified field. For the "vipExpiration" 
     * field, this should be a valid {@link LocalDateTime} string.
     * 
     * @throws DateTimeParseException if the newValue for "vipExpiration" cannot be parsed 
     * into a valid {@link LocalDateTime}.
     */
    @Override
    public void update(String field, String newValue) {
        if (field.equals("vipExpiration")) {
            try {
                this.vipExpiration = LocalDateTime.parse(newValue);
                System.out.println("Campo " + field + " atualizado com sucesso!");
            } catch (DateTimeParseException e) {
                System.out.println("Invalid format for vip expiration.");
            }
        } else {
            super.update(field, newValue);
        }
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

    @Override
    public String toString() {
        return super.toString() + " " + this.vipExpiration;
    }
}
