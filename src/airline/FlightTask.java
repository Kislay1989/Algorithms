package airline;

import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;

public class FlightTask implements Callable<List<Airline>> {

    private final Date date;
    private final String origin;
    private final String destination;
    private final String airlineName;
    private final FlightApiClient flightApiClient;

    public FlightTask(Date date, String origin, String destination, String airlineName, FlightApiClient flightApiClient) {
        this.date = date;
        this.origin = origin;
        this.destination = destination;
        this.airlineName = airlineName;
        this.flightApiClient = flightApiClient;
    }

    @Override
    public List<Airline> call() throws Exception {
        return flightApiClient.fetchFlights(airlineName, origin, destination, date);
    }
}
