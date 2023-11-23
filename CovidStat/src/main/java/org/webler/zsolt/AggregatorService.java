package org.webler.zsolt;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class AggregatorService {

    private final CovidStatDao covidStatDao;
    private final CountryDao countryDao;

    public AggregatorService(CovidStatDao covidStatDao, CountryDao countryDao) {
        this.covidStatDao = covidStatDao;
        this.countryDao = countryDao;
    }


    public Optional<LocalDate> mostDeaths() {
        return covidStatDao.mostDeath();
    }

    public Optional<Country> mostDeadlyCountry() {
        int countryId = covidStatDao.getMostDeadlyCountryId();
        return countryDao.getById(countryId);
    }

    public Optional<Country> mostDeadlyCountryNormalizedWithPopulation() {
        int countryId = covidStatDao.getMostDeadlyCountryIdNormalizedByPopulation();
        return countryDao.getById(countryId);
    }

    public Map<String, List<CovidStat>> covidStatsByContinents() {

        Map<String, List<CovidStat>> covidStatsByContinents = new HashMap<>();

        for (String continent : countryDao.getContinents()) {
            covidStatsByContinents.put(continent, covidStatDao.getCovidStatsByContinent(continent));
        }
        return covidStatsByContinents;
    }


    public List<CovidStat> getCovidStatBetween(LocalDate from, LocalDate to) {
        return covidStatDao.getCovidStatsBetween(from, to);
    }

    public Map<String, List<CovidStat>> covidStatsByCountries() {
        Map<String, List<CovidStat>> covidStatsByCountries = new HashMap<>();

        List<CovidStat> covidStats = covidStatDao.getAll();

        for (Country country : countryDao.getAll()) {

            covidStatsByCountries.put(country.getName(), covidStats.stream()
                    .filter(covidStat -> covidStat.getCountryId() == country.getId())
                    .toList());
        }


        var countryMap = countryDao.getAll().stream()
                .collect(Collectors.groupingBy(country -> country.getId()));
        var covidStatMap = covidStats.stream()
                .collect(Collectors.groupingBy(covidStat -> countryMap.get(covidStat.getCountryId()).get(0).getName()));

        return covidStatsByCountries;
    }

}
