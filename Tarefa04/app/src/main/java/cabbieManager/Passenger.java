package cabbieManager;

import com.google.common.base.Objects;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import utils.PassengerInfoGenerator;

/**
 * Represents a passenger that extends the {@code Person} class.
 * This class contains information such as passenger ID, email, name, and phone number.
 * 
 * The class includes methods to register and update passenger information.
 * 
 * Uses JAXB annotations for XML manipulation.
 */
@XmlRootElement(name="passenger")
public class Passenger extends Person {
    private String passengerId;
    private String email;
    private String name;
    private String phone;

    /**
     * Default constructor for the {@code Passenger} class.
     */
    public Passenger() {
    }

    /**
     * Registers a passenger by generating random information.
     * This method assigns a random email, name, phone number, and passenger ID.
     */
    @Override
    public void register() {
        PassengerInfoGenerator pass = new PassengerInfoGenerator();
        this.email = pass.getEmail();
        this.name = pass.getName();
        this.phone = pass.getPhone();
        this.passengerId = pass.getPassengerId();
        System.out.println("Passenger " + this.passengerId + " (" + this.name + ") created successfully");
    }

    /**
     * Updates a field of the passenger.
     * 
     * @param field The field to be updated. Valid fields are:
     *              <ul>
     *                <li>name</li>
     *                <li>email</li>
     *                <li>phone</li>
     *                <li>passengerId</li>
     *              </ul>
     * @param newValue The new value for the field.
     * If the field is invalid, a message is printed and the field is not updated.
     */
    @Override
    public void update(String field, String newValue) {
        boolean validField = true;

        switch (field) {
            case "name":
                this.name = newValue;
                break;
            case "email":
                this.email = newValue;
                break;
            case "phone":
                this.phone = newValue;
                break;
            case "passengerId":
                this.passengerId = newValue;
                break;
            default:
                System.out.println("Invalid field");
                validField = false;
        }

        if (validField) {
            System.out.println("Field " + field + " updated successfully!");
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
