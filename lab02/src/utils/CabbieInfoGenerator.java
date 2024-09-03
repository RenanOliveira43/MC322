package utils;
import java.util.*;


public class CabbieInfoGenerator implements InfoGenerator{

    private String[] names = {"Tiago", "Sofia", "Felipe", "Isabela", "Rodrigo", "Carolina", "Henrique", "Fernanda", "Mateus", "Gabriela"};
    private String[] emails = {"tiago.silva@email.com", "sofia.almeida@email.com", "felipe.oliveira@email.com", "isabela.ferreira@email.com", "rodrigo.santos@email.com", "carolina.martins@email.com", "henrique.costa@email.com", "fernanda.lima@email.com", "mateus.pereira@email.com", "gabriela.souza@email.com"};
    private String[] phones = {"+55 13 91234-5678", "+55 27 92345-6789", "+55 85 93456-7890", "+55 47 94567-8901", "+55 62 95678-9012", "+55 98 96789-0123", "+55 95 97890-1234", "+55 67 98901-2345", "+55 84 99012-3456", "+55 12 90123-4567"};
    private String[] licenseNumbers = {"1A2bC3dE", "FgH4IjK5", "L6mNopQr", "StUvWxYz", "A7bC8dEf", "GhI9JkLm", "NoPqRsTu", "VwXyZ123", "456AbCdE", "FgH7IjKl"};

    private String name;
    private String email;
    private String phone;
    private int cabbieId;
    private float rate;
    private String licenseNumber;

    public CabbieInfoGenerator() {
        this.generateRandomInfo();
    }

    public void generateRandomInfo() {

        Random ran = new Random();
        int idx = ran.nextInt(10);
        int cabbieId = 100 + ran.nextInt(100);
        float rate  = idx/2.0f;


        this.name = names[idx];
        this.email = emails[idx];
        this.phone = phones[idx];
        this.cabbieId = cabbieId;
        this.rate = rate;
        this.licenseNumber = licenseNumbers[idx];



        return;


    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPhone() {
        return this.phone;
    }

    public int getCabbieId() {
        return this.cabbieId;
    }

    public float getRate() {    
        return this.rate;
    }

    public String getLicenseNumber() {
        return this.licenseNumber;
    }
}
