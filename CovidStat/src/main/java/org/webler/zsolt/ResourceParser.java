package org.webler.zsolt;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.*;

public class ResourceParser {

    private final File resourcePath;

    ResourceParser(File resourcePath) {
        this.resourcePath = resourcePath;
    }

    public Set<Country> fetchCountriesFromResource() {
        Set<Country> countries = new HashSet<>();

        try {
            Scanner scanner = new Scanner(resourcePath);
            scanner.nextLine(); // Skip headers

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] values = line.split(";");
                try {
                    countries.add(new Country(values[6].replace("_", " "), Integer.parseInt(values[9]), values[10]));
                } catch (NumberFormatException e) {
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return countries;
    }

    public List<CovidStat> fetchCovidStatsFromResource() {
        List<CovidStat> stats = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(resourcePath);
            scanner.nextLine(); // Skip headers

                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        String[] values = line.split(";");
                        try {
                            stats.add(new CovidStat(
                                    LocalDate.of(
                                            Integer.parseInt(values[3]), //Ev
                                            Integer.parseInt(values[2]), //Honap
                                            Integer.parseInt(values[1])), //Nap
                                    Integer.parseInt(values[4]), //Esetek
                                    Integer.parseInt(values[5]), //Halálok
                                    values[6].replace("_", " ")
                    ));

                } catch (NumberFormatException e) {

                }

            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return stats;
    }


}
