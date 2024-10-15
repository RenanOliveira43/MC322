package exceptions;

/**
 * Exception thrown when an invalid ride distance is provided.
 * <p>
 * This exception is used to indicate that the ride distance is invalid, typically when the distance is 
 * less than or equal to zero. It extends {@code RuntimeException}, allowing it to be thrown during runtime 
 * without requiring explicit declaration in method signatures.
 * </p>
 * 
 * @see RuntimeException
 */
public class InvalidRideDistanceException extends RuntimeException {

    /**
     * Constructs a new {@code InvalidRideDistanceException} with the specified detail message.
     * 
     * @param message The detail message explaining the reason for the exception.
     */
    public InvalidRideDistanceException(String message) {
        super(message);
    }

    /**
     * Constructs a new {@code InvalidRideDistanceException} with the specified detail message 
     * and cause.
     * 
     * @param message The detail message explaining the reason for the exception.
     * @param cause   The cause of the exception (can be {@code null}).
     */
    public InvalidRideDistanceException(String message, Throwable cause) {
        super(message, cause);
    }  
}
