package exceptions;

/**
 * Exception thrown when an unsupported object type is encountered.
 * <p>
 * This exception is used to indicate that an operation was attempted on an object type that is not supported 
 * by the system. It extends {@code RuntimeException}, allowing it to be thrown during runtime without requiring 
 * explicit declaration in method signatures.
 * </p>
 * 
 * @see RuntimeException
 */
public class UnsupportedObjectTypeException extends RuntimeException {

    /**
     * Constructs a new {@code UnsupportedObjectTypeException} with the specified detail message.
     * 
     * @param message The detail message explaining the reason for the exception.
     */
    public UnsupportedObjectTypeException(String message) {
        super(message);
    }

    /**
     * Constructs a new {@code UnsupportedObjectTypeException} with the specified detail message 
     * and cause.
     * 
     * @param message The detail message explaining the reason for the exception.
     * @param cause   The cause of the exception (can be {@code null}).
     */
    public UnsupportedObjectTypeException(String message, Throwable cause) {
        super(message, cause);
    }
}

