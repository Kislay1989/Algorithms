package parkingLot.dao;

public abstract class ParkingSpot {

    private final String spotId;
    private final SpotType spotType;

    private Vehicle currentVehicle;
    private final boolean isOccupied;

    protected ParkingSpot(String spotId, SpotType spotType) {
        this.spotId = spotId;
        this.spotType = spotType;
        this.isOccupied = false;
    }



    public Vehicle getCurrentVehicle() {
        return currentVehicle;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public String getSpotId() {
        return spotId;
    }

    public SpotType getSpotType() {
        return spotType;
    }
}
