package com.serbatic.tpraga.techtalks.service;

import com.serbatic.tpraga.techtalks.dto.TalkCardDto;
import com.serbatic.tpraga.techtalks.model.Talk;
import com.serbatic.tpraga.techtalks.repository.ITalkRepository;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.GregorianCalendar;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

//@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//@RequiredArgsConstructor
@ExtendWith(MockitoExtension.class)
//@ActiveProfiles("test")
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class, DataSourceTransactionManagerAutoConfiguration.class})
class TalkServiceTest {
    @Mock
    private ITalkRepository iTalkRepository;
    @InjectMocks
    private TalkService talkService;


    @Test
    void getTalksPageable() {
    }

    @Test
    void getTalkById() {

        // Given
        TalkCardDto talkCardDto = new TalkCardDto();
        talkCardDto.setId(2L);
        Long expectedResult = 2L;
        // When
        when(iTalkRepository.getTalkById(1L)).thenReturn(talkCardDto);
        // Then
        assertThat(iTalkRepository.getTalkById(1L).getId()).isEqualTo(expectedResult);

    }

    @Test
    void getFullTalkById() {
    }

    @Test
    void getTalksTitles() {
    }

    @Test
    void saveTalk() {
        // Given
        Talk talk = new Talk();
        talk.setId(1L);
        // When
        when(iTalkRepository.save(any(Talk.class))).then(returnsFirstArg());
        // Then
        assertThat(talkService.saveTalk(talk).getId()).isEqualTo(1L);
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
        assertThat(talkService.talkUpdate(talk).getTitle()).isEqualTo("OK");
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