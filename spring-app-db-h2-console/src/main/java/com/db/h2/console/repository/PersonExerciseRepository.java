package com.db.h2.console.repository;

import com.db.h2.console.domain.Exercise;
import com.db.h2.console.domain.PersonExercise;
import com.db.h2.console.domain.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonExerciseRepository extends CrudRepository<PersonExercise, Long> {
    List<PersonExercise> findAll();

    PersonExercise getPersonExerciseById(Long id);

}
