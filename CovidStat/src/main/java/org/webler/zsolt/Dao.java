package org.webler.zsolt;

import java.util.List;
import java.util.Optional;

public interface Dao<T> {


    boolean save(T t);
    List<T> getAll();
    Optional<T> getById(int id);


}
