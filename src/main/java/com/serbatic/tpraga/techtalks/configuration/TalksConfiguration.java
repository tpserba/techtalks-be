package com.serbatic.tpraga.techtalks.configuration;

import com.serbatic.tpraga.techtalks.model.Author;
import com.serbatic.tpraga.techtalks.model.Talk;
import com.serbatic.tpraga.techtalks.repository.ITalkRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
@Configuration
public class TalksConfiguration {
    /*
    @Bean
    CommandLineRunner commandLineRunner(ITalkRepository repo) {
        return args-> {
            Talk john = new Talk(
                    "Java",
                    new Author(1L, "John doe")
            );

            Talk laura = new Talk(
                    "Ionic introduction",
                    new Author(2L, "Laura doe")
            );
            repo.saveAll(List.of(john, laura));
        };
    }

     */
}
