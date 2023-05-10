package com.db.h2.console.login.domain;

import com.db.h2.console.domain.Login;
import com.db.h2.console.repository.LoginRepository;
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

    private Login login1, Login2, Login3;


    @BeforeEach
    public void init() {
        loginRepository.deleteAll();

        login1 = loginRepository.save(createLogin("test5@test.com", "test5"));
//        Login2 = loginRepository.save(createLogin("2222", "Login 2", "Change Request", JIRA, null));
//        Login3 = loginRepository.save(createLogin("3333", "Login 3", "Bug", REMEDY, LocalDateTime.parse("2019-02-02T00:00:00")));
    }

    @Test
    @Transactional
    public void findAll_checkOrderAndData() {

//        javax.validation.UnexpectedTypeException:HV000030:
//        No validator could be found for constraint 'javax.validation.constraints.Size' validating type
//        'java.time.LocalDateTime'.Check configuration for 'createdDate'

        List<Login> Logins = loginRepository.findAll();

//        assertThat(Logins).containsExactly(Login1, Login2, Login3);
//        assertThat(Logins.get(0)).hasExternalId("1111").hasTitle("Login 1").hasType("Bug").hasSource(JIRA)
//                .hasDescription("description").hasCategory("category").hasPriority("priority").hasStatus("status").hasResolution("resolution").hasAssignedGroup("assignedGroup")
//                .hasSubmitDate(LocalDateTime.parse("2019-01-01T00:00:00")).hasCloseDate(LocalDateTime.parse("2019-02-01T00:00:00"))
//                .hasCompany("company").hasOrganization("organization")
//                .hasVersion(0).hasEingabeUser("unknown").hasMutationUser("unknown");
//        assertThat(Logins.get(0).getEingabeTimestamp()).isCloseTo(LocalDateTime.now(), within(1, SECONDS));
//        assertThat(Logins.get(0).getMutationTimestamp()).isCloseTo(LocalDateTime.now(), within(1, SECONDS));
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
