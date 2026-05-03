package parkingLot;

import java.math.BigDecimal;

public class FareCalculator {

    private final FareStrategy fareStrategy;

    public FareCalculator(FareStrategy fareStrategy) {
        this.fareStrategy = fareStrategy;
    }

    public BigDecimal calculateFare(Ticket ticket) {
        BigDecimal duration = ticket.calculateParkingDuration();
        return fareStrategy.calculateFare(ticket, duration);
    }

    public FareStrategy getFareStrategies() {
        return fareStrategy;
    }
}
