package movieTicketBooking.service;

import java.math.BigDecimal;

public interface PricingStrategy {
    BigDecimal getPrice();
}
