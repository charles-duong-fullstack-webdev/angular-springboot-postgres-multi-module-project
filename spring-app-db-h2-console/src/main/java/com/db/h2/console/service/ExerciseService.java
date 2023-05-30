package com.db.h2.console.service;

import com.db.h2.console.DTO.ExerciseDTO;
import com.db.h2.console.domain.Exercise;
import com.db.h2.console.domain.PersonExercise;
import com.db.h2.console.repository.ExerciseRepository;
import com.db.h2.console.repository.PersonExerciseRepository;
import entityToDTO.ExerciseEntityToDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ExerciseService {

    private PersonExerciseRepository personExerciseRepository;

    private ExerciseRepository exerciseRepository;

    @Autowired
    public ExerciseService(PersonExerciseRepository personExerciseRepository,
                           ExerciseRepository exerciseRepository) {
        this.personExerciseRepository = personExerciseRepository;
        this.exerciseRepository = exerciseRepository;
    }

    public List<ExerciseDTO> list() {
        List<Exercise> listAll = exerciseRepository.findAll();
        System.err.println("<<<<< getPersonExerciseById getId: " + listAll.get(0).getId());
        Long personExerciseId = listAll.get(0).getId();
        PersonExercise personExercise = this.personExerciseRepository.getPersonExerciseById(personExerciseId);
        System.err.println("personExercise.getId() >> " + personExercise.getId());
        System.err.println("personExercise >> " + personExercise);

        List<Exercise> exerciseENTITYs = this.exerciseRepository.findAllExerciseById(personExercise.getId());
        System.err.println("exerciseENTITYs.size() >> " + exerciseENTITYs.size());
        System.err.println("exerciseENTITYs >> " + exerciseENTITYs);

        ExerciseEntityToDTO exerciseEntityToDTO = new ExerciseEntityToDTO();
        List<ExerciseDTO> exerciseDTOs = exerciseEntityToDTO.convertExercise(exerciseENTITYs);
        System.err.println("exerciseDTOs >> " + exerciseDTOs);

        return exerciseDTOs;

    }

//    public Exercise getBySlug(String slug) {
//        return ExerciseRepository.findBySlug(slug);
//    }
//
//    public List<Exercise> listByAuthor(Long id) {
//        return ExerciseRepository.findAllByAuthorIdOrderByExerciseedOnDesc(id);
//    }

    //public Exercise get(Long id) {
    //    return ExerciseRepository.findOne(id);
    //}

//    public Exercise save(Exercise Exercise) {
//        return ExerciseRepository.save(Exercise);
//    }

}
