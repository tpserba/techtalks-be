package com.serbatic.tpraga.techtalks.repository;

import com.serbatic.tpraga.techtalks.dto.TalkCardDto;
import com.serbatic.tpraga.techtalks.model.Talk;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;



class ITalkRepositoryTest {
@Autowired
    private ITalkRepository iTalkRepository;
    @Test
    void itShouldGetTalksIds() {
    }

    @Test
    void findAll() {
    }

    @Test
    void itShouldGetTalkById() {
        /*
        // Given
        Talk talk = new Talk();
        talk.setTitle("Hello");
        iTalkRepository.save(talk);
        // When
        Talk talkReceived = iTalkRepository.findById(163L).get();
        // Then
        assertThat(talkReceived.getTitle()).isEqualTo("vavavava");

         */
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