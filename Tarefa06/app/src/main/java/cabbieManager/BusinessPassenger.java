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
     * Updates the value of a specific field for the current object. If the field is 
     * "businessEmail", it sets the new email value and logs a success message. 
     * For other fields, it delegates the update operation to the superclass.
     *
     * @param field The name of the field to be updated. If it is "businessEmail", 
     * the new email value is set directly.
     * @param newValue The new value to set for the specified field. For the "businessEmail" 
     * field, this should be a valid email string.
     */
    @Override
    public void update(String field, String newValue) {
        if (field.equals("businessEmail")) {
            this.businessEmail = newValue;
            System.out.println("Campo " + field + " atualizado com sucesso!");
        } else {
            super.update(field, newValue);
        }
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

    @Override
    public String toString() {
        return super.toString() + " " + this.businessEmail;
    }
}
