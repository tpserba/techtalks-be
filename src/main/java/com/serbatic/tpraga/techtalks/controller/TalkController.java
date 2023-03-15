package com.serbatic.tpraga.techtalks.controller;

import com.serbatic.tpraga.techtalks.dto.TalkCardDto;
import com.serbatic.tpraga.techtalks.model.Author;
import com.serbatic.tpraga.techtalks.model.Talk;
import com.serbatic.tpraga.techtalks.service.AuthorService;
import com.serbatic.tpraga.techtalks.service.TalkService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        return talkService.saveTalk(talk);
    }

    @PostMapping("/delete-talk")
    public void removeTalk(@RequestBody Long id) {
        talkService.deleteTalk(id);
    }

    @PutMapping("/update-talk")
    public Talk updateTalk(@RequestBody Talk talk) {
        return talkService.updateTalk(talk);
    }

    @PostMapping("/talks-by-author")
    public List<Talk> getTalksByAuthorId(@RequestBody Long id) {
        if (id != null) {
            List<Talk> talks = talkService.getTalksByAuthorId(id);
            return talks;
        }
        return null;
    }
}
