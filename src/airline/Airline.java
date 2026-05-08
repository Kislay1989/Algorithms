package airline;

import java.util.Date;

public class Airline {

    private final String airlineName;
    private final String flightNumber;
    private final String origin;
    private final String destination;
    private final Date departureTime;
    private final Date arrivalTime;
    private final double price;

    public Airline(String airlineName, String flightNumber, String origin, String destination, Date departureTime, Date arrivalTime, double price) {
        this.airlineName = airlineName;
        this.flightNumber = flightNumber;
        this.origin = origin;
        this.destination = destination;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.price = price;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }

    public double getPrice() {
        return price;
    }
}
