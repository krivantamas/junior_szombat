package org.webler.zsolt;

public class AggregatorService {

    private final CovidStatDao covidStatDao;
    private final CountryDao countryDao;

    public AggregatorService(CovidStatDao covidStatDao, CountryDao countryDao) {
        this.covidStatDao = covidStatDao;
        this.countryDao = countryDao;
    }



    // TODO HÁZI
    //  Melyik nap haltak meg a legtöbben
    //  Melyik országban volt a legtöbb halott
    //  Melyik országban volt a legtöbb halott a népességhez viszonyítva
    //  Covid esetek kontinensenként (MAP)
    //  Két időpont között az összess covid statot
    //  Összes covid eset országonként (MAP)





}
