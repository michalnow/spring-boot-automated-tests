package com.michal.animal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/animal")
public class AnimalController {
    private AnimalService animalService;

    @Autowired
    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @GetMapping("/all")
    public Iterable<Animal> getAllAnimals(){
        return animalService.getAllAnimals();
    }

    @PostMapping
    public void saveAnimal(@Valid @RequestBody Animal animal){
        animalService.saveAnimal(animal);
    }
}
