// Renan Neves de Oliveira 257364

package cabbieManager;
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
    // registra um novo cabbie com infos aleatorias, porem as infos podem ser inseridas via user input
    public void register(Scanner input) {
        CabbieInfoGenerator randomCabbie = new CabbieInfoGenerator();
        
        //System.out.println("Digite seu nome: ");
        //setName(input.nextLine());
        setName(randomCabbie.getName());

        //System.out.println("Digite seu email: ");
        //setEmail(input.nextLine());
        setEmail(randomCabbie.getEmail());

        //System.out.println("Digite seu telefone: ");
        //setPhone(input.nextLine());
        setPhone(randomCabbie.getPhone());

        //System.out.println("Digite o numero da sua CNH: ");
        //setLicenseNumber(input.nextLine());
        setLicenseNumber(randomCabbie.getLicenseNumber());

        setRating(randomCabbie.getRate());
        setCabbieId(randomCabbie.getCabbieId());

        System.out.printf("Cadastro realizado com sucesso, %s! Seu ID de taxista é: %d\n", getName(), getCabbieId());
    }

    @Override
    public void update(String field, String newValue) {
        switch (field) {
            case "0": // name
                setName(newValue);
                System.out.printf("Campo 'nome' atualizado com sucesso para motorista %d.\n", getCabbieId());
                break;
            case "1": // email
                setEmail(newValue);
                System.out.printf("Campo 'email' atualizado com sucesso para motorista %d.\n", getCabbieId());
                break;
            case "2": // telefone
                setPhone(newValue);
                System.out.printf("Campo 'telefone' atualizado com sucesso para motorista %d.\n", getCabbieId());
                break;
            case "3": // license number
                setLicenseNumber(newValue);
                System.out.printf("Campo 'license number' atualizado com sucesso para motorista %d.\n", getCabbieId());
                break;
            case "4": // rating
                setRating(Float.parseFloat(newValue));
                System.out.printf("Campo 'rating' atualizado com sucesso para motorista %d.\n", getCabbieId());
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
