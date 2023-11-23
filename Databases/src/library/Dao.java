package library;

import java.util.List;
import java.util.Optional;

public interface Dao<T,V> {


    boolean save(T t);

    boolean delete(T t);

    boolean update(T t, T t2);

    Optional<T> getById(V id);

    List<T> getAll();

}
