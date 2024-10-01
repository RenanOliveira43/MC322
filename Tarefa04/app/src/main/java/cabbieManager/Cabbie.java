package cabbieManager;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.common.base.Objects;

import utils.CabbieInfoGenerator;

/**
 * Represents a cab driver (Cabbie) that extends the {@code Person} class.
 * This class contains information such as the cabbie ID, rating, license number,
 * busy status, and name.
 * 
 * The class includes methods to register, update fields, and manage cabbie information.
 * 
 * Uses JAXB annotations for XML manipulation.
 */
@XmlRootElement(name="cabbie")
public class Cabbie extends Person {
    private String cabbieId;
    private float rate;
    private String licenseNumber;
    private boolean isBusy;
    private String name;

    /**
     * Default constructor for the {@code Cabbie} class.
     */
    public Cabbie() {
    }

    /**
     * Registers a cabbie by generating random information.
     * This method assigns a random name, email, phone number, cabbie ID,
     * rating, and license number to the cabbie.
     */
    @Override
    public void register() {
        CabbieInfoGenerator cab = new CabbieInfoGenerator();
        this.name = cab.getName();
        this.email = cab.getEmail();
        this.phone = cab.getPhone();
        this.cabbieId = cab.getCabbieId();
        this.rate = cab.getRate();
        this.licenseNumber = cab.getLicenseNumber();
        this.isBusy = false;
        System.out.println("Cabbie " + this.cabbieId + " (" + this.name + ") created successfully");
    }

    /**
     * Updates a field of the cabbie.
     * 
     * @param field The field to be updated. Valid fields are:
     *              <ul>
     *                <li>name</li>
     *                <li>email</li>
     *                <li>phone</li>
     *                <li>cabbieId</li>
     *                <li>rate</li>
     *                <li>licenseNumber</li>
     *                <li>isBusy</li>
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
            case "cabbieId":
                this.cabbieId = newValue;
                break;
            case "rate":
                this.rate = Float.parseFloat(newValue);
                break;
            case "licenseNumber":
                this.licenseNumber = newValue;
                break;
            case "isBusy":
                this.isBusy = Boolean.parseBoolean(newValue);
                break;
            default:
                validField = false;
                System.out.println("Invalid field");
                break;
        }

        if (validField) {
            System.out.println("Field " + field + " was successfully updated!");
        }
    }

    /**
     * Gets the cabbie ID.
     * 
     * @return the cabbie ID (UUID).
     */
    @XmlElement(name="cabbieId")
    public String getCabbieId() {
        return this.cabbieId;
    }

    /**
     * Sets the cabbie ID.
     * 
     * @param cabbieId The new cabbie ID.
     */
    public void setCabbieId(String cabbieId) {
        this.cabbieId = cabbieId;
    }

    /**
     * Gets the name of the cabbie.
     * 
     * @return the name of the cabbie.
     */
    @XmlElement(name="name")
    public String getName() {
        return this.name;
    }

    /**
     * Sets the name of the cabbie.
     * 
     * @param name The new name of the cabbie.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the busy status of the cabbie.
     * 
     * @return {@code true} if the cabbie is busy; {@code false} otherwise.
     */
    @XmlElement(name="isBusy")
    public boolean getIsBusy() {
        return this.isBusy;
    }

    /**
     * Sets the busy status of the cabbie.
     * 
     * @param value The new busy status.
     */
    public void setIsBusy(boolean value) {
        this.isBusy = value;
    }

    /**
     * Gets the rating of the cabbie.
     * 
     * @return the rating as a float value.
     */
    @XmlElement(name="rate")
    public float getRate() {
        return rate;
    }

    /**
     * Sets the rating of the cabbie.
     * 
     * @param rate The new rating.
     */
    public void setRate(float rate) {
        this.rate = rate;
    }

    /**
     * Gets the cabbie's license number.
     * 
     * @return the license number as a string.
     */
    @XmlElement(name="licenseNumber")
    public String getLicenseNumber() {
        return licenseNumber;
    }

    /**
     * Sets the cabbie's license number.
     * 
     * @param licenseNumber The new license number.
     */
    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    /**
     * Returns a string representation of the cabbie.
     * The format is: "Cabbie: cabbieId name".
     * 
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return "Cabbie: " + this.cabbieId + " " + this.name;
    }

    /**
     * Compares this cabbie to another object for equality.
     * 
     * @param o The object to compare with this cabbie.
     * @return {@code true} if the specified object is equal to this cabbie; {@code false} otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        Cabbie pas = (Cabbie) o;
        return Objects.equal(this.cabbieId, pas.getCabbieId());
    }
}
