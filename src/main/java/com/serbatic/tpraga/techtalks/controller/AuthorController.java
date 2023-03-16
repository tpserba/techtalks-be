package com.serbatic.tpraga.techtalks.controller;

import com.serbatic.tpraga.techtalks.model.Author;
import com.serbatic.tpraga.techtalks.model.Talk;
import com.serbatic.tpraga.techtalks.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AuthorController {
    private final AuthorService authorService;

    @GetMapping("/authors")
    public List<Author> getAuthors() {
        return authorService.getAuthors();
    }

    @GetMapping("/author-by-email/{authorEmail}")
    public Author getyAuthorByEmail(@PathVariable String authorEmail) {
        if (!authorEmail.isEmpty()) {
            System.out.println("inside");
            Author author = authorService.getAuthorByEmail(authorEmail);
            return author;
        }
        return null;
    }
    @PostMapping("/author-by-name")
    public List<Author> getyAuthorByName(@RequestBody String searchParams) {
        if (!searchParams.isEmpty()) {
            System.out.println("inside");
            List<Author> authors = authorService.getAuthorByName(searchParams);
            return authors;
        }
        return null;
    }


}
