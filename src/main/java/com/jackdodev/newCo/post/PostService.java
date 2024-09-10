package com.jackdodev.newCo.post;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    @Transactional
    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    @Transactional
    public Optional<Post> getPostById(UUID authorId, UUID postId) {
        return postRepository.findPostByAuthorIdAndId(authorId, postId);
    }

    public List<Post> getAllPostsByAuthor(UUID authorId) {
        return postRepository.findByAuthorId(authorId);
    }

    public void deletePost(UUID authorId, UUID postId) {
        postRepository.deleteByAuthorIdAndId(authorId, postId);
    }
}
