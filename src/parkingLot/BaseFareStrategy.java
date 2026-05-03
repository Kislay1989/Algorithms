package parkingLot;

import java.math.BigDecimal;

public class BaseFareStrategy implements FareStrategy {

    private static final BigDecimal SMALL_VEHICLE_RATE = new BigDecimal("1.0");
    private static final BigDecimal MEDIUM_VEHICLE_RATE = new BigDecimal("2.0");
    private static final BigDecimal LARGE_VEHICLE_RATE = new BigDecimal("3.0");

    @Override
    public BigDecimal calculateFare(Ticket ticket, BigDecimal duration) {
        VehicleSize vehicleSize = ticket.getVehicle().getSize();
        switch (vehicleSize) {
            case SMALL:
                return duration.multiply(SMALL_VEHICLE_RATE);
            case MEDIUM:
                return duration.multiply(MEDIUM_VEHICLE_RATE);
            case LARGE:
                return duration.multiply(LARGE_VEHICLE_RATE);
            default:
                throw new IllegalArgumentException("Unknown vehicle size: " + vehicleSize);
        }
    }
}
