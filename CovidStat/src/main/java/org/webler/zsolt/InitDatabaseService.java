package org.webler.zsolt;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public class InitDatabaseService {


    private final CovidStatDao covidStatDao;
    private final CountryDao countryDao;


    public InitDatabaseService(CovidStatDao covidStatDao, CountryDao countryDao) {
        this.covidStatDao = covidStatDao;
        this.countryDao = countryDao;
    }


    public void initDatabase(Set<Country> countrySet, List<CovidStat> covidStatList) {

        saveCountries(countrySet);
        saveCovidStats(covidStatList);
    }


    //TODO HÁZI, oldd meg, hogy csak akkor mentse el, ha új ország
    private void saveCountries(Set<Country> countrySet) {
        for (Country country : countrySet) {
            countryDao.save(country);
        }
    }

    private void saveCovidStats(List<CovidStat> covidStatList) {
        for (CovidStat covidStat : covidStatList) {
            Optional<Country> countryName = countryDao.getByCountryName(
                    covidStat.getCountryName());
            if(countryName.isPresent()){
                covidStat.setCountryId(countryName.get().getId());
                covidStatDao.save(covidStat);
            }
        }
    }

}
