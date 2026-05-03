package airline;

import java.util.Date;

public class Airline {

    private String airlineName;
    private String flightNumber;
    private String origin;
    private String destination;
    private Date departureTime;
    private Date arrivalTime;
    private double price;

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
