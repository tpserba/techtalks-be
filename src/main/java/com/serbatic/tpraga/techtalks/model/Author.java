package com.serbatic.tpraga.techtalks.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Entity(name = "authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String authorName;
    private String linkedin;
    private String email;
    @JsonIgnore
    /*
    @OneToMany(targetEntity = Talk.class, cascade = CascadeType.ALL, mappedBy = "author")
    @JoinColumn(name="talk_id", referencedColumnName = "id")
     */
    @OneToMany(mappedBy = "author")
    private Set<Talk> talks = new HashSet<>();

    public Author(long id, String authorName) {
        this.id = id;
        this.authorName = authorName;
    }
}
