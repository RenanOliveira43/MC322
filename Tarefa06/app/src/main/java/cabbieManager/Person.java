package cabbieManager;

import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * Abstract class representing a person in the system.
 * <p>
 * This class serves as a base for specific types of persons, such as {@code Passenger} and 
 * {@code Cabbie}. It includes common attributes like name, email, and phone, and defines 
 * abstract methods for registering and updating person details.
 * </p>
 * 
 * @see Passenger
 * @see Cabbie
 */
@XmlSeeAlso({Passenger.class, Cabbie.class, BusinessPassenger.class, VIPPassenger.class})
public abstract class Person {
    protected String name;
    protected String email;
    protected String phone;

    /**
     * Registers the person in the system.
     * <p>
     * This method should be implemented by subclasses to provide specific registration logic 
     * for different types of persons.
     * </p>
     */
    public abstract void register();

    /**
     * Updates a specified field of the person with a new value.
     * 
     * @param field    The field to be updated.
     * @param newValue The new value for the field.
     * @throws Exception If an error occurs during the update process.
     */
    public abstract void update(String field, String newValue) throws Exception;
}