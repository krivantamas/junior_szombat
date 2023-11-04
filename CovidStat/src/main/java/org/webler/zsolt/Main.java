package org.webler.zsolt;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Set<Country> countries = new HashSet<>();
        List<CovidStat> stats = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(new File("src/main/resources/data_2.csv"));
            scanner.nextLine(); // Skip headers

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] values = line.split(";");
                try {
                    countries.add(new Country(values[6].replace("_"," "), Integer.parseInt(values[9]), values[10]));
                } catch (NumberFormatException e) {

                }

            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        System.out.println();
    }
}