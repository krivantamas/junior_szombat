package org.webler.zsolt;

import java.io.File;
import java.sql.Connection;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        ResourceParser resourceParser = new ResourceParser(new File("src/main/resources/data_2.csv"));

        Set<Country> countries = resourceParser.fetchCountriesFromResource();
        List<CovidStat> stats = resourceParser.fetchCovidStatsFromResource();

        Connection connection = new Database().getConnection();

        CovidStatDao covidStatDao = new CovidStatDao(connection);
        CountryDao countryDao = new CountryDao(connection);

        /*
        InitDatabaseService initDatabaseService = new InitDatabaseService(covidStatDao, countryDao);
        initDatabaseService.initDatabase(countries, stats);
        */

        AggregatorService aggregatorService = new AggregatorService(covidStatDao, countryDao);
        System.out.println(aggregatorService.mostDeaths());
        System.out.println(aggregatorService.mostDeadlyCountry());
        System.out.println(aggregatorService.mostDeadlyCountryNormalizedWithPopulation());

        //System.out.println(aggregatorService.covidStatsByContinents());
        System.out.println(aggregatorService.covidStatsByCountries());
        System.out.println(aggregatorService.getCovidStatBetween(LocalDate.parse("2020-12-07"),LocalDate.parse("2020-12-14")));

    }
}