package lab01.src;
import java.util.Scanner;

public class Passenger extends Person{ 
    Scanner input = new Scanner((System.in));
    private String name;
    private String destination;
    private boolean tip;

    public void setName() {
        this.name = input.nextLine();    
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

    public void defineDestination() {
        this.destination = input.nextLine();
        System.out.printf("%s define o destino (%s)\n", name, destination);
    }

    @Override
    public void performRole() {
        defineDestination();
        
    }



}
