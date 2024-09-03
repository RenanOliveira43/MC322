import utils.CabbieInfoGenerator;
import java.util.Scanner;

public class Cabbie extends Person{
    private int cabbieId;
    private float rating;
    private String licenseNumber;
    private Vehicle vehicle;

    public int getCabbieId() {
        return cabbieId;
    }

    public float getRating() {
        return rating;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setCabbieId(int cabbieId) {
        this.cabbieId = cabbieId;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Cabbie() {

    }

    @Override
    public void register(Scanner input) {
        CabbieInfoGenerator randomCabbie = new CabbieInfoGenerator();
        
        System.out.printf("Digite seu nome: ");
        setName(input.nextLine());

        System.out.printf("Digite seu email: ");
        setEmail(input.nextLine());

        System.out.printf("Digite seu telefone: ");
        setPhone(input.nextLine());

        System.out.printf("Digite o numero da sua CNH: ");
        setLicenseNumber(input.nextLine());

        setRating(randomCabbie.getRate());
        setCabbieId(randomCabbie.getCabbieId());

        System.out.println("Cadastro realizado com sucesso! Seu ID de taxista é: " + getCabbieId());
    }

    @Override
    public void update(String field, String newValue) {
        switch (field.toLowerCase()) {
            case "name":
                setName(newValue);
                break;
            case "email":
                setEmail(newValue);
                break;
            case "phone":
                setPhone(newValue);
                break;
            case "license number":
                setLicenseNumber(newValue);
                break;
            case "rating":
                setRating(Float.parseFloat(newValue));
                break;
            case "cabbie id":
                setCabbieId(Integer.parseInt(newValue));
                break;
            default:
                System.out.println("Campo não encontrado");
        }
    }

    @Override
    public String toString() {
        return "Cabbie {" +
                "Name='" + getName() + '\'' +
                ", Email='" + getEmail() + '\'' +
                ", Phone='" + getPhone() + '\'' +
                ", License Number='" + getLicenseNumber() + '\'' +
                ", Cabbie ID=" + getCabbieId() +
                ", Rating=" + getRating() +
                ", Vehicle=" + getVehicle() +
                '}';
    }
}
