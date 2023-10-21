package library;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
        return false;
    }

    @Override
    public boolean update(Book book, Book updateBook) {
        return false;
    }

    @Override
    public Optional<Book> getById(String id) {
        return Optional.empty();
    }

    @Override
    public List<Book> getAll() {
        return null;
    }
}
