package com.db.h2.console;

import com.db.h2.console.DTO.ExerciseDTO;
import com.db.h2.console.domain.BiManyToOneExample;
import com.db.h2.console.domain.BiOneToManyExample;
import com.db.h2.console.domain.Exercise;
import com.db.h2.console.domain.PersonExercise;
import com.db.h2.console.repository.BiOneToManyRepository;
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

    @Autowired
    private BiOneToManyRepository biOneToManyRepository;

    @Override
    public void run(String... args) throws Exception {
        insertDataToPersonExerciseTable();
        insertDataToBiOneToManyExampleTable();
    }

    private void insertDataToPersonExerciseTable() {
        //        this.exerciseRepository.save(new Exercise(1L, "Ramesh1", 26L, 333L));
//        this.exerciseRepository.save(new Exercise(2L, "Ramesh2", 200L, 344L));
//        this.exerciseRepository.save(new Exercise(3L, "Ramesh3", 2100L, 355L));
//        this.exerciseRepository.save(new Exercise(4L, "Ramesh4", 234L, 355L));

        PersonExercise personExercise = new PersonExercise(
                "Toni", "Duong", "cduong@test.com", new Date(),
                "Martins 11, 3261 Suberg", "Switzerland", "M");

        Exercise exercise1 = new Exercise("Ramesh1", 26L, 333L);
        Exercise exercise2 = new Exercise("Ramesh2", 27L, 444L);
        Exercise exercise3 = new Exercise("Ramesh3", 28L, 555L);
        Exercise exercise4 = new Exercise("Ramesh4", 29L, 666L);
        Exercise saveExercise1 = this.exerciseRepository.save(exercise1);
        Exercise saveExercise2 = this.exerciseRepository.save(exercise2);
        Exercise saveExercise3 = this.exerciseRepository.save(exercise3);
        Exercise saveExercise4 = this.exerciseRepository.save(exercise4);
        personExercise.setExercise(saveExercise1);
        this.personExerciseRepository.save(personExercise);
        personExercise.setExercise(saveExercise2);
        this.personExerciseRepository.save(personExercise);
        personExercise.setExercise(saveExercise3);
        this.personExerciseRepository.save(personExercise);
        personExercise.setExercise(saveExercise4);
        this.personExerciseRepository.save(personExercise);

        List<PersonExercise> allPersonExercise = this.personExerciseRepository.findAll();
        PersonExercise personExercise1 = allPersonExercise.get(0);
        PersonExercise personExercise2 = this.personExerciseRepository.getPersonExerciseById(personExercise1.getId());
        System.err.println("personExercise1.getId() >> "+personExercise2.getId());

        List<Exercise> allExercise = this.exerciseRepository.getExercisesByIdExists(personExercise2.getId());
        System.err.println("allExercise.get(0).getId() >> "+allExercise.get(0).getId());
        ExerciseDTO exerciseDTO = new ExerciseDTO();

//        System.err.println("personExercise1.getAddress() >> "+personExercise2.getAddress());
//        System.err.println("personExercise1.getId() >> "+personExercise2.getExercise().getCalories());
    }

    private void insertDataToBiOneToManyExampleTable() {
        BiOneToManyExample biOneToManyExample = new BiOneToManyExample(
                "Toni", "Duong", "cduong@test.com", new Date(),
                "Martins 11, 3261 Suberg", "Switzerland", "M");

        BiManyToOneExample biM2OEx1 = new BiManyToOneExample("Ramesh1", 26L, 333L, biOneToManyExample);
        BiManyToOneExample biM2OEx2 = new BiManyToOneExample("Ramesh2", 27L, 444L, biOneToManyExample);
        BiManyToOneExample biM2OEx3 = new BiManyToOneExample("Ramesh3", 28L, 555L, biOneToManyExample);
        BiManyToOneExample biM2OEx4 = new BiManyToOneExample("Ramesh4", 29L, 666L, biOneToManyExample);
        List<BiManyToOneExample> biManyToOneExampleList = Arrays.asList(biM2OEx1, biM2OEx2, biM2OEx3, biM2OEx4);
        biOneToManyExample.setBiManyToOneExampleList(biManyToOneExampleList);
        this.biOneToManyRepository.save(biOneToManyExample);
    }
}
