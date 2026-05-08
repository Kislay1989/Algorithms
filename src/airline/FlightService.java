package airline;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

public class FlightService {

    private final FlightApiClient flightApiClient;

    private final List<String> supportedAirlines = List.of(
            "IndiGo",
            "AirIndia",
            "SpiceJet",
            "Vistara"
    );

    public FlightService(FlightApiClient flightApiClient) {
        this.flightApiClient = flightApiClient;
    }

    public List<Airline> getAirlines2(Date date, String origin, String destination) {
        int size = supportedAirlines.size();
        ExecutorService executors = Executors.newFixedThreadPool(size);
        List<FlightTask> tasks = new ArrayList<>();

        try {
            for (String airLine : supportedAirlines) {
                FlightTask task = new FlightTask(date, origin, destination, airLine, flightApiClient);
                tasks.add(task);
            }

            List<Airline> result = new ArrayList<>();

            try {
                List<Future<List<Airline>>> futures = executors.invokeAll(tasks);
                for (Future<List<Airline>> future : futures) {
                    try {
                        List<Airline> flights = future.get(2, TimeUnit.SECONDS);
                        if (flights != null && !flights.isEmpty()) {
                            result.addAll(flights);
                        }
                    } catch (ExecutionException e) {
                        System.err.println("Failed to fetch flights from one airline: " + e.getCause());
                    } catch (TimeoutException e) {
                        throw new RuntimeException(e);
                    }
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            return result;
        } finally {
            executors.shutdown();
        }
    }

    public List<Airline> getAirlines(Date date, String origin, String destination) {
        int airlineCount = supportedAirlines.size();


        ExecutorService executorService = Executors.newFixedThreadPool(airlineCount);

        List<Future<List<Airline>>> futures = new ArrayList<>();

        try {
            for (String airlineName : supportedAirlines) {
                FlightTask task = new FlightTask(date, origin, destination, airlineName, flightApiClient);
                futures.add(executorService.submit(task));
            }

            List<Airline> result = new ArrayList<>();

            for (Future<List<Airline>> future : futures) {
                try {
                    List<Airline> flights = future.get();

                    if (flights != null && !flights.isEmpty()) {
                        result.addAll(flights);
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    throw new RuntimeException("Thread interrupted while fetching flights", e);
                } catch (ExecutionException e) {
                    System.err.println("Failed to fetch flights from one airline: " + e.getCause());
                }
            }

            return result;
        } finally {
            executorService.shutdown();
        }
    }
}
