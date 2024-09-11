package com.jackdodev.newCo.post;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PostRepository extends JpaRepository<Post, UUID> {
    List<Post> findByAuthorId(UUID authorId);

    Optional<Post> findPostByAuthorIdAndId(UUID authorId, UUID id);

//    @Query("SELECT p from posts p WHERE p.authorId = :authorId AND p.id = :id")
//    Optional<Post> findPostByAuthorIdAndId(@Param("authorId") UUID authorId, @Param("id") UUID postId);

    void deleteByAuthorIdAndId(UUID postId, UUID author_id);
}
