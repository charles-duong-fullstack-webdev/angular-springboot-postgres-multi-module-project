package com.db.h2.console.controller;

import com.db.h2.console.DTO.PersonExerciseDTO;
import com.db.h2.console.domain.PersonExercise;
import com.db.h2.console.service.PersonExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

        list = personExerciseService.list();
        return list;
    }

    @RequestMapping("/mattableh2/exercise")
    public PersonExerciseDTO getPersonExercise(Model model) {

        return personExerciseService.getPersonExercise();

    }

    @RequestMapping(value = "/mattableh2/exercise/delete/personId/{perId}/exserciseId/{exId}", method = RequestMethod.DELETE)
    public PersonExerciseDTO deletePersonExercise(@PathVariable Long perId, @PathVariable Long exId) {
        System.err.println("PersonExerciseController deletePersonExercise >> perId: "+perId);
        System.err.println("PersonExerciseController deletePersonExercise >> exId: "+exId);
        return personExerciseService.deleteExercise(perId, exId);
    }

    @PutMapping("/mattableh2/exercise/updatePersonExersice")
    public PersonExerciseDTO updatePersonExercise(@RequestBody PersonExerciseDTO personExerciseDTO) {

        return personExerciseService.updatePersonExercise(personExerciseDTO);
    }

}
