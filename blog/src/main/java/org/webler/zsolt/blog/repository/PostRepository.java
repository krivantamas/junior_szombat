package org.webler.zsolt.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.webler.zsolt.blog.model.Post;

@Repository
public interface PostRepository extends JpaRepository<Post,Long> {
}
