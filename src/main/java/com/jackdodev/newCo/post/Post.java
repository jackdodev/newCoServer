package com.jackdodev.newCo.post;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "posts")
public class Post {
    @Id
    private UUID id;

    private String subject;

    private String contents;

    private LocalDate createdAt;

    private LocalDate lastModified;

    private UUID authorId;

    public Post(UUID id, String subject, String contents) {
        this.id = id;
        this.subject = subject;
        this.contents = contents;
        this.createdAt = LocalDate.now();
        this.lastModified = LocalDate.now();
    }

    public static Post convertPostFromPostDTO(PostDTO postDto) {
        UUID id = UUID.randomUUID();
        return new Post(id, postDto.subject, postDto.contents);
    }

    public UUID getId() {
        return this.id;
    }

    public UUID getAuthorId() {
        return authorId;
    }

    public void setAuthorId(UUID authorId) {
        this.authorId = authorId;
    }
}
