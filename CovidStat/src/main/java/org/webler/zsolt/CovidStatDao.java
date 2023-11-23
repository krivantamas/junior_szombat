package org.webler.zsolt;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class CovidStatDao implements Dao<CovidStat> {

    private final Connection connection;

    public CovidStatDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean save(CovidStat covidStat) {
        String sql = "INSERT INTO covid_stat(covid_stat_date, cases, deaths, country_id) VALUES (?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setDate(1, Date.valueOf(covidStat.getDate()));
            preparedStatement.setInt(2, covidStat.getCases());
            preparedStatement.setInt(3, covidStat.getDeaths());
            preparedStatement.setInt(4, covidStat.getCountryId());

            return preparedStatement.executeUpdate() == 1;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<CovidStat> getAll() {
        String sql = "SELECT * FROM covid_stat";
        List<CovidStat> stats = new ArrayList<>();

        try {
            ResultSet resultSet = connection.createStatement().executeQuery(sql);
            while (resultSet.next()) {
                stats.add(mapResultSetToCovidStat(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return stats;
    }

    @Override
    public Optional<CovidStat> getById(int id) {
        String sql = "SELECT * FROM covid_stat WHERE covid_stat_id = ?";


        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                return Optional.of(mapResultSetToCovidStat(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return Optional.empty();
    }

    public Optional<LocalDate> mostDeath() {
        String sql = "SELECT covid_stat_date FROM covid_stat GROUP BY covid_stat_date ORDER BY SUM(deaths) DESC LIMIT 1";
        try {
            ResultSet resultSet = connection.createStatement().executeQuery(sql);
            while (resultSet.next()) {
                Date date = resultSet.getDate(1);
                return Optional.of(date.toLocalDate());
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.empty();

    }

    public int getMostDeadlyCountryId() {
        String sql = "SELECT country_id FROM covid_stat GROUP BY country_id ORDER BY SUM(deaths) DESC LIMIT 1";
        try {
            ResultSet resultSet = connection.createStatement().executeQuery(sql);
            while (resultSet.next()) {
                return resultSet.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        throw new NoSuchElementException();

    }

    public int getMostDeadlyCountryIdNormalizedByPopulation() {
        String sql = "SELECT country_id FROM COUNTRY WHERE country_id = (SELECT covid_stat.country_id FROM covid_stat INNER JOIN country ON covid_stat.country_id = country.country_id GROUP BY covid_stat.country_id ORDER BY SUM(1.0 * deaths/country.population) DESC LIMIT 1)";
        try {
            ResultSet resultSet = connection.createStatement().executeQuery(sql);
            while (resultSet.next()) {
                return resultSet.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        throw new NoSuchElementException();

    }

    public List<CovidStat> getCovidStatsByContinent(String continent) {
        String sql = "SELECT covid_stat.* FROM covid_stat INNER JOIN country ON covid_stat.country_id = country.country_id WHERE country.continent = ?";
        List<CovidStat> stats = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, continent);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                stats.add(mapResultSetToCovidStat(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return stats;
    }

    public List<CovidStat> getCovidStatsBetween(LocalDate from, LocalDate to) {
        String sql = "SELECT * FROM covid_stat WHERE covid_stat_date BETWEEN ? AND ?";
        List<CovidStat> stats = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setDate(1, Date.valueOf(from));
            preparedStatement.setDate(2, Date.valueOf(to));
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                stats.add(mapResultSetToCovidStat(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return stats;
    }


    private CovidStat mapResultSetToCovidStat(ResultSet resultSet) throws SQLException {
        int covid_stat_id = resultSet.getInt("covid_stat_id");
        LocalDate localDate = resultSet.getDate("covid_stat_date").toLocalDate();
        int cases = resultSet.getInt("cases");
        int deaths = resultSet.getInt("deaths");
        int country_id = resultSet.getInt("country_id");

        return new CovidStat(covid_stat_id, localDate, cases, deaths, country_id);
    }


}
