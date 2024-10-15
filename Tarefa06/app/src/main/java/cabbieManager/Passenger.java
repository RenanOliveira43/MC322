package cabbieManager;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.common.base.Objects;

import utils.PassengerInfoGenerator;

@XmlRootElement(name="passenger")
public class Passenger extends Person{
    protected String passengerId;
    protected String email;
    protected String name;
    protected String phone;

    public Passenger() {
    }

    /**
     * Registers a passenger by generating random information.
     * This method assigns a random email, name, phone number, and user ID to the passenger.
     * 
     */
    @Override
    public void register() {
        PassengerInfoGenerator pass = new PassengerInfoGenerator();
        this.email = pass.getEmail();
        this.name = pass.getName();
        this.phone = pass.getPhone();
        this.passengerId = pass.getPassengerId();
        System.out.println("Pessoa passageira " + this.passengerId + " (" + this.name + ") criada com sucesso");
    }

    /**
     * Updates a field of the passenger with a new value.
     * <p>
     * The method updates the specified field of a passenger instance if the field is valid. It performs 
     * specific validation for the phone field to ensure that it contains only numeric characters.
     * </p>
     * 
     * @param field    The field to be updated. Supported fields include:
     * <ul>
     *   <li>name</li>
     *   <li>email</li>
     *   <li>phone</li>
     *   <li>passengerId</li>
     * </ul>
     * @param newValue The new value for the field. It should be a valid string representation for the field's data type.
     * 
     * @throws IllegalArgumentException If the {@code phone} field contains non-numeric characters.
     */
    @Override
    public void update(String field, String newValue){

        boolean validField = true;

        switch (field) {
            case "name":
                this.name = newValue;
                break;
            case "email":
                this.email = newValue;
                break;
            case "phone":
                if (!newValue.matches("\\d+")) {
                    throw new IllegalArgumentException("Input contains non-numeric characters: " + newValue);
                }
                this.phone = newValue;
                break;
            case "passengerId":
                this.passengerId = newValue;
                break;
            default:
                System.out.println("Campo inválido");
                validField = false;
                break;  
        }

        if (validField) {
            System.out.println("Campo " + field + " atualizado com sucesso!");
        }
    }

    /**
     * Retrieves the email of this passenger.
     *
     * @return the email as a string.
     */
    @XmlElement(name="email")
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email for this passenger.
     *
     * @param email The new email for the passenger.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Retrieves the name of this passenger.
     *
     * @return the name as a string.
     */
    @XmlElement(name="name")
    public String getName() {
        return name;
    }

    /**
     * Sets the name for this passenger.
     *
     * @param name The new name for the passenger.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retrieves the phone number of this passenger.
     *
     * @return the phone number as a string.
     */
    @XmlElement(name="phone")
    public String getPhone() {
        return phone;
    }

    /**
     * Sets the phone number for this passenger.
     *
     * @param phone The new phone number for the passenger.
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Retrieves the ID of this passenger.
     *
     * @return the ID of the passenger as a UUID string.
     */
    @XmlElement(name="passengerId")
    public String getPassengerId() {
        return this.passengerId;
    }

    /**
     * Sets the ID for this passenger.
     *
     * @param passengerId The new ID for the passenger.
     */
    public void setPassengerId(String passengerId) {
        this.passengerId = passengerId;
    }

    /**
     * Returns a string representation of the passenger.
     * 
     * The format is: "Passenger: email name phone passengerId".
     *
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return "Passenger: " + this.email + " " + this.name + " " + this.phone + " " + this.passengerId;
    }

    /**
     * Compares this passenger to another object for equality.
     *
     * @param o the object to compare with this passenger.
     * @return {@code true} if the specified object is equal to this passenger; {@code false} otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        Passenger pas = (Passenger) o;
        return Objects.equal(this.passengerId, pas.getPassengerId());
    }
}
