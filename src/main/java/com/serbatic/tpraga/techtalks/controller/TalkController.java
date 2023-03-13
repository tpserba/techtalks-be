package com.serbatic.tpraga.techtalks.controller;

import com.serbatic.tpraga.techtalks.dto.TalkCardDto;
import com.serbatic.tpraga.techtalks.dto.TalkDto;
import com.serbatic.tpraga.techtalks.model.Talk;
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


    @PostMapping("/talk")
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
}
