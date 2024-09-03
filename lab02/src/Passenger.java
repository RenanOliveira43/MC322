import utils.PassengerInfoGenerator;
import java.util.Scanner;

public class Passenger extends Person {
    private int userId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Passenger() {
    }

    @Override
    public void register(Scanner input) {
        PassengerInfoGenerator randomPassenger = new PassengerInfoGenerator();
    
        System.out.println("Digite seu nome: ");
        //setName(input.nextLine());
        setName(randomPassenger.getName());

        System.out.println("Digite seu email: ");
        //setEmail(input.nextLine());
        setEmail(randomPassenger.getEmail());

        System.out.println("Digite seu telefone: ");
        //setPhone(input.nextLine());
        setPhone(randomPassenger.getPhone());

        setUserId(randomPassenger.getPassengerId());

        System.out.printf("Cadastro realizado com sucesso, %s! Seu ID de usuário é: %d\n", getName(), getUserId());
    }

    @Override
    public void update(String field, String newValue) {
        switch (field.toLowerCase()) {
            case "0": // name
                setName(newValue);
                System.out.printf("Campo 'nome' atualizado com sucesso para passageiro %d.\n", getUserId());
                break;
            case "1": // telefone
                setEmail(newValue);
                System.out.printf("Campo 'email' atualizado com sucesso para passageiro %d.\n", getUserId());
                break;
            case "2": // email
                setPhone(newValue);
                System.out.printf("Campo 'telefone' atualizado com sucesso para passageiro %d.\n", getUserId());
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
