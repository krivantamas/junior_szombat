package java_io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {


    }

    public static List<Flight> getFlights() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("W:\\Webler\\JuniorJava\\Git\\java\\Final\\src\\test_exam_1\\java_io\\cities.txt"));
        List<Flight> flights = new ArrayList<>();

        while (scanner.hasNextLine()) {

            String id = scanner.next();
            String arrivalOrDeparture = scanner.next();
            String city = scanner.next();
            String timeAsString = scanner.next();
            String[] split = timeAsString.split(":");

            LocalTime time = LocalTime.parse(String.format("%02d", Integer.parseInt(split[0])) + ":" + String.format("%02d", Integer.parseInt(split[1])));

            flights.add(new Flight(id, arrivalOrDeparture.equals("Departure") ? Mode.DEPARTURE : Mode.ARRIVAL, city, time));


        }
        return flights;
    }
}
