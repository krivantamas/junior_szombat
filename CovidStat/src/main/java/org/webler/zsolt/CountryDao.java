package org.webler.zsolt;

import java.util.List;
import java.util.Optional;

public class CountryDao implements Dao<Country> {

    @Override
    public boolean save(Country country) {
        return false;
    }

    @Override
    public List<Country> getAll() {
        return null;
    }

    @Override
    public Optional<Country> getById(int id) {
        return null;
    }


    public Optional<Country> getByCountryName(String name) {
        return null;
    }

}
