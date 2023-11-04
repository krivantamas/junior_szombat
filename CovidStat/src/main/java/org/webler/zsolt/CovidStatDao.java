package org.webler.zsolt;

import java.util.List;
import java.util.Optional;

public class CovidStatDao implements Dao<CovidStat> {

    @Override
    public boolean save(CovidStat covidStat) {
        return false;
    }

    @Override
    public List<CovidStat> getAll() {
        return null;
    }

    @Override
    public Optional<CovidStat> getById(int id) {
        return Optional.empty();
    }
}
