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
import org.springframework.stereotype.Service;

import java.util.List;

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
        return iTalkRepository.save(talk);
    }

    public void deleteTalk(Long id) {
        iTalkRepository.deleteById(id);
    }

    public Talk updateTalk(Talk talk) {
        Talk talkUpdated = iTalkRepository.findById(talk.getId()).get();
        // Finds the new author using the id provided by the client request
        // Author updatedAuthor = iAuthorRepository.findById(talk.getAuthor().getId()).get();
        Author updatedAuthor = new Author();
        talkUpdated.setAuthor(updatedAuthor);
        talkUpdated.setTitle(talk.getTitle());
        return iTalkRepository.save(talkUpdated);
    }

    public List<Talk> getTalksByTitleSearch(String searchParams) {
        System.out.println("incoming params");
        System.out.println(searchParams.substring(1, searchParams.length() - 1));
        // Removes quotes so JPA method query works
        String removedQuotes = searchParams.substring(1, searchParams.length() - 1);
        return iTalkRepository.findByTitleContaining(removedQuotes);
    }

    public List<Talk> getTalksByAuthorId(Long id) {
        // Removes quotes so JPA method query works

        return iTalkRepository.getTalkByAuthorId(id);
    }
}
