package com.jackdodev.newCo.post;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    @Transactional
    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    @Transactional
    public Post getPostById(Long userId, Long postId) {
        return postRepository.findPostById(userId, postId);
    }

    public List<Post> getAllPostsByUser(Long userId) {
        return new ArrayList<>(postRepository.findByUserId(userId));
    }

    public void deletePost(Long userId, Long postId) {
        postRepository.deleteById(userId, postId);
    }
}
