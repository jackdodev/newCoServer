package com.jackdodev.newCo.post;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "posts")
public class Post {
    @Id
    private UUID id;

    private String subject;

    private String contents;

    private LocalDateTime createdAt;

    private LocalDateTime lastModified;

    private UUID authorId;

    public Post() {}

    public Post(UUID id, String subject, String contents, LocalDateTime createdAt, LocalDateTime lastModified) {
        this.id = id;
        this.subject = subject;
        this.contents = contents;
        this.createdAt = createdAt;
        this.lastModified = lastModified;
    }

    public static Post convertPostFromPostDTO(PostDTO postDto) {
        UUID id = UUID.randomUUID();
        return new Post(id, postDto.subject, postDto.contents, LocalDateTime.now(), LocalDateTime.now());
    }

    public LocalDateTime getCreatedAt() {
        return this.createdAt;
    }

    public LocalDateTime getLastModified() {
        return this.lastModified;
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

    public String getContents() {
        return this.contents;
    }

    public String getSubject() {
        return this.subject;
    }
}
