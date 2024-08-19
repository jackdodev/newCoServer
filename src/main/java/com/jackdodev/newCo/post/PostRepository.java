package com.jackdodev.newCo.post;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByUserId(Long userId);

    @Query("SELECT p from posts p WHERE p.id = :postId AND p.user.id = :userId")
    Post findPostById(@Param("userId") Long userId, @Param("postId") Long postId);

    @Query(value = "DELETE FROM post p WHERE id = :postId AND p.user.id = :userId")
    void deleteById(@Param("userId") Long userId, @Param("postId") Long postId);
}
