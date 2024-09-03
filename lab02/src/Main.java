import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        ArrayList<Cabbie> cabbies = new ArrayList<Cabbie>();
        ArrayList<Passenger> passengers = new ArrayList<Passenger>();
        ArrayList<Ride> rides = new ArrayList<Ride>();

        System.out.println("Seja bem vindo ao sistema de Taxi, Fast Travel!");

        while (true) {
            System.out.println("Já possui cadastro no Fast Travel? (sim/nao ou 'sair' para encerrar)");
            String cmd = input.nextLine();
            
            // checa se o usuário deseja sair
            if(cmd.equals("sair")) {
                System.out.println("Encerrando o sistema... Obrigado por usar o Fast Travel!");
                break;
            }

            if(cmd.equals("nao")) {
                System.out.println("Faça seu cadastro para começar a usar o Fast Travel!");
                System.out.println("Digite 0 para motorista ou 1 para passageiro (ou 'sair' para encerrar).");
                cmd = input.nextLine();
                
                if(cmd.equals("sair")) {
                    System.out.println("Encerrando o sistema... Obrigado por usar o Fast Travel!");
                    break;
                }

                // registra novo motorista e veiculo
                if (cmd.equals("0")) { 
                    Cabbie cab = new Cabbie();
                    Vehicle veh = new Vehicle();
            
                    cab.register(input);
                    veh.registerVehicle(input);
            
                    veh.setCabbieId(cab.getCabbieId());
                    cab.setVehicle(veh);
            
                    cabbies.add(cab);
                } 
                // registra novo passageiro
                else if (cmd.equals("1")) { 
                    Passenger pass = new Passenger();
                    pass.register(input);
                    passengers.add(pass);
                } 
                else {
                    System.out.println("Opção inválida. Por favor, digite 0 para motorista ou 1 para passageiro.");
                }
            }
            else if (cmd.equals("sim")) {
                System.out.println("Digite 0 para motorista ou 1 para passageiro (ou 'sair' para encerrar).");
                cmd = input.nextLine();
                
                if(cmd.equals("sair")) {
                    System.out.println("Encerrando o sistema... Obrigado por usar o Fast Travel!");
                    break;
                }

                if (cmd.equals("0") && !cabbies.isEmpty()) { 
                    System.out.println("Digite seu Cabbie ID:");
                    int id = input.nextInt();
                    input.nextLine();

                    // encontra o motorista por id no ArrayList
                    for (Cabbie cabb : cabbies) { 
                        if (cabb.getCabbieId() == id) {
                            System.out.println("Alterar alguma informação? (sim/nao ou 'sair' para encerrar)");
                            cmd = input.nextLine().trim().toLowerCase();
                            
                            if(cmd.equals("sair")) {
                                System.out.println("Encerrando o sistema... Obrigado por usar o Fast Travel!");
                                break;
                            }

                            // atualiza informação de um motorista ou veiculo existente
                            if (cmd.equals("sim")) { 
                                System.out.println("0-Nome, 1-telefone, 2-email, 3-license number, 4-rating, 5-veiculo");
                                String updateField = input.nextLine();
                                
                                if (updateField.equals("5")) {
                                    Vehicle cabVehicle = cabb.getVehicle();
                                    
                                    System.out.println("0-registration number, 1-model, 2-year, 3-cabbie id");
                                    updateField = input.nextLine();
                                    
                                    String updateValue = input.nextLine();
                                    cabVehicle.updateVehicle(updateField, updateValue);
                                }
                                else {
                                    String updateValue = input.nextLine(); 
                                    cabb.update(updateField, updateValue);
                                }
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
                    
                    // encontra um passageiro por id no ArrayList
                    for (Passenger pass : passengers) { 
                        if (pass.getUserId() == id) {
                            System.out.println("Digite 0 para solicitar uma corrida ou 1 para alterar informações (ou 'sair' para encerrar).");
                            cmd = input.nextLine().trim().toLowerCase();

                            if(cmd.equals("sair")) {
                                System.out.println("Encerrando o sistema... Obrigado por usar o Fast Travel!");
                                break;
                            }

                            // solicita uma corrida
                            if (cmd.equals("0") && !cabbies.isEmpty()) { 
                                Vehicle cabVehicle = cabbies.get(0).getVehicle();
                                Ride ride = new Ride();
                                Payment payment = new Payment();

                                rides.add(ride);
                                rides.get(0).requestRide(input, pass.getUserId(), cabbies.get(0).getCabbieId(), cabVehicle.getVehicleId());
                                
                                payment.processPayment(input, rides.get(0).getRideId(), rides.get(0).getFare());
                                rides.get(0).completeRide();
                            }
                            else {
                                System.out.println("0-Nome, 1-telefone, 2-email"); // altera uma informação de um passageiro existente 
                                String updateField = input.nextLine();
                                String updateValue = input.nextLine();
                                
                                pass.update(updateField, updateValue);
                            }
                        }
                    }
                } 
                else {
                    System.out.println("Opção inválida ou lista vazia. Por favor, digite 0 para motorista ou 1 para passageiro.");
                }
            }
        }
        input.close(); 
    }
}
