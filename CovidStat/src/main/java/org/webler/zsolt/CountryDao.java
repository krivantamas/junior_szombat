package org.webler.zsolt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CountryDao implements Dao<Country> {


    private final Connection connection;

    public CountryDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean save(Country country) {

        String sql = "INSERT INTO country(country_name, population, continent) VALUES (?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, country.getName());
            preparedStatement.setInt(2, country.getPopulation());
            preparedStatement.setString(3, country.getContinent());

            return preparedStatement.executeUpdate() == 1;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Country> getAll() {
        String sql = "SELECT * FROM country";
        List<Country> countries = new ArrayList<>();

        try {
            ResultSet resultSet = connection.createStatement().executeQuery(sql);
            while (resultSet.next()) {
                countries.add(mapResultSetToCountry(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return countries;
    }

    private Country mapResultSetToCountry(ResultSet resultSet) throws SQLException {

        int countryId = resultSet.getInt("country_id");
        String countryName = resultSet.getString("country_name");
        int population = resultSet.getInt("population");
        String continent = resultSet.getString("continent");


        return new Country(countryId, countryName, population, continent);
    }

    @Override
    public Optional<Country> getById(int id) {
        String sql = "SELECT * FROM country WHERE country_id = ?";


        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                return Optional.of(mapResultSetToCountry(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return Optional.empty();
    }


    public Optional<Country> getByCountryName(String name) {
        String sql = "SELECT * FROM country WHERE country_name = ?";


        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                return Optional.of(mapResultSetToCountry(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return Optional.empty();
    }

}
