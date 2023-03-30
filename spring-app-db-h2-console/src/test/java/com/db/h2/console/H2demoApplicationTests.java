package com.db.h2.console;

import com.db.h2.console.domain.Post;
import com.db.h2.console.repository.PostRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest
class H2demoApplicationTests {

    @Autowired
    private PostRepository postRepository;

    @Test
    void contextLoads() {
    }


    @Test
    public void givenGenericEntityRepository_whenSaveAndRetreiveEntity_thenOK() {
        Post post = postRepository.findBySlug("grails-is-awesome");
        assertNotNull(post);
        assertEquals(post.getAuthor().toString(), "Author [firstName=Dan, lastName=Vega]");
        System.out.println("===> postRepository.findBySlug(\"grails-is-awesome\"): " + post.toString());
    }

}
