package com.serbatic.tpraga.techtalks.service;

import com.serbatic.tpraga.techtalks.model.Author;
import com.serbatic.tpraga.techtalks.model.Talk;
import com.serbatic.tpraga.techtalks.repository.IAuthorRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Service
public class AuthorService {

    @Autowired
    private IAuthorRepository iAuthorRepository;

    public List<Author> getTalksByAuthorSearch(String searchParams) {
        // Removes quotes so JPA method query works
        String removedQuotes = searchParams.substring(1, searchParams.length() - 1);
        return iAuthorRepository.findByAuthorNameContaining(removedQuotes);
    }
}
