package exceptions;

public class InvalidRideDistanceException extends RuntimeException{

    public InvalidRideDistanceException(String message){
        super(message);
    }

    public InvalidRideDistanceException(String message, Throwable cause){
        super(message, cause);
    }  
}