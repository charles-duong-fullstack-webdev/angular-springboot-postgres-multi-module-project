package com.db.h2.console.service;

import com.db.h2.console.DTO.ExerciseDTO;
import com.db.h2.console.DTO.PersonExerciseDTO;
import com.db.h2.console.domain.Exercise;
import com.db.h2.console.domain.PersonExercise;
import com.db.h2.console.repository.ExerciseRepository;
import com.db.h2.console.repository.PersonExerciseRepository;
import entityToDTO.ExerciseEntityToDTO;
import entityToDTO.PersonExerciseEntityToDTO;
import org.modelmapper.ModelMapper;
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
    private static final ModelMapper modelMapper = new ModelMapper();

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

        personExerciseDTO.setExerciseDTOs(exerciseDTOs);
        System.err.println("personExerciseDTO >> " + personExerciseDTO);
        return personExerciseDTO;
        //return personExerciseRepository.getPersonExerciseById(listAll.get(0).getId());
    }

    public PersonExerciseDTO updatePersonExercise(PersonExerciseDTO personExerciseDTO) {

        System.err.println("personExerciseDTO >> " + personExerciseDTO);

        PersonExercise personExercise = modelMapper.map(personExerciseDTO, PersonExercise.class);
        System.err.println("personExercise.getId() >> " + personExercise.getId());
        System.err.println("personExercise >> " + personExercise);

        PersonExercise updatedPersonExercise = personExerciseRepository.save(personExercise);

        PersonExerciseEntityToDTO personExerciseEntityToDTO = new PersonExerciseEntityToDTO();
        PersonExerciseDTO updatedPersonExerciseDTO = personExerciseEntityToDTO.convertPersonExercise(updatedPersonExercise);
        System.err.println("updatedPersonExerciseDTO >> " + updatedPersonExerciseDTO);

        System.err.println("updatedPersonExerciseDTO.getId() >> " + updatedPersonExerciseDTO.getId());
        System.err.println("updatedPersonExerciseDTO >> " + updatedPersonExerciseDTO);

        List<Exercise> exerciseENTITYs = this.exerciseRepository.findAllExerciseById(personExercise.getId());
        System.err.println("exerciseENTITYs.size() >> " + exerciseENTITYs.size());
        System.err.println("exerciseENTITYs >> " + exerciseENTITYs);

        ExerciseEntityToDTO exerciseEntityToDTO = new ExerciseEntityToDTO();
        List<ExerciseDTO> exerciseDTOs = exerciseEntityToDTO.convertExercise(exerciseENTITYs);
        System.err.println("exerciseDTOTypeTokens >> " + exerciseDTOs);

        updatedPersonExerciseDTO.setExerciseDTOs(exerciseDTOs);

        return updatedPersonExerciseDTO;

    }

}
