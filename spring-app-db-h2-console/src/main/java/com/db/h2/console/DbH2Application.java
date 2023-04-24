package com.db.h2.console;

import com.db.h2.console.domain.Exercise;
import com.db.h2.console.domain.PersonExercise;
import com.db.h2.console.repository.ExerciseRepository;
import com.db.h2.console.repository.PersonExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Original without "implements CommandLineRunner"
 */
@SpringBootApplication
public class DbH2Application implements CommandLineRunner {

//    public static void main(String[] args) {
//        SpringApplication.run(DbH2Application.class, args);
//    }

    public static void main(String[] args) {
        SpringApplication.run(DbH2Application.class, args);
    }

    @Autowired
    private ExerciseRepository exerciseRepository;

    @Autowired
    private PersonExerciseRepository personExerciseRepository;

    @Override
    public void run(String... args) throws Exception {
//        this.exerciseRepository.save(new Exercise(1L, "Ramesh1", 26L, 333L));
//        this.exerciseRepository.save(new Exercise(2L, "Ramesh2", 200L, 344L));
//        this.exerciseRepository.save(new Exercise(3L, "Ramesh3", 2100L, 355L));
//        this.exerciseRepository.save(new Exercise(4L, "Ramesh4", 234L, 355L));

        PersonExercise personExercise = new PersonExercise(
                "Toni", "Duong", "cduong@test.com", new Date(),
                "Martins 11, 3261 Suberg", "Switzerland", "M");

        Exercise exercise1 = new Exercise("Ramesh1", 26L, 333L, personExercise);
        Exercise exercise2 = new Exercise("Ramesh2", 27L, 444L, personExercise);
        Exercise exercise3 = new Exercise("Ramesh3", 28L, 555L, personExercise);
        Exercise exercise4 = new Exercise("Ramesh4", 29L, 666L, personExercise);
        List<Exercise> exerciseList = Arrays.asList(exercise1, exercise2, exercise3, exercise4);
        personExercise.setExerciseList(exerciseList);
        this.personExerciseRepository.save(personExercise);
    }
}
