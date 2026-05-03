package airline;

import java.util.Date;
import java.util.List;


public interface FlightApiClient {
    List<Airline> fetchFlights(String airlineName, String origin, String destination, Date date);
}

