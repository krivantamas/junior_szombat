package library;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

public class BookDao implements Dao<Book> {

    private final Connection connection;

    BookDao(Connection connection) {
        this.connection = connection;
    }


    @Override
    public boolean save(Book book) {
        System.out.println(book);
        return false;
    }

    @Override
    public boolean delete(Book book) {
        return false;
    }

    @Override
    public boolean update(Book book) {
        return false;
    }

    @Override
    public Optional<Book> getById(int id) {
        return Optional.empty();
    }

    @Override
    public List<Book> getAll() {
        return null;
    }
}
