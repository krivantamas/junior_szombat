package org.webler.zsolt.SpringTest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webler.zsolt.SpringTest.model.User;
import org.webler.zsolt.SpringTest.repository.UserRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public User findByName(String name) {
        return userRepository.findByName(name).orElseThrow();
    }


    public User add(User user) {
        return userRepository.save(user);
    }

    public void remove(Long id) {
        userRepository.deleteById(id);
    }

    public void removeAll() {
        userRepository.deleteAll();
    }

    public User get(Long id) throws NoSuchElementException {
        return userRepository.findById(id).orElseThrow();
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

}
