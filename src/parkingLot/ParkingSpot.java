package parkingLot;

public interface ParkingSpot {
    int getSpotNumber();

    boolean isAvailable();

    void occupy(Vehicle vehicle);

    void vacate();

    VehicleSize getSize();
}
