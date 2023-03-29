package com.serbatic.tpraga.techtalks.repository;

import com.serbatic.tpraga.techtalks.model.Talk;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ITalkRepositoryTest {

    private ITalkRepository iTalkRepository;
    @BeforeEach
    void setupService(){
        iTalkRepository = mock(ITalkRepository.class);
    }


    @Test
    void itShouldGetTalksIds() {
    }

    @Test
    void findAll() {
    }

    @Test
    void itShouldSaveTalk() {
        // Given
        Talk talk = new Talk();
        talk.setTitle("Testing");
        // when
        Talk receivedTalk = iTalkRepository.save(talk);
        // Then
        assert(receivedTalk.getTitle()).equals("Testing");
    }

    @Test
    void itShouldGetTalkById() {

        // Given
        Talk talk = new Talk();
        talk.setTitle("vavavava");
        // When
        when(iTalkRepository.findById(163L).get()).thenReturn(talk);
        // Then
        assertThat(talk.getTitle()).isEqualTo("vavavava");
    }

    @Test
    void getTalksTitles() {
    }

    @Test
    void findByTitleContaining() {
    }

    @Test
    void getTalkByAuthorId() {
    }
}