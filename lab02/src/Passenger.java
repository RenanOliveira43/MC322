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
    
        System.out.printf("Digite seu nome: ");
        setName(input.nextLine());

        System.out.printf("Digite seu email: ");
        setEmail(input.nextLine());

        System.out.printf("Digite seu telefone: ");
        setPhone(input.nextLine());

        setUserId(randomPassenger.getPassengerId());

        System.out.println("Cadastro realizado com sucesso! Seu ID de usuário é: " + getUserId());
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
            case "user id":
                setUserId(Integer.parseInt(newValue));
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
