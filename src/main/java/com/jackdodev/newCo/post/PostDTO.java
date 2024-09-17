package com.jackdodev.newCo.post;

import com.jackdodev.newCo.author.Author;
import com.jackdodev.newCo.author.AuthorDTO;

import java.time.LocalDateTime;

public class PostDTO {
    public String subject;
    public String contents;
    public AuthorDTO author;
    public LocalDateTime createdAt;
    public LocalDateTime lastModified;

    public PostDTO(String subject, String contents) {
        this.subject = subject;
        this.contents = contents;
    }

    public static PostDTO convertPostDTOFromPost(Post post, AuthorDTO authorDto) {
        PostDTO postDto = new PostDTO(post.getSubject(), post.getContents());
        postDto.author = authorDto;
        postDto.createdAt = post.getCreatedAt();
        postDto.lastModified = post.getLastModified();

        return postDto;
    }
}
