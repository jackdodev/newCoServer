package com.jackdodev.newCo.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping("/{id}")
    public Post getPostById(@RequestHeader(value = "user-id") Long userId, @PathVariable Long postId) {
        return postService.getPostById(userId, postId);
    }

    @GetMapping
    public List<Post> getAllPost(@RequestHeader(value = "user-id") Long userId) {
        return postService.getAllPosts();
    }

    @PostMapping
    public Post createPost(@RequestBody Post post) {
        return postService.createPost(post);
    }

    @PutMapping
    public Post updatePost(@RequestHeader(value = "user-id") Long userId, @PathVariable Long postId, @RequestBody Post post) {
        post.setId(postId);
        return postService.createPost(post);
    }

    @DeleteMapping("/{id}")
    public void deletePost(@RequestHeader(value = "user-id") Long userId, @PathVariable Long postId) {
        postService.deletePost(userId, postId);
    }
}
