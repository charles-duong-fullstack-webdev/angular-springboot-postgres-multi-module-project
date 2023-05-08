package com.db.h2.console.service;

import com.db.h2.console.domain.Exercise;
import com.db.h2.console.repository.ExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class LoginService {

    private ExerciseRepository exerciseRepository;

    @Autowired
    public LoginService(ExerciseRepository ExerciseRepository) {
        this.exerciseRepository = ExerciseRepository;
    }


    public List<Exercise> list() {
        return exerciseRepository.findAll();
    }


}
