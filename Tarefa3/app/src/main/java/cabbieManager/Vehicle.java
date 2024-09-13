// Renan Neves de Oliveira 257364
package cabbieManager;
import utils.VehicleInfoGenerator;
import java.util.Scanner;

public class Vehicle {
    private String vehicleId;
    private String registrationNumber;
    private String model;
    private int year;
    private String cabbieId; // será passado pela classe Cabbie

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
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

    public String getCabbieId() {
        return cabbieId;
    }

    public void setCabbieId(String cabbieId) {
        this.cabbieId = cabbieId;
    }
    
    // registra um novo veiculo com infos aleatorias, porem as infos podem ser inseridas via user input
    public void registerVehicle(Scanner input) {
        VehicleInfoGenerator randomVehicle = new VehicleInfoGenerator();

        //System.out.println("Digite o número de registro do veículo: ");
        //setRegistrationNumber(input.nextLine());
        this.registrationNumber = randomVehicle.getRegistrationNumber();

        //System.out.println("Digite o modelo do veículo: ");
        //setModel(input.nextLine());
        this.model = randomVehicle.getModel();

        //System.out.println("Digite o ano do veículo: ");
        //setYear(input.nextLine());
        this.year = randomVehicle.getYear();
        this.vehicleId = randomVehicle.getVehicleId();

        System.out.printf("Veículo (%s %s) registrado com sucesso! Id do veículo: %s\n", model, registrationNumber, vehicleId);
    }

    public void updateVehicle(String field, String newValue) {
        switch (field) {
            case "0": // registration number
                setRegistrationNumber(newValue);
                System.out.printf("Campo 'registration number' atualizado com sucesso para veiculo %s.\n", vehicleId);
                break;
            case "1": // model
                setModel(newValue);
                System.out.printf("Campo 'model' atualizado com sucesso para veiculo %s.\n", vehicleId);
                break;
            case "2": // year
                setYear(Integer.parseInt(newValue));
                System.out.printf("Campo 'year' atualizado com sucesso para veiculo %s.\n", vehicleId);
                break;
            case "3": // cabbie id
                setCabbieId(newValue);
                System.out.printf("Campo 'cabbie id' atualizado com sucesso para veiculo %s.\n", vehicleId);
                break;
            default:
                System.out.println("Campo não encontrado.");
        }
    }

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

