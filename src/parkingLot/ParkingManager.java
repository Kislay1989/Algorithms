package parkingLot;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

public class ParkingManager {

    private static ParkingManager instance;

    private final Map<VehicleSize, List<ParkingSpot>> availableSpots;
    private final Map<Vehicle, ParkingSpot> vehicleToSpotMap;

    private final ReentrantLock lock = new ReentrantLock();

    private ParkingManager() {
        this.availableSpots = new HashMap<>();
        this.vehicleToSpotMap = new HashMap<>();
    }

    public static synchronized ParkingManager getInstance() {
        if (instance == null) {
            instance = new ParkingManager();
        }
        return instance;
    }

    public ParkingSpot findParkingSpot(Vehicle vehicle) {
        VehicleSize size = vehicle.getSize();
        for (Map.Entry entry : availableSpots.entrySet()) {
            if (entry.getKey() == size) {
                List<ParkingSpot> spots = (List<ParkingSpot>) entry.getValue();
                for (ParkingSpot spot : spots) {
                    if (spot.isAvailable()) {
                        return spot;
                    }
                }
            }
        }

        return null; // No available spot found
    }

    public ParkingSpot parkVehicle(Vehicle vehicle) {
        lock.lock();
        ParkingSpot parkingSpot = null;
        try {
            parkingSpot = findParkingSpot(vehicle);
            if (parkingSpot != null) {
                parkingSpot.occupy(vehicle);
                vehicleToSpotMap.put(vehicle, parkingSpot);
                availableSpots.get(parkingSpot.getSize()).remove(parkingSpot);

                return parkingSpot;
            }
        } catch (Exception e) {
            return parkingSpot;
        } finally {
            lock.unlock();
        }

        return null;
    }

    public void unParkVehicle(Vehicle vehicle) {
        ParkingSpot parkingSpot = vehicleToSpotMap.get(vehicle);
        if (parkingSpot != null) {
            parkingSpot.vacate();
            vehicleToSpotMap.remove(vehicle);
            availableSpots.get(parkingSpot.getSize()).add(parkingSpot);
        }
    }

    public Map<VehicleSize, List<ParkingSpot>> getAvailableSpots() {
        return availableSpots;
    }

    public Map<Vehicle, ParkingSpot> getVehicleToSpotMap() {
        return vehicleToSpotMap;
    }
}
