package com.db.h2.console.controller;

import com.db.h2.console.domain.Exercise;
import com.db.h2.console.service.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

//https://www.javaguides.net/2021/01/angular-spring-boot-rest-api-example.html

//https://stackoverflow.com/questions/46700055/angular-httpclient-map-get-method-object-result-to-array-property

//https://www.baeldung.com/spring-boot-angular-web

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/")
public class ExerciseController {

    private ExerciseService exerciseService;

    @Autowired
    public ExerciseController(ExerciseService exerciseService) {
        super();
        this.exerciseService = exerciseService;
    }

    @GetMapping("mattableh2")
    public List<Exercise> getUsers() {
        //return this.exerciseService.list();
        List<Exercise> exercises = new ArrayList<Exercise>();
        Exercise e1 = new Exercise();
        e1.setId(1L);
        e1.setCalories(3L);
        e1.setName("name");
        e1.setDuration(2L);
        exercises.add(e1);
        exercises.add(e1);
        return exercises;
    }

    @RequestMapping("/mattableh2/exercises")
    public List<Exercise> list(Model model) {
        List<Exercise> exercises = new ArrayList<Exercise>();
        Exercise e1 = new Exercise();
        e1.setId(1L);
        e1.setCalories(3L);
        e1.setName("name");
        e1.setDuration(2L);
        exercises.add(e1);
        exercises.add(e1);

        //model.addAttribute("exercises", exercises);
        //model.addAttribute("exercises", exerciseService.list());
        return exercises;
    }

}
