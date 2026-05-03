package movieTicketBooking.repo;

import java.time.LocalDateTime;
import java.util.List;

public class Order {

    private final List<Ticket> tickets;
    private final LocalDateTime orderDate;

    public Order(List<Ticket> tickets, LocalDateTime orderDate) {
        this.tickets = tickets;
        this.orderDate = orderDate;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }
}
