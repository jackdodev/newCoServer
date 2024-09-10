package com.jackdodev.newCo.post;

import com.jackdodev.newCo.author.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/post")
public class PostController {
    @Autowired
    private PostService postService;

    @Autowired
    private AuthorService authorService;

    @GetMapping("/{id}")
    public Optional<Post> getPostByIdAndAuthorId(@RequestHeader(value = "authorId") String authorId, @PathVariable(value = "id") String postId) {
        return postService.getPostById(UUID.fromString(authorId), UUID.fromString(postId));
    }

    @GetMapping
    public List<Post> getAllPost(@RequestHeader(value = "authorId") String authorId) {
        return postService.getAllPostsByAuthor(UUID.fromString(authorId));
    }

    @PostMapping
    public Post createPost(@RequestHeader(value = "authorId") String authorId, @RequestBody PostDTO postDto) {
        Post post = Post.convertPostFromPostDTO(postDto);
        post.setAuthorId(UUID.fromString(authorId));

        return postService.createPost(post);
    }

    @PutMapping
    public Optional<Post> updatePost(@RequestHeader(value = "authorId") String authorId, @PathVariable String postId, @RequestBody PostDTO postDto) {
        Optional<Post> opPost = getPostByIdAndAuthorId(authorId, postId);
        if (opPost.isPresent()) {
            Post post = opPost.get();
            post = new Post(UUID.fromString(postId), postDto.subject, postDto.contents);
            post.setAuthorId(UUID.fromString(authorId));

            return Optional.of(postService.createPost(post));
        }

        return Optional.empty();
    }

    @DeleteMapping("/{id}")
    public void deletePost(@RequestHeader(value = "authorId") String authorId, @PathVariable String postId) {
        postService.deletePost(UUID.fromString(authorId), UUID.fromString(postId));
    }
}
