package java_database.repository;

import java_database.Database;
import java_database.model.MovieDao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MovieRepository {

    private final Connection connection = new Database().getConnection();

    public List<MovieDao> getAll() {

        String sql = "SELECT * FROM Movie";
        List<MovieDao> movies = new ArrayList<>();

        try {
            var preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();


            while (resultSet.next()) {


                movies.add(getMovieFromResultSet(resultSet));

            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return movies;
    }

    public MovieDao getById(int id) {
        String sql = "SELECT * FROM Movie where movie.movie_id = ?";

        try {
            var preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();


            while (resultSet.next()) {
                return getMovieFromResultSet(resultSet);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return null;
    }

    public void save(MovieDao movie) {
        String sql = "INSERT INTO Movie (movie_name,movie_imdb_score,movie_category_id) VALUES (?, ?, ?)";

        try {
            var preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, movie.getMovieName());
            preparedStatement.setDouble(2, movie.getImdbScore());
            preparedStatement.setInt(3, movie.getCategoryId());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    private MovieDao getMovieFromResultSet(ResultSet resultSet) throws SQLException {
        int movieId = resultSet.getInt("movie_id");
        String movieName = resultSet.getString("movie_name");
        double imdbScore = resultSet.getDouble("movie_imdb_score");
        int categoryId = resultSet.getInt("movie_category_id");

        return new MovieDao(movieId, movieName, imdbScore, categoryId);
    }
}
