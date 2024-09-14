/*
 * This source file was generated by the Gradle 'init' task
 */
package cabbieManager;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Assertions;

public class CabbieManagerTest {

    private Ride ride;

    @Test
    public void testCalculateDistance_SameLocations() {
        // Arrange
        ride = new Ride("testPassengerId");
        ride.setPickupLocation(Location.AEROPORTO);
        ride.setDropLocation(Location.AEROPORTO);

        // Act
        float distance = ride.calculateDistance();

        // Assert
        assertEquals(0, distance, 0);
    }

    @Test
    public void testCalculateDistance_DifferentLocations1() {
        // Arrange
        ride = new Ride("testPassengerId");
        ride.setPickupLocation(Location.AEROPORTO);
        ride.setDropLocation(Location.ESTADIO);

        // Act
        float distance = ride.calculateDistance();

        // Assert
        assertEquals(18.38f, distance, 0);
    }


    @Test
    public void testCalculateDistance_DifferentLocations2() {
        // Arrange
        ride = new Ride("testPassengerId");
        ride.setPickupLocation(Location.HOSPITAL);
        ride.setDropLocation(Location.ESTACAO_DE_TREM);

        // Act
        float distance = ride.calculateDistance();

        // Assert
        assertEquals(4.24f, distance, 0);
    }

    @Test
    public void testDiurnalRideWithinRange() {
        RidePayment ridePayment = new RidePayment("rideId", LocalDateTime.of(2022, 1, 1, 10, 0), 5.0f, "Cash");
        Assertions.assertEquals(15.00f, ridePayment.calculateValue(), 0);
    }

    @Test
    public void testDiurnalRideWithinRange2() {
        RidePayment ridePayment = new RidePayment("rideId", LocalDateTime.of(2022, 1, 1, 10, 0), 18.0f, "Debit Card");
        Assertions.assertEquals(78f, ridePayment.calculateValue(), 0);
    }

    @Test
    public void testNocturnalRideWithinRange() {
        RidePayment ridePayment = new RidePayment("rideId", LocalDateTime.of(2022, 1, 1, 20, 0), 5.0f, "Cash");
        Assertions.assertEquals(18.50f, ridePayment.calculateValue(), 0);
    }

    @Test
    public void testNocturnalRideWithinRange2() {
        RidePayment ridePayment = new RidePayment("rideId", LocalDateTime.of(2022, 1, 1, 20, 0), 22.0f, "Voucher");
        Assertions.assertEquals(94.25f, ridePayment.calculateValue(), 0);
    }
}