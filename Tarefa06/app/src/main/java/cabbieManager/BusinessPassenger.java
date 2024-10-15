package cabbieManager;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import utils.PassengerInfoGenerator;

/**
 * Represents a business passenger, which extends the Passenger class and implements the BenefitsControll interface.
 * This class includes functionality for registering a business passenger and retrieving discount information.
 */
@XmlRootElement(name="businessPassenger")
public class BusinessPassenger extends Passenger implements BenefitsControll {
    private String businessEmail;
    
    PassengerInfoGenerator pass = new PassengerInfoGenerator();

    /**
     * Registers the business passenger by generating and assigning random passenger information.
     */
    @Override
    public void register() {
        this.name = pass.getName();
        this.businessEmail = pass.getBusinessEmail();
        this.phone = pass.getPhone();
        this.passengerId = pass.getPassengerId();
        System.out.println("Pessoa passageira(conta empresarial) " + this.passengerId + " (" + this.name + ") criada com sucesso");
    }

    /**
     * Sets the email for the business passenger.
     *
     * @param email the business email to set
     */
    @Override
    public void setEmail(String email) {
        this.businessEmail = email;
    }

    /**
     * Gets the business email of the business passenger.
     *
     * @return the business email
     */
    @Override
    @XmlElement(name="businessEmail")
    public String getEmail() {
        return this.businessEmail;
    }

    /**
     * Retrieves the discount available for the business passenger.
     *
     * @return the discount amount as a double
     */
    @Override
    public double getDiscount() {
        return pass.getDiscount();
    }
}
