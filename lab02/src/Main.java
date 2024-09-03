import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        //Aqui você deve realizar a simulação do funcionamento do sistema.
        Scanner input = new Scanner(System.in);
        ArrayList<Cabbie> cabbies = new ArrayList<Cabbie>();
        ArrayList<Passenger> passengers = new ArrayList<Passenger>();
    
        Cabbie cab = new Cabbie();
        cab.register(input);
        cabbies.add(cab);

        Passenger passenger = new Passenger();
        passenger.register(input);
        passengers.add(passenger);

        System.out.println(cabbies.get(0));
        System.out.println(passengers.get(0));

        input.close();
    }
}
