package com.db.h2.console.repository;

import com.db.h2.console.domain.Exercise;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ExerciseRepository extends CrudRepository<Exercise, Long> {
    List<Exercise> findAll();

    @Query(value = "SELECT e FROM Exercise e where e.personExercise.id = ?1 ORDER BY e.name")
    public List<Exercise> findAllExerciseById(Long id);

    @Query(value = "DELETE FROM Exercise e WHERE e.personExercise.id = :perId AND e.id = :exId")
    @Modifying
    @Transactional
    int deleteExerciseById(Long perId, Long exId);

    @Query(value = "SELECT e FROM Exercise e ORDER BY e.name")
    public List<Exercise> findAllSortedByName();

    @Query(value = "SELECT * FROM Exercise ORDER BY name", nativeQuery = true)
    public List<Exercise> findAllSortedByNameUsingNative();


}
