package com.serbatic.tpraga.techtalks.controller;

import com.serbatic.tpraga.techtalks.dto.TalkCardDto;
import com.serbatic.tpraga.techtalks.model.Author;
import com.serbatic.tpraga.techtalks.model.Talk;
import com.serbatic.tpraga.techtalks.service.AuthorService;
import com.serbatic.tpraga.techtalks.service.TalkService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class TalkController {

    private final TalkService talkService;

    @GetMapping("/talks")
    public List<Talk> getTalks() {
        return talkService.getTalks();
    }


    @PostMapping("/talk-card")
    public TalkCardDto getTalkById(@RequestBody String id) {
        TalkCardDto talkCardDto = talkService.getTalkById(Long.parseLong(id));
        return talkCardDto;
    }

    @PostMapping("/talk-full")
    public Talk getFullTalkById(@RequestBody Long id) {
        // TalkDto talkDto = talkService.getFullTalkById(Long.parseLong(id));
        Talk talk = talkService.getFullTalkById(id);
        return talk;
    }

    @GetMapping("/talks-titles")
    public String[] getTalksTitles() {
        return talkService.getTalksTitles();
    }


    @GetMapping("/talks-ids")
    public String[] getTalksIds() {
        return talkService.getTalksIds();
    }

    @PostMapping("/talk-search-title")
    public List<Talk> getTalksByTitleSearch(@RequestBody String searchParams) {
        if (!searchParams.isEmpty()) {
            System.out.println("inside");
            List<Talk> talks = talkService.getTalksByTitleSearch(searchParams);
            return talks;
        }
        return null;
    }


    @PostMapping("/talk-add")
    public Talk saveTalk(@RequestBody Talk talk) {
        talk.getTalkDate().setTimeZone(TimeZone.getTimeZone("GMT"));
        // Adds one hour since time comes correct from front but
        // it's not saved correctly in back
        talk.getTalkDate().add(Calendar.HOUR_OF_DAY, +1);
        // Also handles the case when dailight saving is active
        System.out.println(talk.getTimezoneInfo());
        if(talk.getTimezoneInfo().equals("0200")){
            System.out.println("adjusted");
            talk.getTalkDate().add(Calendar.HOUR_OF_DAY, +1);
        }
        System.out.println(talk.getTalkDate().getTimeZone());
        System.out.println("Let's see the date again");
        System.out.println(talk.getTalkDate().getTime());
        return talkService.saveTalk(talk);

    }


    @PutMapping("/talk-update")
    public Talk updateTalk(@RequestBody Talk talk) {
        System.out.println("this is talk id");
        System.out.println(talk.getId());
        return talkService.talkUpdate(talk);
    }

    @PostMapping("/talks-by-author")
    public List<Talk> getTalksByAuthorId(@RequestBody Long id) {
        if (id != null) {
            List<Talk> talks = talkService.getTalksByAuthorId(id);
            return talks;
        }
        return null;
    }

    @DeleteMapping("/talk/{id}")
    public ResponseEntity deleteTalk(@PathVariable Long id) {
        System.out.println("hey");
        if (id != null) {
            ResponseEntity response = talkService.deleteTalk(id);
            return response;
        }
        return null;
    }
}
