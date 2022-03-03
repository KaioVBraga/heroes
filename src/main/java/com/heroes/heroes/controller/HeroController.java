package com.heroes.heroes.controller;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.heroes.heroes.model.Hero;
import com.heroes.heroes.repository.HeroRepository;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/heroes")
public class HeroController {
    @Autowired
    private HeroRepository heroRepository;

    @GetMapping
    public List<Hero> index() {
        return heroRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Hero> read(@PathVariable Long id) {
        return heroRepository.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Hero create(@RequestBody Hero hero) {
        return heroRepository.save(hero);
    }

    @PutMapping("/{id}")
    public Hero update(@PathVariable Long id, @RequestBody Hero body) {
        Hero hero = heroRepository.getById(id);

        if (body.getName() != null) {
            hero.setName(body.getName());
        }

        if (body.getPower() != null) {
            hero.setPower(body.getPower());
        }

        heroRepository.save(hero);

        return hero;
    }

    @DeleteMapping("/{id}")
    public String update(@PathVariable Long id) {
        heroRepository.deleteById(id);

        return "Hero deleted";
    }
}
