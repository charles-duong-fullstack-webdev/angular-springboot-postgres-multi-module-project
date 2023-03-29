package com.db.h2.console;

import com.db.h2.console.domain.Post;
import com.db.h2.console.repository.PostRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(classes = Application.class)
//@WebAppConfiguration
//public class H2demoApplicationTests {
//
//	@Test
//	public void contextLoads() {
//	}
//
//}


@SpringBootTest
class H2demoApplicationTests {

    @Autowired
    private PostRepository postRepository;

    @Test
    void contextLoads() {
    }


    @Test
    public void givenGenericEntityRepository_whenSaveAndRetreiveEntity_thenOK() {
//        Author author = new Author("ffff","ddddd","fgfgfgf");
//        Post newPost = new Post();
//        newPost.setActive(true);
//        newPost.setPostedOn(new Date());
//        newPost.setAuthor(author);
//        newPost.setSlug("slug");
//        newPost.setBody("body");
//        newPost.setKeywords(null);
//        newPost.setTitle("title");
//        Post post = postRepository.save(newPost);

//        Post post = postRepository.findBySlug("grails-is-awesome");
//
//        assertNotNull(post);
//        //assertEquals(post.getAuthor(), foundEntity.get.getValue());
//        System.out.println(post.toString());
    }

}

