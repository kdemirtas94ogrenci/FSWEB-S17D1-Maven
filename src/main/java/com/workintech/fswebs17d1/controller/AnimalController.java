package com.workintech.fswebs17d1.controller;


import com.workintech.fswebs17d1.entity.Animal;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/workintech/animal")
public class AnimalController {

    private Map<Integer, Animal> animals = new HashMap<>();

    @Value("${course.name}")
    private String courseName;

    @Value("${project.developer.fullname}")
    private String developerName;

    @GetMapping
    public List<Animal> getAll() {
        return new ArrayList<>(animals.values());
    }

    @GetMapping("/{id}")
    public Animal getById(@PathVariable int id) {
        return animals.get(id);
    }

    @PostMapping
    public Animal addAnimal(@RequestBody Animal animal) {
        animals.put(animal.getId(), animal);
        return animal;
    }

    @PutMapping("/{id}")
    public Animal updateAnimal(@PathVariable int id, @RequestBody Animal animal) {
        animals.put(id, animal);
        return animal;

    }

    @DeleteMapping("/{id}")
    public Animal deleteAnimal(@PathVariable int id) {
        return animals.remove(id);
    }

}
