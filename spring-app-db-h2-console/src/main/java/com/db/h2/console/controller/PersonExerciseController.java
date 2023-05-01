package com.db.h2.console.controller;

import com.db.h2.console.DTO.ExerciseDTO;
import com.db.h2.console.DTO.PersonExerciseDTO;
import com.db.h2.console.domain.Exercise;
import com.db.h2.console.domain.PersonExercise;
import com.db.h2.console.service.ExerciseService;
import com.db.h2.console.service.PersonExerciseService;
import entityToDTO.ExerciseEntityToDTO;
import entityToDTO.PersonExerciseEntityToDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//https://www.javaguides.net/2021/01/angular-spring-boot-rest-api-example.html

//https://stackoverflow.com/questions/46700055/angular-httpclient-map-get-method-object-result-to-array-property

//https://www.baeldung.com/spring-boot-angular-web

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/")
public class PersonExerciseController {

    private PersonExerciseService personExerciseService;

    @Autowired
    public PersonExerciseController(PersonExerciseService personExerciseService) {
        super();
        this.personExerciseService = personExerciseService;
    }

    @GetMapping("mattableh2")
    public List<PersonExercise> getUsers() {
        //return this.exerciseService.list();
        List<PersonExercise> personExerciseList = new ArrayList<PersonExercise>();
//        Exercise e1 = new PersonExercise;
//        e1.setId(1L);
//        e1.setCalories(3L);
//        e1.setName("name");
//        e1.setDuration(2L);
//        exercises.add(e1);
//        exercises.add(e1);
        return personExerciseList;
    }

    @RequestMapping("/mattableh2/exercises")
    public List<PersonExercise> list(Model model) {

        List<PersonExercise> list;

//        TODO This works fine
//        List<Exercise> exercises = new ArrayList<Exercise>();
//        Exercise e1 = new Exercise();
//        e1.setId(1L);
//        e1.setCalories(3L);
//        e1.setName("name");
//        e1.setDuration(2L);
//        exercises.add(e1);
//        exercises.add(e1);
//        return exercises;

        list =  personExerciseService.list();
        return  list;
    }

    @RequestMapping("/mattableh2/exercise")
    public PersonExerciseDTO getPersonExercise(Model model) {

        return personExerciseService.getPersonExerciseById();

    }

    @PutMapping("/mattableh2/exercise/updatePersonExersice")
    public PersonExerciseDTO updateStudent(@RequestBody PersonExerciseDTO personExerciseDTO) {

        return personExerciseService.updatePersonExercise(personExerciseDTO);
    }

}
