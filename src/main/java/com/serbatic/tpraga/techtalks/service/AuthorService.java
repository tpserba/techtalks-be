package com.serbatic.tpraga.techtalks.service;

import com.serbatic.tpraga.techtalks.model.Author;
import com.serbatic.tpraga.techtalks.model.Talk;
import com.serbatic.tpraga.techtalks.repository.IAuthorRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AuthorService {


    private final IAuthorRepository iAuthorRepository;

    public List<Author> getAuthorByName(String searchParams) {
        // Removes quotes so JPA method query works
        String removedQuotes = searchParams.substring(1, searchParams.length() - 1);
        return iAuthorRepository.findByAuthorNameContaining(removedQuotes);
    }

    public List<Author> getAuthors() {
        return iAuthorRepository.findAll();
    }

    public Author getAuthorByEmail(String authorEmail) {
        return iAuthorRepository.findByEmail(authorEmail);
    }
}
