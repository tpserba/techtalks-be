package com.serbatic.tpraga.techtalks.dto;

import com.serbatic.tpraga.techtalks.model.Author;
import com.serbatic.tpraga.techtalks.model.Resource;
import lombok.*;

import java.util.Calendar;
import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TalkDto {
    private Long id;
    private String title;
    private String description;
    private Author author;
    private String[] resource;
    private Calendar talkDate;
    // Even with Lombok, this constructor is necessary for the query
    public TalkDto(Long id, String title, Author author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }
}
