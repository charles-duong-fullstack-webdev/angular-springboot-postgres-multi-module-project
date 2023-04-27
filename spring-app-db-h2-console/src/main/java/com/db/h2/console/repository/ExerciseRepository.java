package com.db.h2.console.repository;

import com.db.h2.console.domain.Exercise;
import com.db.h2.console.domain.PersonExercise;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExerciseRepository extends CrudRepository<Exercise, Long> {
    List<Exercise> findAll();

    List<Exercise> getExercisesByIdExists(Long id);


}
