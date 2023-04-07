package com.db.h2.console;

import com.db.h2.console.domain.Exercise;
import com.db.h2.console.repository.ExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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

    @Override
    public void run(String... args) throws Exception {
        this.exerciseRepository.save(new Exercise(1L, "Ramesh1", 26L, 333L));
        this.exerciseRepository.save(new Exercise(2L, "Ramesh2", 200L, 344L));
        this.exerciseRepository.save(new Exercise(3L, "Ramesh3", 2100L, 355L));
        this.exerciseRepository.save(new Exercise(4L, "Ramesh4", 234L, 355L));
    }
}
