// Renan Neves de Oliveira 257364

package lab01.src;
import java.util.Scanner;

public class Passenger extends Person { 
    private String name;
    private String destination;
    private boolean tip;
    private double payment;
    
    Scanner input = new Scanner(System.in);
    
    @Override
    public void performRole() {
        startPassenger();
    }
    
    public String getName() {
        return name;
    }

    public String getDestination() {
        return destination;
    }

    public void setTip(boolean tip) {
        this.tip = tip;
    }

    public boolean getTip() {
        return tip;
    }

    public double getPayment() {
        return payment;
    }

    private void startPassenger() {
        System.out.println("Digite o nome do passageiro:");
        this.name = input.nextLine();
        
        System.out.println("Digite o destino:");
        this.destination = input.nextLine();
        
        System.out.println("Dar gorjeta? (true/false):");
        this.tip = input.nextBoolean();

        System.out.printf("%s define o destino (%s)\n", name, destination);
    }

    public void payCabbie(double tripCost) {
        if (tip) {
            tripCost += (tripCost * 0.1); // 10% de gorjeta
            this.payment = tripCost;
            
            System.out.printf("%s paga R$%.2f para o taxista (com gorjeta)\n", name, payment);
        }
        else {
            this.payment = tripCost;
            System.out.printf("%s paga R$%.2f para o taxista (sem gorjeta)\n", name, payment);
        }
    }
}
