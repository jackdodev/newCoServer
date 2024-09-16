package com.jackdodev.newCo.post;

import com.jackdodev.newCo.author.Author;

import java.time.LocalDateTime;

public class PostDTO {
    public String subject;
    public String contents;
    public Author author;
    public LocalDateTime createdAt;
    public LocalDateTime lastModified;

    public void AuthorDTO(String subject, String contents) {
        this.subject = subject;
        this.contents = contents;
    }
}
