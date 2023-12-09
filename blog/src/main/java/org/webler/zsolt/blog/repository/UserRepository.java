package org.webler.zsolt.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.webler.zsolt.blog.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
