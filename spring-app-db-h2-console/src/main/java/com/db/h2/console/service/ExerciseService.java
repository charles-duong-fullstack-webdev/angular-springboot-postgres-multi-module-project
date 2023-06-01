package com.db.h2.console.service;

import com.db.h2.console.DTO.ExerciseDTO;
import com.db.h2.console.domain.Exercise;
import com.db.h2.console.domain.PersonExercise;
import com.db.h2.console.repository.ExerciseRepository;
import com.db.h2.console.repository.PersonExerciseRepository;
import dtoToEntity.ExerciseDTOToEntity;
import entityToDTO.ExerciseEntityToDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public List<ExerciseDTO> listExercises() {
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

    public List<ExerciseDTO> inserrExercise(ExerciseDTO exerciseDTO) {

        System.err.println("==============>  inserrExercise Input exerciseDTO >> " + exerciseDTO);

        List<PersonExercise> listAll = personExerciseRepository.findAll();
        System.err.println("<<<<< getPersonExerciseById getId: " + listAll.get(0).getId());
        Long personExerciseId = listAll.get(0).getId();
        PersonExercise personExercise = this.personExerciseRepository.getPersonExerciseById(personExerciseId);
        System.err.println("personExercise.getId() >> " + personExercise.getId());

        ExerciseDTOToEntity exerciseDTOToEntity = new ExerciseDTOToEntity();
        Exercise exercise = exerciseDTOToEntity.convertPersonExercise(exerciseDTO);

        System.err.println("inserrExercise exercise >> " + exercise);

        this.exerciseRepository.insertExercise(exercise.getName() + " (New)",
                exercise.getCalories(), exercise.getDuration(), personExercise.getId());

        return new ArrayList<ExerciseDTO>();
    }


}
