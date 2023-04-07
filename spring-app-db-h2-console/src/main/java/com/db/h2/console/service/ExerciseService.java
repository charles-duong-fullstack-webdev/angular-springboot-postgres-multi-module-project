package com.db.h2.console.service;

import com.db.h2.console.domain.Exercise;
import com.db.h2.console.repository.ExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ExerciseService {

    private ExerciseRepository exerciseRepository;

    @Autowired
    public ExerciseService(ExerciseRepository ExerciseRepository) {
        this.exerciseRepository = ExerciseRepository;
    }

//    public Exercise getLatestExercise() {
//        return ExerciseRepository.findFirstByOrderByExerciseedOnDesc();
//    }

    public List<Exercise> list() {
        return exerciseRepository.findAll();
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
