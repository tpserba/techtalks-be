package com.serbatic.tpraga.techtalks.service;

import com.serbatic.tpraga.techtalks.dto.TalkCardDto;
import com.serbatic.tpraga.techtalks.dto.TalkDto;
import com.serbatic.tpraga.techtalks.mapper.TalkMapper;
import com.serbatic.tpraga.techtalks.model.Author;
import com.serbatic.tpraga.techtalks.model.Talk;
import com.serbatic.tpraga.techtalks.repository.IAuthorRepository;
import com.serbatic.tpraga.techtalks.repository.ITalkRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import java.util.TimeZone;

@NoArgsConstructor
@AllArgsConstructor
@Service
public class TalkService {
    @Autowired
    private ITalkRepository iTalkRepository;

    @Autowired
    private IAuthorRepository iAuthorRepository;

    public List<Talk> getTalks() {
        return iTalkRepository.findAll();
    }

    public Page<Talk> getTalksPageable(int page, int size, Pageable pageable) {
        Pageable paging = PageRequest.of(page, size);
        return iTalkRepository.findAll(paging);
    }
    // When changing Author.class to TalkDto(in the query in Author file), the error appears here
    public TalkCardDto getTalkById(Long id) {
        TalkCardDto talkCardDto = iTalkRepository.getTalkById(id);
        return talkCardDto;
    }

    public Talk getFullTalkById(Long id) {
        // Gets talk object
        Talk talk = iTalkRepository.findById(id).get();
        // Splits the string by spaces and converts it to array
        //String[] resourcesArr = talk.getResources().split("\\s+");
        // Sets up the mapper
        TalkMapper talkMapper = Mappers.getMapper(TalkMapper.class);
        // Converts the objet to its DTO
        TalkDto talkDto = talkMapper.TalkToTalkDto(talk);
        // Maps description field, for some reason mapstruct is not doing it. Happens only with this field.
        talkDto.setDescription(talk.getDescription());
        // Sets the resources array
        // talkDto.setResource(resourcesArr);

        return talk;
    }

    public String[] getTalksTitles() {
        return iTalkRepository.getTalksTitles();
    }

    public Talk saveTalk(Talk talk) {
        talk.getTalkDate().setTimeZone(TimeZone.getTimeZone("GMT"));
        // Adds one hour since time comes correct from front but
        // it's not saved correctly in back
        talk.getTalkDate().add(Calendar.HOUR_OF_DAY, +1);
        // Also handles the case when dailight saving is active
        if(talk.getTimezoneInfo() == -120){
            talk.getTalkDate().add(Calendar.HOUR_OF_DAY, +1);
        }
        return iTalkRepository.save(talk);
    }

    public ResponseEntity deleteTalk(Long id) {
        iTalkRepository.deleteById(id);
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

    public Talk talkUpdate(Talk talk) {
        // Finds talk by id
        Talk talkFromDb = iTalkRepository.findById(talk.getId()).get();
        // Creates a new talk to store the received values from front
        talkFromDb.setTitle(talk.getTitle());
        talkFromDb.setAuthor(talk.getAuthor());
        talkFromDb.setDescription(talk.getDescription());
        talkFromDb.setResources(talk.getResources());
        talkFromDb.setTalkDate(talk.getTalkDate());
        // icon talkFromDb.setTitle(talk.getTitle());
        talkFromDb.setVidUrl(talk.getVidUrl());
        talkFromDb.setTimezoneInfo(talk.getTimezoneInfo());

        talkFromDb.getTalkDate().setTimeZone(TimeZone.getTimeZone("GMT"));
        // Adds one hour since time comes correct from front but
        // it's not saved correctly in back
        talkFromDb.getTalkDate().add(Calendar.HOUR_OF_DAY, +1);
        // Also handles the case when dailight saving is active
        if(talkFromDb.getTimezoneInfo() == -120){
            talkFromDb.getTalkDate().add(Calendar.HOUR_OF_DAY, +1);
        }
        return iTalkRepository.save(talkFromDb);
    }

    public List<Talk> getTalksByTitleSearch(String searchParams) {
        // Removes quotes so JPA method query works
        String removedQuotes = searchParams.substring(1, searchParams.length() - 1);
        return iTalkRepository.findByTitleContaining(removedQuotes);
    }

    public List<Talk> getTalksByAuthorId(Long id) {
        // Removes quotes so JPA method query works

        return iTalkRepository.getTalkByAuthorId(id);
    }

    public String[] getTalksIds() {
        return iTalkRepository.getTalksIds();
    }
}
