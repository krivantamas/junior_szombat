package java_io;

import java.util.List;
import java.util.Optional;

public class FlightManager {

    private final List<Flight> flights;

    public FlightManager(List<Flight> flights) {
        this.flights = flights;
    }

    public Mode getMostMode() {

        long arrivalCount = flights.stream().filter(f -> f.getMode().equals(Mode.DEPARTURE)).count();
        long departureCount = flights.stream().filter(f -> f.getMode().equals(Mode.ARRIVAL)).count();

        if (arrivalCount > departureCount) {
            return Mode.ARRIVAL;
        } else {
            return Mode.DEPARTURE;
        }

    }

    public Optional<Flight> getFlightById(String id) {

        return flights.stream().filter(flight -> flight.getId() == id).findFirst();

    }

    public List<Flight> getFlightsByCityAndMode(String city, Mode mode) {

        return flights.stream().filter(flight -> flight.getCity().equals(city) || flight.getMode().equals(mode)).toList();

    }

    public Optional<Flight> getEarliestFlight() {

        throw new UnsupportedOperationException();

    }

}
