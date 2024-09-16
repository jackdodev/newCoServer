package com.jackdodev.newCo.post;

import com.jackdodev.newCo.author.Author;
import com.jackdodev.newCo.author.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
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
    public Optional<Post> getPostByIdAndAuthorId(
            @RequestHeader(value = "authorId") String authorId,
            @PathVariable(value = "id") String postId) {
        Optional<Post> opPost = postService.getPostById(UUID.fromString(authorId), UUID.fromString(postId));

        return opPost;
    }

    @GetMapping
    public Optional<List<Post>> getAllPost(@RequestHeader(value = "authorId") String authorId) {
        Optional<List<Post>> opPosts = postService.getAllPostsByAuthor(UUID.fromString(authorId));
        opPosts.ifPresent(posts -> {
            posts.forEach(post -> {
                Optional<Author> opAuthor = authorService.getAuthorById(post.getAuthorId());
                opAuthor.ifPresent(author -> {
                    System.out.println(post.getSubject() + ", " + post.getContents() + ", by " +  author.getId());
                });
            });
        });

        return opPosts;
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
            post = new Post(UUID.fromString(postId), postDto.subject, postDto.contents, post.getCreatedAt(), LocalDateTime.now());
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
