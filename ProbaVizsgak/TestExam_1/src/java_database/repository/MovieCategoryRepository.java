package java_database.repository;

import java_database.Database;
import java_database.model.MovieCategoryDao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MovieCategoryRepository {

    private final Connection connection = new Database().getConnection();

    public List<MovieCategoryDao> getAll() {

        String sql = "SELECT * FROM movie_category";
        List<MovieCategoryDao> movieCategories = new ArrayList<>();

        try {
            var preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                movieCategories.add(getMovieCategoryFromResultSet(resultSet));
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return movieCategories;
    }

    public MovieCategoryDao getById(int id) {
        String sql = "SELECT * FROM movie_category where movie_category.movie_category_id = ?";

        try {
            var preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();


            while (resultSet.next()) {
                return getMovieCategoryFromResultSet(resultSet);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return null;
    }

    public void save(MovieCategoryDao movieCategory) {
        String sql = "INSERT INTO movie_category(movie_category_name) VALUES (?)";

        try {
            var preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, movieCategory.getMovieCategoryName());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    private MovieCategoryDao getMovieCategoryFromResultSet(ResultSet resultSet) throws SQLException {
        int movieCategoryId = resultSet.getInt("movie_category_id");
        String movieCategoryName = resultSet.getString("movie_category_name");

        return new MovieCategoryDao(movieCategoryId, movieCategoryName);
    }


}
