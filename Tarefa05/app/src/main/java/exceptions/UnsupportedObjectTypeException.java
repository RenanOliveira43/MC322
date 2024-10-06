package exceptions;

public class UnsupportedObjectTypeException extends RuntimeException {

    public UnsupportedObjectTypeException(String message) {
        super(message);
    }

    public UnsupportedObjectTypeException(String message, Throwable cause) {
        super(message, cause);
    }
}
