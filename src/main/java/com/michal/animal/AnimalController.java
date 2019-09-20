package com.michal.animal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/animal")
public class AnimalController {
    private AnimalRepository animalRepository;

    @Autowired
    public AnimalController(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    @GetMapping("/all")
    public List<Animal> getAllAnimals(){
        List<Animal> animals = new ArrayList<>();
        animalRepository.findAll().iterator().forEachRemaining(animals::add);
        return animals;
    }

    @PostMapping
    public Animal saveAnimal(@Valid @RequestBody Animal animal){
        return animalRepository.save(animal);
    }
}
