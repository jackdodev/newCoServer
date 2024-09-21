package com.jackdodev.newCo.post;

import com.jackdodev.newCo.author.Author;
import com.jackdodev.newCo.author.AuthorDTO;
import com.jackdodev.newCo.author.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
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
    public Optional<PostDTO> getPostByIdAndAuthorId(
            @RequestHeader(value = "authorId") String authorId,
            @PathVariable(value = "id") String postId) {
        Optional<Post> opPost = postService.getPostById(UUID.fromString(authorId), UUID.fromString(postId));
        opPost.ifPresent(post -> {
            Optional<Author> authorOp = authorService.getAuthorById(post.getAuthorId());
            authorOp.ifPresent(author -> PostDTO.convertPostDTOFromPost(post, AuthorDTO.convertAuthorDTOFrommAuthor(author)));
        });

        return Optional.empty();
    }

    @GetMapping
    public Optional<List<PostDTO>> getAllPost(@RequestHeader(value = "authorId") String authorId) {
        List<PostDTO> lPostDto = new ArrayList<>();
        Optional<List<Post>> opPosts = postService.getAllPostsByAuthor(UUID.fromString(authorId));
        opPosts.ifPresent(posts -> {
            posts.forEach(post -> {
                Optional<Author> opAuthor = authorService.getAuthorById(post.getAuthorId());
                opAuthor.ifPresent(author -> {
                    System.out.println(post.getSubject() + ", " + post.getContents() + ", by " +  author.getId());
                    AuthorDTO authorDto = AuthorDTO.convertAuthorDTOFrommAuthor(author);
                    lPostDto.add(PostDTO.convertPostDTOFromPost(post, authorDto));
                });
            });
        });

        return Optional.of(lPostDto);
    }

    @PostMapping
    public void createPost(@RequestHeader(value = "authorId") UUID authorId, @RequestBody PostDTO postDto) {
        Post post = Post.convertPostFromPostDTO(postDto);
        post.setId(UUID.randomUUID());
        post.setAuthorId(authorId);

        postService.savePost(post);
    }

    @PutMapping
    public void updatePost(@RequestHeader(value = "authorId") UUID authorId, @PathVariable UUID postId, @RequestBody PostDTO postDto) {
        Optional<Post> opPost = postService.getPostById(authorId, postId);
        opPost.ifPresent(post -> {
            if (post.getAuthorId() == authorId) {
                Post updatedPost = new Post(postId, postDto.subject, postDto.contents, post.getCreatedAt(), LocalDateTime.now());
                postService.savePost(updatedPost);
            }
        });
    }

    @DeleteMapping("/{id}")
    public void deletePost(@RequestHeader(value = "authorId") String authorId, @PathVariable String postId) {
        postService.deletePost(UUID.fromString(authorId), UUID.fromString(postId));
    }
}
