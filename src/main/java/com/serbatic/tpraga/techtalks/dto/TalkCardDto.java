package com.serbatic.tpraga.techtalks.dto;


import com.serbatic.tpraga.techtalks.model.Resource;
import lombok.*;

import java.util.Calendar;
import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TalkCardDto {
    private Long id;
    private String title;
    private String authorName;
    private String resources;
    private Calendar talkDate;

    // Even with Lombok, this constructor is necessary for the query
    public TalkCardDto(Long id, String title, String authorName) {
        this.id = id;
        this.title = title;
        this.authorName = authorName;
    }
}
