// Renan Neves de Oliveira 257364

package cabbieManager;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        ArrayList<Cabbie> cabbies = new ArrayList<Cabbie>();
        ArrayList<Passenger> passengers = new ArrayList<Passenger>();
        ArrayList<Ride> rides = new ArrayList<Ride>();

        System.out.println("Seja bem vindo ao sistema de Taxi, Fast Travel!");

        while (true) {
            // inicializa o sistema 
            System.out.println("Já possui cadastro no Fast Travel? (sim/nao ou 'sair' para encerrar)");
            String cmd = input.nextLine();
            
            if(cmd.equals("sair")) {
                System.out.println("Encerrando o sistema... Obrigado por usar o Fast Travel!");
                break;
            }
            // possibilita um novo cadastro de usuario (motorista ou passageiro)
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
                    System.out.println("Opção inválida.");
                }
            }
            // caso existe passageiros ou motoristas
            else if (cmd.equals("sim") && (!passengers.isEmpty() || !cabbies.isEmpty())) {
                System.out.println("Digite 0 para motorista ou 1 para passageiro (ou 'sair' para encerrar).");
                cmd = input.nextLine();
                
                if(cmd.equals("sair")) {
                    System.out.println("Encerrando o sistema... Obrigado por usar o Fast Travel!");
                    break;
                }
                
                // interação com motorista
                if (cmd.equals("0") && !cabbies.isEmpty()) { 
                    System.out.println("Digite seu Cabbie ID:");
                    String id = input.nextLine();

                    // encontra o motorista por id no ArrayList
                    for (Cabbie cabb : cabbies) { 
                        if (cabb.getCabbieId().equals(id)) {
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
                                
                                // modifica veiculo
                                if (updateField.equals("5")) {
                                    Vehicle cabVehicle = cabb.getVehicle();
                                    
                                    System.out.println("0-registration number, 1-model, 2-year, 3-cabbie id");
                                    updateField = input.nextLine();
                                    
                                    String updateValue = input.nextLine();
                                    cabVehicle.updateVehicle(updateField, updateValue);
                                }
                                else {
                                    // modifica motorista
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
                
                // interação com passageiro
                else if (cmd.equals("1") && !passengers.isEmpty()) {
                    System.out.println("Digite seu user Id:");
                    String id = input.nextLine();

                    // encontra um passageiro por id no ArrayList passengers
                    for (Passenger pass : passengers) { 
                        if (pass.getUserId().equals(id)) {
                            System.out.println("Digite 0 para solicitar uma corrida ou 1 para alterar informações (ou 'sair' para encerrar).");
                            cmd = input.nextLine();

                            if(cmd.equals("sair")) {
                                System.out.println("Encerrando o sistema... Obrigado por usar o Fast Travel!");
                                break;
                            }

                            // solicita uma corrida
                            if (cmd.equals("0") && !cabbies.isEmpty()) { 
                                Random ran = new Random();
                                int randomCabbieIdx = ran.nextInt(cabbies.size()); // seleciona algum dos motoristas do ArrayList cabbies
                                
                                Vehicle cabVehicle = cabbies.get(randomCabbieIdx).getVehicle(); // pega o carro associado ao motorista para passar para Ride
                                Ride newRide = new Ride(pass.getUserId());
                                rides.add(newRide);
                                newRide.requestRide(input, cabbies.get(randomCabbieIdx).getCabbieId(), cabVehicle.getVehicleId());
                                newRide.updateRideStatus("Em progresso");
                                
                                // processa o pagamento e finaliza a corrida
                                RidePayment payment = new RidePayment(pass.getUserId(), newRide.getStartTime(), newRide.getDistance());
                                payment.processPayment(input);
                                newRide.completeRide();
                            }
                            else {
                                // altera uma informação de um passageiro existente 
                                System.out.println("0-Nome, 1-telefone, 2-email"); 
                                String updateField = input.nextLine();
                                String updateValue = input.nextLine();
                                
                                pass.update(updateField, updateValue);
                            }
                        }
                    }
                } 
                else {
                    System.out.println("Opção inválida ou lista vazia.");
                }
            }
        }
        input.close(); 
    }
}
