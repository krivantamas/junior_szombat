package org.webler.zsolt;

import java.io.File;
import java.sql.Connection;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        ResourceParser resourceParser = new ResourceParser(new File("src/main/resources/data_2.csv"));

        Set<Country> countries = resourceParser.fetchCountriesFromResource();
        List<CovidStat> stats = resourceParser.fetchCovidStatsFromResource();

        Connection connection = new Database().getConnection();

        InitDatabaseService initDatabaseService = new InitDatabaseService(
                new CovidStatDao(connection),
                new CountryDao(connection));

        initDatabaseService.initDatabase(countries, stats);

    }
}