package com.serbatic.tpraga.techtalks.repository;

import com.serbatic.tpraga.techtalks.model.Talk;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


//@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ExtendWith(MockitoExtension.class)
class ITalkRepositoryTest {
@Mock
    private ITalkRepository iTalkRepository;

    @Test
    void getTalksIds() {

    }

    @Test
    void getTalkById() {

    }

    @Test
    void getTalksTitles() {
    }

    @Test
    void getTalkByAuthorId() {
    }
}