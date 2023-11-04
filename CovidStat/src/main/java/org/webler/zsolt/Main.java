package org.webler.zsolt;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Set<Country> countries = new HashSet<>();
        List<CovidStat> stats = new ArrayList<>();

        CountryDao countryDao = new CountryDao(new Database().getConnection());

        Map<String, Integer> countryMap = countryDao.getAll().stream().collect(Collectors.toMap(Country::getName, Country::getId));

        try {
            Scanner scanner = new Scanner(new File("src/main/resources/data_2.csv"));
            scanner.nextLine(); // Skip headers

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] values = line.split(";");
                try {
                    countries.add(new Country(values[6].replace("_", " "), Integer.parseInt(values[9]), values[10]));

                    stats.add(new CovidStat(
                            LocalDate.of(
                                    Integer.parseInt(values[3]), //Ev
                                    Integer.parseInt(values[2]), //Honap
                                    Integer.parseInt(values[1])), //Nap
                            Integer.parseInt(values[4]), //Esetek
                            Integer.parseInt(values[5]), //Halálok
                            countryDao.getByCountryName(
                                values[6].replace("_", " ")).orElseThrow().getId() //Country id
                            //countryMap.get(values[6].replace("_", " "))
                    ));

                } catch (NumberFormatException e) {

                }

            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        for (Country country : countryDao.getAll()) {
            //System.out.println(country);
        }

        System.out.println();
    }
}