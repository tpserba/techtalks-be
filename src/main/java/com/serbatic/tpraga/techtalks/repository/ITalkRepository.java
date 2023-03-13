package com.serbatic.tpraga.techtalks.repository;

import com.serbatic.tpraga.techtalks.dto.TalkCardDto;
import com.serbatic.tpraga.techtalks.model.Talk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public interface ITalkRepository extends JpaRepository <Talk, Long>{
    @Transactional
    @Modifying
    @Query("delete from talks t")
    int deleteFirstBy();

    // Named query. In class Talk
    @Query(name = "getTalkById" , nativeQuery = true)
    public TalkCardDto getTalkById(@RequestBody Long id);

    // Closed interfaced query
    @Query(value = "SELECT " +
            "t.title " +
            "FROM talks t", nativeQuery = true
    )
    public String[] getTalksTitles();
}
