package cabbieManager;

import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * Abstract class representing a general person.
 * This class serves as the base for specific types of persons, such as {@link Passenger} and {@link Cabbie}.
 * It defines common attributes and methods that must be implemented by subclasses.
 */
@XmlSeeAlso({Passenger.class, Cabbie.class})
public abstract class Person {
    
    /** The name of the person. */
    protected String name;

    /** The email address of the person. */
    protected String email;

    /** The phone number of the person. */
    protected String phone;

    /**
     * Registers the person.
     * Subclasses must provide the implementation for this method, which typically involves 
     * initializing the person's details.
     */
    public abstract void register();

    /**
     * Updates a specified field of the person with a new value.
     * 
     * @param field The field to be updated (e.g., name, email, phone).
     * @param newValue The new value to assign to the field.
     */
    public abstract void update(String field, String newValue); 
}
