package com.db.h2.console.repository;

import com.db.h2.console.domain.Exercise;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExerciseRepository extends CrudRepository<Exercise, Long> {
    List<Exercise> findAll();

    //public List<Exercise> findByIdIs(Long id);

    //@Query("select new com.foo.bar.entity.Document(d.docId, d.filename) from Document d where d.filterCol = ?1")
    //@Query("SELECT e FROM Exercise where id = ?1 ORDER BY name")
    @Query(value = "SELECT e FROM Exercise e where e.id = ?1 ORDER BY e.name")
    public List<Exercise> findAllExerciseById(Long id);
    @Query(value = "SELECT e FROM Exercise e ORDER BY e.name")
    public List<Exercise> findAllSortedByName();

    @Query(value = "SELECT * FROM Exercise ORDER BY name", nativeQuery = true)
    public List<Exercise> findAllSortedByNameUsingNative();


}
