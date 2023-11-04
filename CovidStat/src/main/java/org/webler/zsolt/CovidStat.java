package org.webler.zsolt;

import java.time.LocalDate;
import java.util.Objects;

public class CovidStat {

    private int id;
    private final LocalDate date;
    private final int cases;
    private final int deaths;
    private int countryId;
    private String countryName;

    public CovidStat(LocalDate date, int cases, int deaths, int countryId) {
        this.id = -1;
        this.date = date;
        this.cases = cases;
        this.deaths = deaths;
        this.countryId = countryId;
    }

    public CovidStat(int id, LocalDate date, int cases, int deaths, int countryId) {
        this.id = id;
        this.date = date;
        this.cases = cases;
        this.deaths = deaths;
        this.countryId = countryId;
    }
    public CovidStat( LocalDate date, int cases, int deaths, String countryName) {
        this.id = -1;
        this.date = date;
        this.cases = cases;
        this.deaths = deaths;
        this.countryId = -1;
        this.countryName = countryName;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getCases() {
        return cases;
    }

    public int getDeaths() {
        return deaths;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public String getCountryName() {
        return countryName;
    }

    @Override
    public String toString() {
        return "CovidStat{" +
                "id=" + id +
                ", date=" + date +
                ", cases=" + cases +
                ", deaths=" + deaths +
                ", countryId=" + countryId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CovidStat covidStat = (CovidStat) o;
        return id == covidStat.id && cases == covidStat.cases && deaths == covidStat.deaths && countryId == covidStat.countryId && Objects.equals(date, covidStat.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, cases, deaths, countryId);
    }
}
