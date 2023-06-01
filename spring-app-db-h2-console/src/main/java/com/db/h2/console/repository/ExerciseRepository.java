package com.db.h2.console.repository;

import com.db.h2.console.domain.Exercise;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
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

//    @Query(value = "INSERT INTO EXERCISE e (e.ID, e.NAME, e.DURATION, eCALORIES, PERSON_EXERCISE_ID  VALUES (NEXTVAL('exercise_sequence'), 'Burpees', 88, 8, perId)))
//    @Modifying
//    @Transactional
//    int insertExercise(Long perId, Long exId);

    @Modifying
    //@Query(value = "INSERT INTO EXERCISE  Person (id,name,age) select :id,:name,:age from Dual")
    @Query(value = "INSERT INTO EXERCISE (ID, NAME, DURATION, CALORIES, TRAINGDATE, STATE, PERSON_EXERCISE_ID)" +
            "VALUES (NEXTVAL('exercise_sequence'), :name, :duration, :calories, " +
            ":trainingDate, :state, :perId)", nativeQuery = true)
    @Transactional
    public int insertExercise(@Param("name") String name,
                              @Param("calories") Long calories,
                              @Param("duration") Long duration,
                              @Param("trainingDate") LocalDate trainingDate,
                              @Param("state") String state,
                              @Param("perId") Long perId);

//    @Modifying
//    @Query(value = "insert into Logger (redirect,user_id) VALUES (:insertLink,:id)", nativeQuery = true)
//    @Transactional
//    void logURI(@Param("insertLink") String insertLink, @Param("id") Long id);

    @Query(value = "SELECT e FROM Exercise e ORDER BY e.name")
    public List<Exercise> findAllSortedByName();

    @Query(value = "SELECT * FROM Exercise ORDER BY name", nativeQuery = true)
    public List<Exercise> findAllSortedByNameUsingNative();


}
