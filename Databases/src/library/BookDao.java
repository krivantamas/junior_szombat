package library;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BookDao implements Dao<Book, String> {

    private final Connection connection;

    BookDao(Connection connection) {
        this.connection = connection;
    }


    @Override
    public boolean save(Book book) {

        String sql = "INSERT INTO book(isbn, title, author, genre, available) VALUES (?,?,?,?,?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, book.getIsbn());
            preparedStatement.setString(2, book.getTitle());
            preparedStatement.setString(3, book.getAuthor());
            preparedStatement.setString(4, book.getGenre());
            preparedStatement.setBoolean(5, book.isAvailable());

            return preparedStatement.executeUpdate() == 1;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean delete(Book book) {
        String sql = "DELETE FROM book WHERE isbn = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, book.getIsbn());

            return preparedStatement.executeUpdate() == 1;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean update(Book book, Book updateBook) {
        String sql = "UPDATE book SET author = ?, title = ?, genre = ?, available = ? WHERE isbn = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, book.getAuthor());
            preparedStatement.setString(2, book.getTitle());
            preparedStatement.setString(3, book.getGenre());
            preparedStatement.setBoolean(4, book.isAvailable());
            preparedStatement.setString(5, book.getIsbn());

            return preparedStatement.executeUpdate() == 1;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<Book> getById(String id) {
        String sql = "SELECT * FROM book WHERE isbn = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                return Optional.of(mapResultSetToBook(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return Optional.empty();
    }

    @Override
    public List<Book> getAll() {

        String sql = "SELECT * FROM book";
        List<Book> books = new ArrayList<>();

        try {
            ResultSet resultSet = connection.createStatement().executeQuery(sql);
            while (resultSet.next()) {
                books.add(mapResultSetToBook(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return books;
    }

    public List<String> getAllAuthor() {
        return null;
    }

    public List<Book> booksByAuthor() {
        return null;
    }

    public List<Book> availableBooks() {
        return null;
    }

    public List<String> getAllAuthorMoreThanOneBook(){
        //TODO
        return null;
    }


    private Book mapResultSetToBook(ResultSet resultSet) throws SQLException {
        String isbn = resultSet.getString("isbn");
        String title = resultSet.getString("title");
        String author = resultSet.getString("author");
        String genre = resultSet.getString("genre");
        boolean available = resultSet.getBoolean("available");

        return new Book(isbn, title, author, genre, available);
    }
}
