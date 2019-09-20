package com.michal.animal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Service
public class AnimalService {
    private AnimalRepository animalRepository;

    @Autowired
    public AnimalService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    public List<Animal> getAllAnimals(){
        List<Animal> animals = new ArrayList<>();
        animalRepository.findAll().iterator().forEachRemaining(animals::add);
        return animals;
    }

    public Animal saveAnimal(Animal animal){
        return animalRepository.save(animal);
    }
}
