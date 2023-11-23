package org.webler.zsolt;

import java.util.Objects;

public class Country {

    private int id;
    private final String name;
    private final int population;
    private final String continent;

    public Country(String name, int population, String continent) {
        this.id = -1;
        this.name = name;
        this.population = population;
        this.continent = continent;
    }

    public Country(int id, String name, int population, String continent) {
        this.id = id;
        this.name = name;
        this.population = population;
        this.continent = continent;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getPopulation() {
        return population;
    }

    public String getContinent() {
        return continent;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", population=" + population +
                ", continent='" + continent + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return id == country.id && population == country.population && Objects.equals(name, country.name) && Objects.equals(continent, country.continent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, population, continent);
    }
}
