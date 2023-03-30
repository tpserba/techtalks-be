package com.serbatic.tpraga.techtalks.service;

import com.serbatic.tpraga.techtalks.model.Author;
import com.serbatic.tpraga.techtalks.repository.IAuthorRepository;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

//@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@ExtendWith(MockitoExtension.class)
class AuthorServiceTest {
    @Mock
    private IAuthorRepository iAuthorRepository;
    @InjectMocks
    private AuthorService authorService;

    @Test
    void getAuthorByName() {
    }

    @Test
    void getAuthors() {

    }

    @Test
    void getAuthorByEmail() {
        // Given
        Author author = new Author();
        author.setEmail("olgarobs@corp.com");
        author.setId(2L);
        String aEmail = "olgarobs@corp.com";

        // When
        when(iAuthorRepository.findByEmail(aEmail)).thenReturn(author);
        // Then
        assertThat(authorService.getAuthorByEmail(aEmail).getId()).isEqualTo(2L);

    }
}