// Renan Neves de Oliveira 257364

package lab01.src;

public class Cabbie extends Person {
    private double money;
    private double tripCost;
    
    @Override
    public void performRole() {
        System.out.printf("Taxista dirige até o destino\n");
        calculateTripCost();
    }

    public void setMoney(double money) {
        this.money = money;
    }
    
    public void setTripCost(double tripCost) {
        this.tripCost = tripCost;
    }

    public double getMoney() {
        return money;
    }
    
    public double getTripCost(){
        return tripCost;
    }
    
    private void calculateTripCost() {
        double tripCost = (Math.random() * ((100 - 15) + 1)) + 15;
        setTripCost(tripCost);
    }
}
