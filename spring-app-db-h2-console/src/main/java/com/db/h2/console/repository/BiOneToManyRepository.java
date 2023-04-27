package com.db.h2.console.repository;

import com.db.h2.console.domain.BiOneToManyExample;
import com.db.h2.console.domain.PersonExercise;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BiOneToManyRepository extends CrudRepository<BiOneToManyExample, Long> {
    List<BiOneToManyExample> findAll();

}
