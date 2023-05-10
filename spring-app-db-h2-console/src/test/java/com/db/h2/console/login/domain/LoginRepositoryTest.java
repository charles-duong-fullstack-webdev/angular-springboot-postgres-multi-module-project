package com.db.h2.console.login.domain;

import com.db.h2.console.domain.Login;
import com.db.h2.console.repository.LoginRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;
import java.util.List;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.assertj.core.api.AssertionsForClassTypes.within;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
//import static org.junit.jupiter.api.Assertions.assertEquals;

//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE, classes = {TestHsqlConfiguration.class})
@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Sql({"/testscripts/schema-h2.sql"})
@Sql(value = "/testscripts/data-h2.sql")
@ExtendWith(SpringExtension.class)
class LoginRepositoryTest {

    @Autowired
    private LoginRepository loginRepository;

    @Autowired
    private EntityManager entityManager;

    private Login login1, login2, login3;
    //@Autowired
    //private AssertTrueValidator assertTrue;


    @BeforeEach
    public void init() {
        loginRepository.deleteAll();

        Long maxId = loginRepository.getMaxLoginId();
        String user = "test%s@test.com";
        String password = "test%s@test.com";
        if (maxId == null) {
            maxId = 1L;
        }

        login1 = loginRepository.save(createLogin(
                String.format(user, maxId), String.format(password, maxId++)));

        login2 = loginRepository.save(createLogin(
                String.format(user, maxId), String.format(password, maxId++)));

        login3 = loginRepository.save(createLogin(
                String.format(user, maxId), String.format(password, maxId++)));

    }

    @Test
    @Transactional
    public void findAllOrderById() {

        List<Login> logins = loginRepository.findAll();


        for (Login login : logins) {
            System.out.print(login);
        }

        Assertions.assertEquals(3, logins.size());
        assertThat(logins, containsInAnyOrder(login1, login2, login3));

        Assertions.assertEquals(logins.get(0).getId(), login1.getId());
        Assertions.assertEquals(logins.get(1).getId(), login2.getId());
        Assertions.assertEquals(logins.get(2).getId(), login3.getId());

        Assertions.assertNotNull(logins.get(0).getModifiedDate());
        Assertions.assertNotNull(logins.get(1).getModifiedDate());
        Assertions.assertNotNull(logins.get(2).getModifiedDate());

    }

    @Test
    @Transactional
    public void findLoginByExternalId_checkCorrectResults() {
//        assertThat(loginRepository.findLoginByExternalId("1111")).isEqualTo(Login1);
//        assertThat(loginRepository.findLoginByExternalId("3333")).isEqualTo(Login3);
//
//        assertThat(loginRepository.findLoginByExternalId("9999")).isNull();
    }

    @Test
    @Transactional
    public void findByClosedTimestamp_checkCorrectResults() {
//        assertThat(loginRepository.findByClosedTimestamp(LocalDateTime.parse("2019-02-01T00:00:00"))).containsExactly(Login1, Login2, Login3);
//        assertThat(loginRepository.findByClosedTimestamp(LocalDateTime.parse("2019-02-02T00:00:00"))).containsExactly(Login2, Login3);
//        assertThat(loginRepository.findByClosedTimestamp(LocalDateTime.parse("2019-02-03T00:00:00"))).containsExactly(Login2);
    }

    @Test
    @Transactional
    public void findByMutationTimestamp_checkCorrectResults() {
//        entityManager.createQuery("update Login f set f.mutationTimestamp = '2019-01-01 00:00:00' where f.externalId = '1111'").executeUpdate();
//        entityManager.createQuery("update Login f set f.mutationTimestamp = '2019-01-01 00:00:10' where f.externalId = '2222'").executeUpdate();
//        entityManager.createQuery("update Login f set f.mutationTimestamp = '2019-01-01 00:00:20' where f.externalId = '3333'").executeUpdate();
//
//        assertThat(loginRepository.findByMutationTimestamp(LocalDateTime.parse("2019-01-01T00:00:00"))).containsExactly(Login1, Login2, Login3);
//        assertThat(loginRepository.findByMutationTimestamp(LocalDateTime.parse("2019-01-01T00:00:20"))).containsExactly(Login3);
//        assertThat(loginRepository.findByMutationTimestamp(LocalDateTime.parse("2019-01-01T00:00:40"))).containsExactly();
    }


    private Login createLogin(String userid, String password) {
        Login login = new Login();
        login.setUserid(userid);
        login.setPassword(password);
        login.setCreatedBy("I-Am");
        login.setModifiedBy("I-Am");
        login.setCreatedDate(LocalDateTime.parse("2019-01-01T00:00:00"));
        login.setModifiedDate(LocalDateTime.parse("2019-01-01T00:00:00"));

        return login;
    }

}
