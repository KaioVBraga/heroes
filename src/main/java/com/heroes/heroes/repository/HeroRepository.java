package com.heroes.heroes.repository;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.heroes.heroes.model.Hero;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeroRepository extends JpaRepository<Hero, Long> {

}
