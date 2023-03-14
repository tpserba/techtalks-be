package com.serbatic.tpraga.techtalks.controller;

import com.serbatic.tpraga.techtalks.model.Author;
import com.serbatic.tpraga.techtalks.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AuthorController {
    private final AuthorService authorService;

    @PostMapping("/talk-search-author")
    public List<Author> getTalksByAuthorSearch(@RequestBody String searchParams) {
        if (!searchParams.isEmpty()) {
            System.out.println("inside");
            List<Author> authors = authorService.getTalksByAuthorSearch(searchParams);
            return authors;
        }
        return null;
    }
}
