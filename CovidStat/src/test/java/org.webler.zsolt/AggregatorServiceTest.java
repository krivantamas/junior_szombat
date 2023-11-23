package org.webler.zsolt;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

//TODO Test all method
public class AggregatorServiceTest {

    @Test
    public void mockTest() {

        Country expectedCountry = new Country("Hungary", 0, "Europe");

        CountryDao countryDaoMock = Mockito.mock(CountryDao.class);
        CovidStatDao covidStatDaoMock = Mockito.mock(CovidStatDao.class);

        Mockito.when(covidStatDaoMock.getMostDeadlyCountryId()).thenReturn(5);
        Mockito.when(countryDaoMock.getById(5)).thenReturn(Optional.of(expectedCountry));

        AggregatorService aggregatorService = new AggregatorService(covidStatDaoMock, countryDaoMock);

        Optional<Country> country = aggregatorService.mostDeadlyCountry();

        Assertions.assertEquals(expectedCountry, country.get());
        Mockito.verify(countryDaoMock).getById(5);

    }

    @Test
    public void covidStatsByContinentsTest() {

        CountryDao countryDaoMock = Mockito.mock(CountryDao.class);
        CovidStatDao covidStatDaoMock = Mockito.mock(CovidStatDao.class);

        List<String> listOfContinents = List.of("Europe", "Asia");
        List<CovidStat> covidStatsEurope = List.of(new CovidStat(1, LocalDate.of(2020, 11, 20), 10, 2, 1));
        List<CovidStat> covidStatsAsia = List.of(new CovidStat(2, LocalDate.of(2020, 11, 20), 10, 2, 2),
                new CovidStat(3, LocalDate.of(2020, 11, 20), 10, 2, 3));

        Mockito.when(countryDaoMock.getContinents()).thenReturn(listOfContinents);
        Mockito.when(covidStatDaoMock.getCovidStatsByContinent("Europe")).thenReturn(covidStatsEurope);
        Mockito.when(covidStatDaoMock.getCovidStatsByContinent("Asia")).thenReturn(covidStatsAsia);

        AggregatorService aggregatorService = new AggregatorService(covidStatDaoMock, countryDaoMock);

        HashMap<String, List<CovidStat>> expectedMap = new HashMap<>();
        expectedMap.put("Europe", covidStatsEurope);
        expectedMap.put("Asia", covidStatsAsia);

        Map<String, List<CovidStat>> actualMap = aggregatorService.covidStatsByContinents();

        Assertions.assertEquals(expectedMap, actualMap);

    }


}
