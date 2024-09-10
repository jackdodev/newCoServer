package com.jackdodev.newCo.author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping("/{id}")
    public Optional<Author> getAuthorById(@PathVariable String id) {
        return authorService.getAuthorById(UUID.fromString(id));
    }

    @GetMapping
    public List<Author> getAllAuthors() {
        return authorService.getAllAuthors();
    }

    @PostMapping
    public Author createAuthor(@RequestBody AuthorDTO authorDto) {
        Author author = Author.convertAuthorFromAuthorDTO(authorDto);
        return authorService.createAuthor(author);
    }

    @PutMapping("/{id}")
    public Optional<Author> updateAuthor(@PathVariable String id, @RequestBody AuthorDTO authorDto) {
        Optional<Author> opAuthor = getAuthorById(id);
        if (opAuthor.isPresent()) {
            Author author = opAuthor.get();
            author = new Author(author.getId(), authorDto.firstName, authorDto.lastName, authorDto.dateOfBirth);

            return Optional.of(authorService.createAuthor(author));
        }

        return Optional.empty();
    }

    @DeleteMapping("/{id}")
    public void deleteAuthor(@PathVariable String id) {
        authorService.deleteAuthor(UUID.fromString(id));
    }
}
