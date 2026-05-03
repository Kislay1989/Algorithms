package parkingLot;

public class CompactSpot implements ParkingSpot {

    private final int spotNumber;
    private Vehicle vehicle;

    public CompactSpot(int spotNumber) {
        this.spotNumber = spotNumber;
        this.vehicle = null;
    }

    @Override
    public int getSpotNumber() {
        return this.spotNumber;
    }

    @Override
    public boolean isAvailable() {
        return vehicle == null;
    }

    @Override
    public void occupy(Vehicle vehicle) {
        if (isAvailable() && vehicle.getSize() == VehicleSize.SMALL) {
            this.vehicle = vehicle;
        } else {
            throw new IllegalStateException("Spot is not available or vehicle size is not compatible.");
        }
    }

    @Override
    public void vacate() {
        this.vehicle = null;
    }

    @Override
    public VehicleSize getSize() {
        return VehicleSize.SMALL;
    }
}
