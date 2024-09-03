import utils.VehicleInfoGenerator;
import java.util.Scanner;

public class Vehicle {
    private int vehicleId;
    private String registrationNumber;
    private String model;
    private String year;
    private String cabbieId;

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

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getCabbieId() {
        return cabbieId;
    }

    public void setCabbieId(String cabbieId) {
        this.cabbieId = cabbieId;
    }

    // Método para registrar um veículo
    public void registerVehicle() {
        VehicleInfoGenerator randomVehicle = new VehicleInfoGenerator();
        Scanner input = new Scanner(System.in);

        // Entrada manual para registro do veículo
        System.out.printf("Digite o número de registro do veículo: ");
        setRegistrationNumber(input.nextLine());

        System.out.printf("Digite o modelo do veículo: ");
        setModel(input.nextLine());

        System.out.printf("Digite o ano do veículo: ");
        setYear(input.nextLine());

        System.out.printf("Digite o ID do motorista (Cabbie ID): ");
        setCabbieId(input.nextLine());

        // Gerar um ID aleatório para o veículo
        setVehicleId(randomVehicle.getVehicleId());

        System.out.println("Veículo registrado com sucesso! ID do veículo: " + getVehicleId());

        input.close();
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
                setYear(newValue);
                break;
            case "cabbie id":
                setCabbieId(newValue);
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

