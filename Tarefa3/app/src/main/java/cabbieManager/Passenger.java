// Renan Neves de Oliveira 257364

package cabbieManager;
import utils.PassengerInfoGenerator;
import java.util.Scanner;

public class Passenger extends Person {
    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Passenger() {
    }

    @Override
    // registra um novo passageiro com infos aleatorias, porem as infos podem ser inseridas via user input
    public void register(Scanner input) {
        PassengerInfoGenerator randomPassenger = new PassengerInfoGenerator();
    
        //System.out.println("Digite seu nome: ");
        //setName(input.nextLine());
        this.name = randomPassenger.getName();

        //System.out.println("Digite seu email: ");
        //setEmail(input.nextLine());
        this.email = randomPassenger.getEmail();

        //System.out.println("Digite seu telefone: ");
        //setPhone(input.nextLine());
        this.phone = randomPassenger.getPhone();
        this.userId = randomPassenger.getPassengerId();

        System.out.printf("Cadastro realizado com sucesso, %s! Seu Id de usuário é: %s\n", name, userId);
    }

    @Override
    public void update(String field, String newValue) {
        switch (field) {
            case "0": // name
                setName(newValue);
                System.out.printf("Campo 'nome' atualizado com sucesso para passageiro %s.\n", userId);
                break;
            case "1": // telefone
                setEmail(newValue);
                System.out.printf("Campo 'telefone' atualizado com sucesso para passageiro %s.\n", userId);
                break;
            case "2": // email
                setPhone(newValue);
                System.out.printf("Campo 'email' atualizado com sucesso para passageiro %s.\n", userId);
                break;
            default:
                System.out.println("Campo não encontrado.");
        }
    }

    @Override
    public String toString() {
        return "Passenger {" +
                "Name='" + getName() + '\'' +
                ", Email='" + getEmail() + '\'' +
                ", Phone='" + getPhone() + '\'' +
                ", User ID=" + getUserId() +
                '}';
    }
}
