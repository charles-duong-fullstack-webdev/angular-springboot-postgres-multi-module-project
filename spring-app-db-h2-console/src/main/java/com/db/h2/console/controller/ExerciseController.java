package com.db.h2.console.controller;

import com.db.h2.console.DTO.ExerciseDTO;
import com.db.h2.console.DTO.PersonExerciseDTO;
import com.db.h2.console.domain.Exercise;
import com.db.h2.console.service.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//https://www.javaguides.net/2021/01/angular-spring-boot-rest-api-example.html

//https://stackoverflow.com/questions/46700055/angular-httpclient-map-get-method-object-result-to-array-property

//https://www.baeldung.com/spring-boot-angular-web

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/fitness/exercise")
public class ExerciseController {

    private ExerciseService exerciseService;

    @Autowired
    public ExerciseController(ExerciseService exerciseService) {
        super();
        this.exerciseService = exerciseService;
    }

    @GetMapping("fetchAvailableExercises")
    public List<ExerciseDTO> fetchAvailableExercises() {
        return this.exerciseService.listExercises();
    }

    @PostMapping("/addExercise")
    public List<ExerciseDTO> insertExercise(@RequestBody ExerciseDTO exerciseDTO) {
        return exerciseService.inserrExercise(exerciseDTO);
    }

}
