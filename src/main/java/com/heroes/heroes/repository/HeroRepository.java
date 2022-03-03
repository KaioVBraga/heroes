package com.heroes.heroes.repository;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.heroes.heroes.model.Hero;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface HeroRepository extends JpaRepository<Hero, Long> {
    @Query("SELECT h FROM Hero h WHERE h.name like %?1%")
    List<Hero> findByName(String name);
}
