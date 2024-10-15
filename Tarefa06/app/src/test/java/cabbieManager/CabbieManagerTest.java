/*
 * This source file was generated by the Gradle 'init' task
 */
package cabbieManager;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import databaseManager.Database;

import static org.junit.jupiter.api.Assertions.*;

import java.io.StringWriter;
import java.time.LocalDateTime;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.crypto.Data;

import org.junit.jupiter.api.Assertions;

public class CabbieManagerTest {

    private Passenger pass = new Passenger();
    private Ride ride = new Ride(this.pass);

    @Test
    public void testCalculateDistance_SameLocations() {
        // Arrange
        pass.register();
        ride = new Ride(pass);
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
        ride = new Ride(pass);
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
        ride = new Ride(pass);
        ride.setPickupLocation(Location.HOSPITAL);
        ride.setDropLocation(Location.ESTACAO_DE_TREM);

        // Act
        float distance = ride.calculateDistance();

        // Assert
        assertEquals(4.24f, distance, 0);
    }

    @Test
    public void testDiurnalRideWithinRange() {
        RidePayment ridePayment = new RidePayment(ride, LocalDateTime.of(2022, 1, 1, 10, 0), 5.0f, "Dinheiro");
        Assertions.assertEquals(15.00f, ridePayment.calculateValue(), 0);
    }

    @Test
    public void testDiurnalRideWithinRange2() {
        RidePayment ridePayment = new RidePayment(ride, LocalDateTime.of(2022, 1, 1, 10, 0), 18.0f, "Cartão de Débito");
        Assertions.assertEquals(78f, ridePayment.calculateValue(), 0);
    }

    @Test
    public void testNocturnalRideWithinRange() {
        RidePayment ridePayment = new RidePayment(ride, LocalDateTime.of(2022, 1, 1, 20, 0), 5.0f, "Dinheiro");
        Assertions.assertEquals(18.50f, ridePayment.calculateValue(), 0);
    }

    @Test
    public void testCabbieMarshaller(){
        Cabbie cabbie = new Cabbie();
        cabbie.register();
        Assertions.assertDoesNotThrow(()->{
            JAXBContext context = JAXBContext.newInstance(Cabbie.class);
            Marshaller marshaller = context.createMarshaller();
            StringWriter sw = new StringWriter();
            marshaller.marshal(cabbie, sw);
        });
    }
    @Test
    public void testPassengerMarshaller(){
        Passenger pas = new Passenger();
        pas.register();
        Assertions.assertDoesNotThrow(()->{
            JAXBContext context = JAXBContext.newInstance(Passenger.class);
            Marshaller marshaller = context.createMarshaller();
            StringWriter sw = new StringWriter();
            marshaller.marshal(pas, sw);
        });
    }
    @Test
    public void testVehicleMarshaller(){
        Vehicle vehicle = new Vehicle();
        vehicle.registerVehicle();
        Assertions.assertDoesNotThrow(()->{
            JAXBContext context = JAXBContext.newInstance(Vehicle.class);
            Marshaller marshaller = context.createMarshaller();
            StringWriter sw = new StringWriter();
            marshaller.marshal(vehicle, sw);
        });
    }
    @Test
    public void testCreateBusinessPassenger() {
        // Arrange
        BusinessPassenger businessPassenger = new BusinessPassenger();

        // Act
        businessPassenger.register();

        // Assert
        assertNotNull(businessPassenger);
    }

    @Test
    public void testCreateVIPPassenger() {
        // Arrange
        VIPPassenger vipPassenger = new VIPPassenger();

        // Act
        vipPassenger.register();

        // Assert
        assertNotNull(vipPassenger);
    }
    @Test
    public void testRideAggregationWithPassenger() {
        // Arrange
        Passenger passenger = new Passenger();
        passenger.register();
        Ride ride = new Ride(passenger);

        // Act
        Passenger associatedPassenger = ride.getPassenger();

        // Assert
        assertNotNull(associatedPassenger);
        assertEquals(passenger, associatedPassenger);
    }

    @Test
    public void testRideCompositionWithVehicle() {
        // Arrange
        Vehicle vehicle = new Vehicle();
        vehicle.registerVehicle();
        Ride ride = new Ride(pass);
        ride.setVehicle(vehicle);

        // Act
        Vehicle associatedVehicle = ride.getVehicle();

        // Assert
        assertNotNull(associatedVehicle);
        assertEquals(vehicle, associatedVehicle);
    }

    @Test
    public void testRideCompositionWithCabbie() {
        // Arrange
        Cabbie cabbie = new Cabbie();
        cabbie.register();
        Ride ride = new Ride(pass);
        ride.setCabbie(cabbie);

        // Act
        Cabbie associatedCabbie = ride.getCabbie();

        // Assert
        assertNotNull(associatedCabbie);
        assertEquals(cabbie, associatedCabbie);
    }


}