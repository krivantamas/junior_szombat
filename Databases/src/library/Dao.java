package library;

import java.util.List;
import java.util.Optional;

public interface Dao<T> {


    boolean save(T t);

    boolean delete(T t);

    boolean update(T t);

    Optional<T> getById(int id);

    List<T> getAll();

}
