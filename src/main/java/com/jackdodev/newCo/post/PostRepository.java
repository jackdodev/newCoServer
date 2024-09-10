package com.jackdodev.newCo.post;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PostRepository extends JpaRepository<Post, UUID> {
    List<Post> findByAuthorId(UUID authorId);

    @Query("SELECT p from posts p WHERE p.authorId = ?1 AND p.id = ?2")
    Optional<Post> findPostByAuthorIdAndId(UUID authorId, UUID postId);

    void deleteByAuthorIdAndId(UUID postId, UUID author_id);
}
