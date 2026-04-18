package parkingLot.dao;

import java.util.ArrayList;
import java.util.List;

public class ParkingFloor {

    private final String floorId;
    private final List<ParkingSpot> spots;

    public ParkingFloor(String floorId) {
        this.floorId = floorId;
        this.spots = new ArrayList<>();
    }

    public String getFloorId() {
        return floorId;
    }

    public List<ParkingSpot> getSpots() {
        return spots;
    }

    public void addSpot(ParkingSpot spot) {
        spots.add(spot);
    }

}
