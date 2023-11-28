package org.webler.zsolt.SpringTest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.webler.zsolt.SpringTest.model.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByName(String name);

    List<User> findAllByAgeGreaterThan(int age);

    @Query(value = "SELECT u FROM User u where u.age > 12")
    List<User> randomQuery();

}
