import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        ArrayList<Cabbie> cabbies = new ArrayList<Cabbie>();
        ArrayList<Passenger> passengers = new ArrayList<Passenger>();
        
        System.out.println("Seja bem vindo ao sistema de Taxi, Fast Travel!");

        while (true) {
            System.out.println("Já possui cadastro no Fast Travel? (sim/nao)");
            String cmd = input.nextLine();
            
            if(cmd.toLowerCase().equals("nao")) {
                System.out.println("Faça seu cadastro para começar a usar o Fast Travel!");
                System.out.println("Digite 0 para motorista ou 1 para passageiro.");
                cmd = input.nextLine();

                if (cmd.equals("0")) {
                    Cabbie cab = new Cabbie();
                    Vehicle veh = new Vehicle();
            
                    cab.register(input);
                    veh.registerVehicle(input);
            
                    veh.setCabbieId(cab.getCabbieId());
                    cab.setVehicle(veh);
            
                    cabbies.add(cab);
                } 
                else if (cmd.equals("1")) {
                    Passenger pass = new Passenger();
                    pass.register(input);
                    passengers.add(pass);
                } 
                else {
                    System.out.println("Opção inválida. Por favor, digite 0 para motorista ou 1 para passageiro.");
                }
            }
            else {
                System.out.println("Digite 0 para motorista ou 1 para passageiro.");
                cmd = input.nextLine();
                
                if (cmd.equals("0") && !cabbies.isEmpty()) {
                    System.out.println("Digite seu Cabbie ID:");
                    int id = input.nextInt();
                    input.nextLine();

                    for (Cabbie cabb : cabbies){
                        if (cabb.getCabbieId() == id){
                            System.out.println("Alterar alguma informação? (sim/nao)");
                            cmd = input.nextLine();
                            
                            if (cmd.equals("sim")) {
                                System.out.println("0-Nome, 1-telefone, 2-email, 3-license number, 4-rating");
                                cmd = input.nextLine();
                                String update = input.nextLine();
                                cabb.update(cmd, update);
                            }
                            break;
                        }
                        else {
                            System.out.println("Cabbie Id não encontrado.");
                        }
                    }
                } 
                else if (cmd.equals("1") && !passengers.isEmpty()) {
                    System.out.println("Digite seu user ID:");
                    int id = input.nextInt();
                    input.nextLine();

                    for (Passenger pass : passengers) {
                        if (pass.getUserId() == id) {
                            System.out.println("Digite 0 para solicitar uma corrida ou 1 para alterar informações.");
                            cmd = input.nextLine();

                            if (cmd.equals("0") && !cabbies.isEmpty()) {
                                Ride ride = new Ride();
                                Vehicle cabVehicle = cabbies.get(0).getVehicle();
                                ride.requestRide(input, id, pass.getUserId(), cabbies.get(0).getCabbieId(), cabVehicle.getVehicleId());
                            }
                            else {
                                System.out.println("0-Nome, 1-telefone, 2-email");
                                cmd = input.nextLine();
                                String update = input.nextLine();
                                pass.update(cmd, update);
                            }
                        }
                    }
                } 
                else {
                    System.out.println("Opção inválida. Por favor, digite 0 para motorista ou 1 para passageiro.");
                }
            }
        }
    }
}
