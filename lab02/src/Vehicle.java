import utils.VehicleInfoGenerator;
import java.util.Scanner;

public class Vehicle {
    private int vehicleId;
    private String registrationNumber;
    private String model;
    private int year;
    private int cabbieId; // será passado pela classe Cabbie

    // Getters e Setters
    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getCabbieId() {
        return cabbieId;
    }

    public void setCabbieId(int cabbieId) {
        this.cabbieId = cabbieId;
    }

    // Método para registrar um veículo
    public void registerVehicle(Scanner input) {
        VehicleInfoGenerator randomVehicle = new VehicleInfoGenerator();

        System.out.println("Digite o número de registro do veículo: ");
        //setRegistrationNumber(input.nextLine());
        setRegistrationNumber(randomVehicle.getRegistrationNumber());

        System.out.println("Digite o modelo do veículo: ");
        //setModel(input.nextLine());
        setModel(randomVehicle.getModel());

        System.out.println("Digite o ano do veículo: ");
        //setYear(input.nextLine());
        setYear(randomVehicle.getYear());

        setVehicleId(randomVehicle.getVehicleId());

        System.out.printf("Veículo (%s %s) registrado com sucesso! ID do veículo: %d\n", getModel(), getRegistrationNumber(), getVehicleId());
    }

    // Método para atualizar as informações do veículo
    public void updateVehicle(String field, String newValue) {
        switch (field.toLowerCase()) {
            case "registration number":
                setRegistrationNumber(newValue);
                break;
            case "model":
                setModel(newValue);
                break;
            case "year":
                setYear(Integer.parseInt(newValue));
                break;
            case "cabbie id":
                setCabbieId(Integer.parseInt(newValue));
                break;
            default:
                System.out.println("Campo não encontrado.");
        }
    }

    // Método toString para exibir as informações do veículo
    @Override
    public String toString() {
        return "Vehicle {" +
                "Vehicle ID=" + vehicleId +
                ", Registration Number='" + registrationNumber + '\'' +
                ", Model='" + model + '\'' +
                ", Year='" + year + '\'' +
                ", Cabbie ID='" + cabbieId + '\'' +
                '}';
    }
}

