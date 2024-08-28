// Renan Neves de Oliveira 257364

package lab01.src;

public class Main {
    public static void main(String[] args) {
        Passenger pessoa = new Passenger();
        Cabbie cabbie = new Cabbie();
        Taxi taxi = new Taxi();

        pessoa.performRole();

        if (pessoa.getDestination() != null && !pessoa.getDestination().isEmpty()) {

            System.out.printf("%s chama um táxi\n", pessoa.getName());
            taxi.setHailed(true);

            if (taxi.getHailed()) {
                System.out.println("Taxista atende ao chamado");

                taxi.setPassangerOn(true);
                System.out.printf("%s entra no táxi\n", pessoa.getName());

                taxi.setDestination(pessoa.getDestination());
                System.out.printf("%s informa ao taxista que seu destino é: %s\n", pessoa.getName(), taxi.getDestination());
                cabbie.performRole();
            
                pessoa.payCabbie(taxi.getTripCost());
                cabbie.setMoney(pessoa.getPayment());

                System.out.printf("%s sai do táxi\n", pessoa.getName());
                taxi.setPassangerOn(false);
            } 
            else {
                System.out.println("O táxi não foi chamado.");
            }
        } 
        else {
            System.out.println("Destino não definido.");
        }
    }
}
