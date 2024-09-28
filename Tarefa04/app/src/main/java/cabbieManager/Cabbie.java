package cabbieManager;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.common.base.Objects;

import utils.CabbieInfoGenerator;

@XmlRootElement(name="cabbie")
public class Cabbie extends Person{
    private String cabbieId;
    private float rate;
    private String licenseNumber;
    private boolean isBusy;
    private String name;

    public Cabbie() {
    }

    /**
     * Registers a cabbie by generating random information.
     * This method assigns a random name, email, phone number, cabbie ID, rate and
     * license number to the cabbie.
     * 
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
        System.out.println("Pessoa motorista " + this.cabbieId + " (" + this.name + ") criada com sucesso");
    }

    /**
     * Updates a field of the cabbie.
     * 
     * @param field The field to be updated.
     * @param newValue The new value for the field.
     * 
     * The valid fields are:
     * <ul>
     * <li>name</li>
     * <li>email</li>
     * <li>phone</li>
     * <li>cabbieId</li>
     * <li>rate</li>
     * <li>licenseNumber</li>
     * </ul>
     * 
     * If the field is not valid, a message is printed and the field is not updated.
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
                System.out.println("Campo inválido");
                break;
        }

        if (validField) {
            System.out.println("Campo " + field + " foi atualizado com sucesso!");
        }
    }
    
    
    /**
     * Gets the ID of the cabbie.
     * 
     * @return the ID of the cabbie (a UUID)
     */
    @XmlElement(name="cabbieId")
     public String getCabbieId() {
        return this.cabbieId;
    }
        
    /**
     * Sets the cabbie ID for this cabbie.
     *
     * @param cabbieId The new cabbie ID.
     */
    public void setCabbieId(String cabbieId) {
        this.cabbieId = cabbieId;
    }

    /**
     * Retrieves the name of this cabbie.
     *
     * @return the name as a string.
     */
    @XmlElement(name="name")
    public String getName() {
        return this.name;
    }

    /**
     * Sets the name for this cabbie.
     *
     * @param name The new name for the cabbie.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retrieves the busy status of this cabbie.
     *
     * @return true if the cabbie is busy; false otherwise.
     */
    @XmlElement(name="isBusy")
    public boolean getIsBusy() {
        return this.isBusy;
    }

    /**
     * Sets the busy status for this cabbie.
     *
     * @param value The new busy status for the cabbie.
     */
    public void setIsBusy(boolean value) {
        this.isBusy = value;
    }

    /**
     * Retrieves the rate of this cabbie.
     *
     * @return the rate as a float value.
     */
    @XmlElement(name="rate")
    public float getRate() {
        return rate;
    }

    /**
     * Sets the rate for this cabbie.
     *
     * @param rate The new rate for the cabbie.
     */
    public void setRate(float rate) {
        this.rate = rate;
    }

    /**
     * Retrieves the license number of this cabbie.
     *
     * @return the license number as a string.
     */
    @XmlElement(name="licenseNumber")
    public String getLicenseNumber() {
        return licenseNumber;
    }

    /**
     * Sets the license number for this cabbie.
     *
     * @param licenseNumber The new license number for the cabbie.
     */
    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    /**
     * Returns a string representation of the cabbie.
     *
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
     * @param o the object to compare with this cabbie.
     * @return true if the specified object is equal to this cabbie; false otherwise.
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
