package com.db.h2.console.service;

import com.db.h2.console.domain.PersonExercise;
import com.db.h2.console.repository.PersonExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PersonExerciseService {

    private PersonExerciseRepository personExerciseRepository;

    @Autowired
    public PersonExerciseService(PersonExerciseRepository personExerciseRepository) {
        this.personExerciseRepository = personExerciseRepository;
    }

    public List<PersonExercise> list() {
        return personExerciseRepository.findAll();
    }

}
