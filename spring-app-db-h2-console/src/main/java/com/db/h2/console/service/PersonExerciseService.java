package com.db.h2.console.service;

import com.db.h2.console.DTO.ExerciseDTO;
import com.db.h2.console.DTO.PersonExerciseDTO;
import com.db.h2.console.domain.Exercise;
import com.db.h2.console.domain.PersonExercise;
import com.db.h2.console.repository.ExerciseRepository;
import com.db.h2.console.repository.PersonExerciseRepository;
import entityToDTO.ExerciseEntityToDTO;
import entityToDTO.PersonExerciseEntityToDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PersonExerciseService {

    private PersonExerciseRepository personExerciseRepository;

    private ExerciseRepository exerciseRepository;

    @Autowired
    public PersonExerciseService(PersonExerciseRepository personExerciseRepository,
                                 ExerciseRepository exerciseRepository) {
        this.personExerciseRepository = personExerciseRepository;
        this.exerciseRepository = exerciseRepository;
    }

    public List<PersonExercise> list() {
        return personExerciseRepository.findAll();
    }

    public PersonExerciseDTO getPersonExerciseById() {
        List<PersonExercise> listAll = personExerciseRepository.findAll();
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
        System.err.println("exerciseDTOTypeTokens >> " + exerciseDTOs);

        PersonExerciseEntityToDTO personExerciseEntityToDTO = new PersonExerciseEntityToDTO();
        PersonExerciseDTO personExerciseDTO = personExerciseEntityToDTO.convertPersonExercise(personExercise);
        System.err.println("personExerciseDTO >> " + personExerciseDTO);

        personExerciseDTO.setExerciseDTOList(exerciseDTOs);
        System.err.println("personExerciseDTO >> " + personExerciseDTO);
        return personExerciseDTO;
        //return personExerciseRepository.getPersonExerciseById(listAll.get(0).getId());
    }


}
