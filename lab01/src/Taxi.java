package lab01.src;

public class Taxi {
    private String destination;
    private boolean isHailed;

    public void setDestination(String a_destination) {
        this.destination = a_destination;
    }
    
    public void setHailed(boolean a_Hailed) {
        this.isHailed = a_Hailed;
    }
    
    public String getDestination() {
        return destination;
    }

    public boolean getHailed() {
        return isHailed;
    }

}
