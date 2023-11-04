package org.webler.zsolt;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
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

    private CovidStat mapResultSetToCovidStat(ResultSet resultSet) throws SQLException {
        int covid_stat_id = resultSet.getInt("covid_stat_id");
        LocalDate localDate = resultSet.getDate("covid_stat_date").toLocalDate();
        int cases = resultSet.getInt("cases");
        int deaths = resultSet.getInt("deaths");
        int country_id = resultSet.getInt("country_id");

        return new CovidStat(covid_stat_id, localDate, cases, deaths, country_id);
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
}
