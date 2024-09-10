package com.jackdodev.newCo.post;

public class PostDTO {
    public String subject;
    public String contents;

    public void AuthorDTO(String subject, String contents) {
        this.subject = subject;
        this.contents = contents;
    }
}
