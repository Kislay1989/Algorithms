package parkingLot;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static parkingLot.VehicleSize.*;

/**
 * This is the Facade class that provides a simplified interface to the complex parking lot system by acting as orchestrator.
 * It manages the parking lot, handles vehicle entry and exit, and calculates parking fees using the appropriate fare strategy.
 */
public class ParkingLot {

    private final ParkingManager parkingManager;
    private final FareStrategy fareStrategy;


    public ParkingLot(FareStrategy fareStrategy) {
        this.parkingManager = ParkingManager.getInstance();
        setAvailableSpots();
        this.fareStrategy = fareStrategy;
    }

    private void setAvailableSpots() {
        parkingManager.getAvailableSpots().put(SMALL, new ArrayList<>(100));
        parkingManager.getAvailableSpots().put(MEDIUM, new ArrayList<>(100));
        parkingManager.getAvailableSpots().put(LARGE, new ArrayList<>(100));
    }

    public Ticket enterVehicle(Vehicle vehicle) {
        ParkingSpot spot = parkingManager.parkVehicle(vehicle);
        if (spot != null) {
            return new Ticket(generateTicketId(), vehicle, spot, LocalDateTime.now());
        } else {
            System.out.println("No available parking spot for vehicle: " + vehicle.getLicensePlate());
            return null;
        }
    }

    public void leaveVehicle(Ticket ticket) {
        parkingManager.unParkVehicle(ticket.getVehicle());
        FareCalculator fareCalculator = new FareCalculator(fareStrategy);
        System.out.println("Parking fee for ticket " + ticket.getTicketID() + ": " + fareCalculator.calculateFare(ticket));
    }

    private String generateTicketId() {
        return "TICKET-" + System.currentTimeMillis();
    }

    public ParkingManager getParkingManager() {
        return parkingManager;
    }

    public FareStrategy getFareStrategy() {
        return fareStrategy;
    }
}
