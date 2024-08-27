// Renan Neves de Oliveira 257364

package lab01.src;

public class Taxi {
    private String destination;
    private boolean isHailed;
    private boolean isPassangerOn;

    public void setDestination(String destination) {
        this.destination = destination;
    }
    
    public void setHailed(boolean Hailed) {
        this.isHailed = Hailed;
    }
    
    public void setPassangerOn(boolean passangerOn) {
        this.isPassangerOn = passangerOn;
    }

    public String getDestination() {
        return destination;
    }
    
    public boolean getHailed() {
        return isHailed;
    }
    
    public boolean getPassengerOn() {
        return isPassangerOn;
    }
}
