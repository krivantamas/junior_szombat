package java_io;

import java.time.LocalTime;
import java.util.Objects;

public class Flight {

    private final String id;
    private final Mode mode;
    private final String city;
    private final LocalTime time;

    public Flight(String id, Mode mode, String city, LocalTime time) {
        this.id = id;
        this.mode = mode;
        this.city = city;
        this.time = time;
    }

    public String getId() {
        return id;
    }

    public Mode getMode() {
        return mode;
    }

    public String getCity() {
        return city;
    }

    public LocalTime getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "id='" + id + '\'' +
                ", mode=" + mode +
                ", city='" + city + '\'' +
                ", time=" + time +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return Objects.equals(id, flight.id) && mode == flight.mode && Objects.equals(city, flight.city) && Objects.equals(time, flight.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, mode, city, time);
    }
}
