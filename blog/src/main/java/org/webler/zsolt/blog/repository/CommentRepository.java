package org.webler.zsolt.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.webler.zsolt.blog.model.Comment;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    Optional<Comment> findByPost_IdAndId(Long postId, Long id);

    List<Comment> findAllByPost_Id(Long postId);
}
