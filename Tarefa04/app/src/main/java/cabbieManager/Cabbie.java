package cabbieManager;

import com.google.common.base.Objects;

import utils.CabbieInfoGenerator;

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

        return;
    }
    
    
    /**
     * Gets the ID of the cabbie.
     * 
     * @return the ID of the cabbie (a UUID)
     */
    public String getCabbieId() {
        return this.cabbieId;
    }
    
    public void setCabbieId(String cabbieId) {
        this.cabbieId = cabbieId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public boolean getIsBusy(){
        return this.isBusy;
    }

    public void setIsBusy(boolean value){
        this.isBusy = value;
    }
    public float getRate() {
        return rate;
    }


    public void setRate(float rate) {
        this.rate = rate;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }


    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }


    /**
     * Returns a string representation of the object.
     * 
     * The format is: "email name phone cabbieId rate licenseNumber"
     * 
     * @return a string representation of the object
     */
    @Override
    public String toString() {
        return "Cabbie:" + this.cabbieId + this.name;
    }

    @Override
    public boolean equals(Object o){
        if(o == this){
            return true;
        }
        
        Cabbie pas = (Cabbie) o;
        return Objects.equal(this.cabbieId, pas.getCabbieId());
    }

}
