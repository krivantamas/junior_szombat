package org.webler.zsolt.SpringTest.service;

import org.springframework.stereotype.Service;
import org.webler.zsolt.SpringTest.model.User;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private final List<User> users = new ArrayList<>();

    public User add(User user) {
        users.add(user);
        return user;
    }

    public void remove(int index) {
        users.remove(index);
    }

    public void removeAll() {
        users.clear();
    }

    public User get(int index) {
        return users.get(index);
    }

    public List<User> getAll() {
        return users;
    }

}
