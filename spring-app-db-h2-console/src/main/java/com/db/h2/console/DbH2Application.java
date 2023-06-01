package com.db.h2.console;

import com.db.h2.console.DTO.ExerciseDTO;
import com.db.h2.console.DTO.PersonExerciseDTO;
import com.db.h2.console.domain.BiManyToOneExample;
import com.db.h2.console.domain.BiOneToManyExample;
import com.db.h2.console.domain.Exercise;
import com.db.h2.console.domain.PersonExercise;
import com.db.h2.console.repository.BiOneToManyRepository;
import com.db.h2.console.repository.ExerciseRepository;
import com.db.h2.console.repository.PersonExerciseRepository;
import entityToDTO.ExerciseEntityToDTO;
import entityToDTO.PersonExerciseEntityToDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
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

    private static final ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private ExerciseRepository exerciseRepository;

    @Autowired
    private PersonExerciseRepository personExerciseRepository;

    @Autowired
    private BiOneToManyRepository biOneToManyRepository;

    /**
     * By using the insertDataToTables() @see "application-automation-loader.properties"
     * ----
     * Now we use @see "application.properties" by using *.sql to load data to Database (H2)
     * spring.jpa.hibernate.ddl-auto=none
     * spring.datasource.schema=classpath:scripts/schema-h2.sql
     * spring.datasource.data=classpath:scripts/data-h2.sql
     */
    @Override
    public void run(String... args) throws Exception {
        //this.insertDataToTables();
    }

    private void insertDataToTables() {
        Long personExerciseId = insertDataToPersonExerciseTable();
        selectDataFromPersonExerciseTableAndConvertToDTO(personExerciseId);
        insertDataToBiOneToManyExampleTable();
    }

    private Long insertDataToPersonExerciseTable() {
        PersonExercise personExercise = new PersonExercise(
                "Toni", "Duong", "cduong@test.com", new Date(),
                "Martins 11, 3261 Suberg", "Switzerland", "M");

        this.personExerciseRepository.save(personExercise);
        System.err.println("personExercise.getId() >> " + personExercise.getId());

        Exercise exercise1 = new Exercise("Ramesh1", 26L, 333L, LocalDate.of(1981, 12, 10), "complete");
        Exercise exercise2 = new Exercise("Ramesh2", 27L, 444L, LocalDate.of(1981, 12, 10), "complete");
        Exercise exercise3 = new Exercise("Ramesh3", 28L, 555L, LocalDate.of(1981, 12, 10), "complete");
        Exercise exercise4 = new Exercise("Ramesh4", 29L, 666L, LocalDate.of(1981, 12, 10), "cancel");

        exercise1.setPersonExercise(personExercise);
        exercise2.setPersonExercise(personExercise);
        exercise3.setPersonExercise(personExercise);
        exercise4.setPersonExercise(personExercise);

        Exercise saveExercise1 = this.exerciseRepository.save(exercise1);
        Exercise saveExercise2 = this.exerciseRepository.save(exercise2);
        Exercise saveExercise3 = this.exerciseRepository.save(exercise3);
        Exercise saveExercise4 = this.exerciseRepository.save(exercise4);
        System.err.println("saveExercise1.getId() >> " + saveExercise1.getId());
        System.err.println("saveExercise2.getId() >> " + saveExercise2.getId());
        System.err.println("saveExercise3.getId() >> " + saveExercise3.getId());
        System.err.println("saveExercise4.getId() >> " + saveExercise4.getId());

        return personExercise.getId();

    }

    /**
     * 2.2. Type Token
     * see https://www.baeldung.com/java-modelmapper-lists
     * <p>
     * ModelMapper uses TypeToken to map generic types. To see why this is necessary,
     * let's see what happens when we map an Integer list to a Character list:
     * <p>
     * List<Integer> integers = new ArrayList<Integer>();
     * integers.add(1);
     * integers.add(2);
     * integers.add(3);
     * <p>
     * List<Character> characters = new ArrayList<Character>();
     * modelMapper.map(integers, characters);
     * Copy
     * Further, if we print out the elements of the characters list we would see an empty list.
     * This is due to the occurrence of type erasure during runtime execution.
     * <p>
     * If we change our map call to use TypeToken, though, we can create a type literal for List<Character>:
     * <p>
     * List<Character> characters
     * = modelMapper.map(integers, new TypeToken<List<Character>>() {}.getType());
     * Copy
     * At compile time, the TokenType anonymous inner case preserves the List<Character> parameter type,
     * and this time our conversion is successful.
     */
    private void selectDataFromPersonExerciseTableAndConvertToDTO(Long personExerciseId) {
        //List<PersonExercise> allPersonExercise = this.personExerciseRepository.findAll(); //OK
        PersonExercise personExercise = this.personExerciseRepository.getPersonExerciseById(personExerciseId);
        System.err.println("personExercise.getId() >> " + personExercise.getId());
        System.err.println("personExercise >> " + personExercise);

        List<Exercise> exerciseENTITYs = this.exerciseRepository.findAllExerciseById(personExercise.getId());
        System.err.println("exerciseENTITYs.size() >> " + exerciseENTITYs.size());
        System.err.println("exerciseENTITYs >> " + exerciseENTITYs);

        ExerciseEntityToDTO exerciseEntityToDTO = new ExerciseEntityToDTO();
        List<ExerciseDTO> exerciseDTOs = exerciseEntityToDTO.convertExercise(exerciseENTITYs);
        System.err.println("exerciseDTOTypeTokens >> " + exerciseDTOs);

        PersonExerciseEntityToDTO personExerciseEntityToDTO = new PersonExerciseEntityToDTO();
        PersonExerciseDTO personExerciseDTO = personExerciseEntityToDTO.convertPersonExercise(personExercise);
        System.err.println("personExerciseDTO >> " + personExerciseDTO);

        personExerciseDTO.setExerciseDTOs(exerciseDTOs);
        System.err.println("personExerciseDTO >> " + personExerciseDTO);

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
