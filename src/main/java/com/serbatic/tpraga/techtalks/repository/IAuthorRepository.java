package com.serbatic.tpraga.techtalks.repository;

import com.serbatic.tpraga.techtalks.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAuthorRepository extends JpaRepository <Author, Long> {

}
