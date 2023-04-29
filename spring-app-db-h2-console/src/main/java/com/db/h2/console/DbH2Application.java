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
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
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

    @Override
    public void run(String... args) throws Exception {
        Long personExerciseId = insertDataToPersonExerciseTable();
        selectDataFromPersonExerciseTableAndConvertToDTO(personExerciseId);
        insertDataToBiOneToManyExampleTable();
    }

    private Long insertDataToPersonExerciseTable() {
        //        this.exerciseRepository.save(new Exercise(1L, "Ramesh1", 26L, 333L));
//        this.exerciseRepository.save(new Exercise(2L, "Ramesh2", 200L, 344L));
//        this.exerciseRepository.save(new Exercise(3L, "Ramesh3", 2100L, 355L));
//        this.exerciseRepository.save(new Exercise(4L, "Ramesh4", 234L, 355L));

        PersonExercise personExercise = new PersonExercise(
                "Toni", "Duong", "cduong@test.com", new Date(),
                "Martins 11, 3261 Suberg", "Switzerland", "M");

        this.personExerciseRepository.save(personExercise);
        System.err.println("personExercise.getId() >> " + personExercise.getId());

        Exercise exercise1 = new Exercise("Ramesh1", 26L, 333L);
        Exercise exercise2 = new Exercise("Ramesh2", 27L, 444L);
        Exercise exercise3 = new Exercise("Ramesh3", 28L, 555L);
        Exercise exercise4 = new Exercise("Ramesh4", 29L, 666L);

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
     *
     * ModelMapper uses TypeToken to map generic types. To see why this is necessary,
     * let's see what happens when we map an Integer list to a Character list:
     *
     * List<Integer> integers = new ArrayList<Integer>();
     * integers.add(1);
     * integers.add(2);
     * integers.add(3);
     *
     * List<Character> characters = new ArrayList<Character>();
     * modelMapper.map(integers, characters);
     * Copy
     * Further, if we print out the elements of the characters list we would see an empty list.
     * This is due to the occurrence of type erasure during runtime execution.
     *
     * If we change our map call to use TypeToken, though, we can create a type literal for List<Character>:
     *
     * List<Character> characters
     *     = modelMapper.map(integers, new TypeToken<List<Character>>() {}.getType());
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

        /**
         * Use Type Token
         * see https://www.baeldung.com/java-modelmapper-lists
         */

        // Without using "Type Token" will give 0 size (exerciseDTOs.size >> 0)
        List<ExerciseDTO> exerciseDTOs = new ArrayList<ExerciseDTO>();
        modelMapper.map(exerciseENTITYs, exerciseDTOs);
        System.err.println("exerciseDTOs.size >> " + exerciseDTOs.size());


        // Use "Type Token" will give 4 size (exerciseDTOTypeTokens.size >> 4)
        List<ExerciseDTO> exerciseDTOTypeTokens = modelMapper.map(exerciseENTITYs,
                new TypeToken<List<ExerciseDTO>>() {
                }.getType());
        // Sucessful: exerciseDTOTypeTokens.size >> 4
        System.err.println("exerciseDTOTypeTokens.size >> " + exerciseDTOTypeTokens.size());
        System.err.println("exerciseDTOTypeTokens >> " + exerciseDTOTypeTokens);

        //PersonExerciseDTO personExerciseDTO = new PersonExerciseDTO();
        PersonExerciseDTO personExerciseDTO = modelMapper.map(personExercise, PersonExerciseDTO.class);
        System.err.println("personExerciseDTO.getId >> " + personExerciseDTO.getId());
        personExerciseDTO.setExerciseList(exerciseDTOTypeTokens);
        System.err.println("personExerciseDTO >> " + personExerciseDTO);



// =============================================================================
//        2.2. Type Token
//        ModelMapper uses TypeToken to map generic types. To see why this is necessary, let's see what happens when we map an Integer list to a Character list:
//
//        List<Integer> integers = new ArrayList<Integer>();
//        integers.add(1);
//        integers.add(2);
//        integers.add(3);
//
//        List<Character> characters = new ArrayList<Character>();
//        modelMapper.map(integers, characters);
//        Copy
//        Further, if we print out the elements of the characters list we would see an empty list. This is due to the occurrence of type erasure during runtime execution.
//
//        If we change our map call to use TypeToken, though, we can create a type literal for List<Character>:
//
//        List<Character> characters
//                = modelMapper.map(integers, new TypeToken<List<Character>>() {}.getType());
//        Copy
//        At compile time, the TokenType anonymous inner case preserves the List<Character> parameter type, and this time our conversion is successful.
// =============================================================================
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
