// Renan Neves de Oliveira 257364

package cabbieManager;

import databaseManager.Database;

public class Main {
    public static void main(String[] args) throws Exception {
        //Aqui você deve realizar a simulação do funcionamento do sistema.
        //----------------------------------------------------------------
        Database db = new Database(false);
        
        // Create Instances

        Cabbie cab = new Cabbie();
        cab.register();
        
        Passenger p = new Passenger();
        p.register();

        Vehicle v = new Vehicle(cab.getCabbieId());
        v.registerVehicle();

        // Save Instances into the XML database
        
        db.insert(cab);
        db.insert(p);
        db.insert(v);

        // Update Instances
        cab.update("name", "Martina");
        p.update("name", "Estevão");
        v.updateVehicle("registrationNumber", "ABD123");

        // Save Instances into the XML database
        db.update(cab);
        db.update(p);
        db.update(v);

        // Create Ride
        Ride ride = new Ride(db.getPassengers().get(0).getPassengerId());
        ride.requestRide("Shopping", "Estação de Trem");
        db.insert(ride);

        // Accept Ride
        cab.update("isBusy", "true");
        ride.updateRideStatus("ACEITA", cab.getCabbieId(), v.getVehicleId());
        ride.updateRideStatus("EM_PROGRESSO", null, null);
 
        db.update(ride);
        db.update(cab);

        //Payment
        RidePayment payment = new RidePayment(ride.getRideId(), ride.getStartTime(), ride.getRideDistance(), "Cartão de Crédito");
        payment.processPayment();
        
        db.insert(payment);

        //Finish Ride
        ride.completeRide();
        cab.update("isBusy", "false");

        db.update(ride);
        db.update(cab);

        // Create Ride
        Ride ride_2 = new Ride(db.getPassengers().get(0).getPassengerId());
        ride_2.requestRide("Parque", "Biblioteca");

        db.insert(ride_2);
    
        // Accept Ride
        cab.update("isBusy", "true");
        ride_2.updateRideStatus("ACEITA", cab.getCabbieId(), v.getVehicleId());
        ride_2.updateRideStatus("EM_PROGRESSO", null, null);

        db.update(cab);
        db.update(ride_2);

        //Payment
        RidePayment payment2 = new RidePayment(ride_2.getRideId(), ride_2.getStartTime(), ride_2.getRideDistance(), "Pix");
        payment2.processPayment();

        db.insert(payment2);

        //Finish Ride
        ride_2.completeRide();
        cab.update("isBusy", "false");

        db.update(ride);
        db.update(cab);

        System.out.println("-----------------------------------");
        System.out.println("Fechando e reabrindo banco de dados");

        db = new Database(true);

        System.out.println("Printando dados:");
        System.out.println(db.getPassengers());
        System.out.println(db.getCabbies());
        System.out.println(db.getVehicles());
        System.out.println(db.getRides());
        System.out.println(db.getPaymentMethods());
        
        System.out.println("-----------------------------------");
        System.out.println("Realizando nova corrida:");
        
        Ride ride_3 = new Ride(db.getPassengers().get(0).getPassengerId());
        ride_3.requestRide("Escola", "Hospital");
        db.insert(ride_3);

        // Accept the ride
        cab.update("isBusy", "true");
        ride_3.updateRideStatus("ACEITA", cab.getCabbieId(), v.getVehicleId());
        ride_3.updateRideStatus("EM_PROGRESSO", null, null);

        db.update(cab);
        db.update(ride_3);

        RidePayment payment_3 = new RidePayment(ride_3.getRideId(), ride_3.getStartTime(), ride_3.getRideDistance(), "Cartão de Débito");
        payment_3.processPayment();

        db.insert(payment_3);

        // Finish the new ride
        ride_3.completeRide();
        cab.update("isBusy", "false");

        db.update(ride_3);
        db.update(cab);
    }
}
