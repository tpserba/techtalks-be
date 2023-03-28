package com.serbatic.tpraga.techtalks.repository;

import com.serbatic.tpraga.techtalks.dto.TalkCardDto;
import com.serbatic.tpraga.techtalks.model.Talk;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Repository
public interface ITalkRepository extends JpaRepository <Talk, Long>{

    @Query(value = "SELECT " +
            "t.id " +
            "FROM talks t", nativeQuery = true
    )
    String[] getTalksIds();
    Page<Talk> findAll(Pageable pageable);
    // Named query. In class Talk
    @Query(name = "getTalkById" , nativeQuery = true)
    TalkCardDto getTalkById(@RequestBody Long id);

    // Closed interfaced query
    @Query(value = "SELECT " +
            "t.title " +
            "FROM talks t", nativeQuery = true
    )
    String[] getTalksTitles();


    List<Talk> findByTitleContaining(String title);


    @Query(value = "SELECT t.* FROM talks t LEFT JOIN authors a on t.author_id = a.id where a.id= :id",
            nativeQuery = true)
    List<Talk> getTalkByAuthorId(Long id);



}
