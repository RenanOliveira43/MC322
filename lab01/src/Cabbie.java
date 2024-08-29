// Renan Neves de Oliveira 257364

package lab01.src;

public class Cabbie extends Person {
    private double money;
    
    @Override
    public void performRole() {
        System.out.printf("Taxista dirige até o destino\n");
    }

    public void setMoney(double money) {
        this.money = money;
    }
    
    public double getMoney() {
        return money;
    }    
}
