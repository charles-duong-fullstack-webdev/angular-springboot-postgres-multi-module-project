package com.db.h2.console;

import com.db.h2.console.domain.Exercise;
import com.db.h2.console.domain.PersonExercise;
import com.db.h2.console.domain.Post;
import com.db.h2.console.repository.ExerciseRepository;
import com.db.h2.console.repository.PersonExerciseRepository;
import com.db.h2.console.repository.PostRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest()
@TestPropertySource(locations="classpath:application-test.properties")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//@EnableConfigurationProperties
//@TestPropertySource(locations= "classpath:application-test.properties")
@Sql({ "/testscripts/schema-h2.sql"})
@Sql(value  = "/testscripts/data-h2.sql")
@ExtendWith(SpringExtension.class)
class H2demoApplicationTests {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private PersonExerciseRepository personExerciseRepository;

    @Autowired
    private ExerciseRepository exerciseRepository;
    @Test
    void contextLoads() {
    }


    @Test
    @Disabled
    public void givenGenericEntityRepository_whenSaveAndRetreiveEntity_thenOK() {
        Post post = postRepository.findBySlug("grails-is-awesome");
        assertNotNull(post);
        assertEquals(post.getAuthor().toString(), "Author [firstName=Dan, lastName=Vega]");
        System.out.println("===> postRepository.findBySlug(\"grails-is-awesome\"): " + post.toString());
    }

    @Test
    public void givenPersonExerciseEntityRepository_whenSaveAndRetreiveEntity_thenOK() {
        List<PersonExercise> personExerciseList = personExerciseRepository.findAll();
        assertNotNull(personExerciseList);
        assertEquals(personExerciseList.get(0).getCountry(), "swiss");
        System.out.println("===> personExerciseList.get(0) >>" + personExerciseList.get(0).toString());

        List<Exercise> exerciseList = exerciseRepository.findAll();
        System.out.println("===> exerciseList.get(0) >> " + exerciseList.get(0).toString());
        System.out.println("===> exerciseList.size >>" + exerciseList.size());
    }

}

