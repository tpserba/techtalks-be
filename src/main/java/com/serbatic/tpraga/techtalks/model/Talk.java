package com.serbatic.tpraga.techtalks.model;

import com.serbatic.tpraga.techtalks.dto.TalkCardDto;
import jakarta.persistence.*;
import lombok.*;

import java.util.Calendar;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Entity(name = "talks")
@NamedNativeQuery(
        name = "getTalkById",
        query =
                "SELECT " +
                        "t.id, t.title, a.author_name " +
                        "from talks t " +
                        "JOIN authors a " +
                        "ON a.id = t.author_id " +
                        "where t.id = :id",
        resultSetMapping = "talkByIdMapping"
)
@SqlResultSetMapping(
        name = "talkByIdMapping",
        classes = @ConstructorResult(
                targetClass = TalkCardDto.class,
                columns = {
                        @ColumnResult(name = "id", type = Long.class),
                        @ColumnResult(name = "talk_date", type = Calendar.class),
                        @ColumnResult(name = "title", type = String.class),
                        @ColumnResult(name = "author_name", type = String.class),

                }
        )
)


public class Talk {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    private Author author;
    private String resources;
    private Calendar talkDate;

    private String vidUrl;
    private String talkIcon;


    public Talk(String title, Author author) {
        this.title = title;
        this.author = author;
    }

}
