package movieTicketBooking.service;

import movieTicketBooking.repo.Movie;
import movieTicketBooking.repo.Screening;
import movieTicketBooking.repo.Seat;
import movieTicketBooking.repo.Ticket;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Manages the relationships between movies, screenings, and tickets in the booking system.
 */
public class ScreeningManager {

    private final Map<Movie, List<Screening>> screeningsByMovie;
    private final Map<Screening, List<Ticket>> ticketsByScreening;

    public ScreeningManager(Map<Movie, List<Screening>> screeningsByMovie, Map<Screening, List<Ticket>> ticketsByScreening) {
        this.screeningsByMovie = screeningsByMovie;
        this.ticketsByScreening = ticketsByScreening;
    }

    public void addScreening(Movie movie, Screening screening) {
        screeningsByMovie.computeIfAbsent(movie, k -> new ArrayList<>()).add(screening);
    }

    // Returns all screenings for a specific movie
    public List<Screening> getScreeningsForMovie(Movie movie) {
        return screeningsByMovie.getOrDefault(movie, new ArrayList<>());
    }

    // Simplified optimistic locking in ScreeningManager
    public synchronized Ticket bookSeatOptimistically(Screening screening, Seat seat) {
        if (isSeatBooked(screening, seat)) {
            throw new IllegalStateException("Seat is already booked");
        }

        BigDecimal price = seat.getPricingStrategy().getPrice();
        Ticket ticket = new Ticket(screening, seat, price);

        // Add to booking system - this effectively "reserves" the seat
        ticketsByScreening.computeIfAbsent(screening, k -> new ArrayList<>()).add(ticket);

        return ticket;
    }

    private boolean isSeatBooked(Screening screening, Seat seat) {
        List<Ticket> tickets = getTicketsForScreening(screening);
        return tickets.stream().anyMatch(ticket -> ticket.getSeat().equals(seat));
    }

    public void addTicket(Screening screening, Ticket ticket) {
        ticketsByScreening.computeIfAbsent(screening, k -> new ArrayList<>()).add(ticket);
    }

    public List<Ticket> getTicketsForScreening(Screening screening) {
        return ticketsByScreening.getOrDefault(screening, new ArrayList<>());
    }

    // Calculates which seats are still available for a screening
    public List<Seat> getAvailableSeats(Screening screening) {
        List<Seat> allSeats = screening.getRoom().getLayout().getAllSeats();
        List<Ticket> bookedTickets = getTicketsForScreening(screening);

        List<Seat> availableSeats = new ArrayList<>(allSeats);
        for (Ticket ticket : bookedTickets) {
            availableSeats.remove(ticket.getSeat());
        }
        return availableSeats;
    }

    public Map<Movie, List<Screening>> getScreeningsByMovie() {
        return screeningsByMovie;
    }

    public Map<Screening, List<Ticket>> getTicketsByScreening() {
        return ticketsByScreening;
    }
}
