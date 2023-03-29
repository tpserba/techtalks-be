package com.serbatic.tpraga.techtalks.service;

import com.serbatic.tpraga.techtalks.model.Talk;
import com.serbatic.tpraga.techtalks.repository.ITalkRepository;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@RequiredArgsConstructor
class TalkServiceTest {
    private ITalkRepository iTalkRepository;
    private TalkService talkService;

    @BeforeEach
    void setUp() {
        iTalkRepository = mock(ITalkRepository.class);
        talkService = new TalkService(iTalkRepository);
    }

    @Test
    void getTalks() {
    }

    @Test
    void getTalksPageable() {
    }

    @Test
    void getTalkById() {
    }

    @Test
    void getFullTalkById() {
    }

    @Test
    void getTalksTitles() {
    }

    @Test
    void saveTalk() {

    }

    @Test
    void deleteTalk() {
    }

    @Test
    void talkUpdate() {
        // Given
        Talk talk = new Talk();
        talk.setId(1L);
        talk.setTitle("OK");
        talk.setTalkDate(new GregorianCalendar());
        // When
        when(iTalkRepository.findById(1L)).thenReturn(Optional.of(talk));
        when(iTalkRepository.save(any())).then(returnsFirstArg());

        // Then
        assertThat(talkService.getFullTalkById(1L).getTitle()).isEqualTo("OK");
        assertThat(talkService.talkUpdate(talk).getTitle()).isEqualTo("babam");
    }

    @Test
    void getTalksByTitleSearch() {
    }

    @Test
    void getTalksByAuthorId() {
    }

    @Test
    void getTalksIds() {
    }
}