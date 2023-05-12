package com.db.h2.console.service;

import com.db.h2.console.domain.Login;
import com.db.h2.console.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


@Service
public class LoginService {

    private LoginRepository loginRepository;

    @Autowired
    public LoginService(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }


    public List<Login> list() {
        return loginRepository.findAll();
    }

    public Login buildDefaultLogin() {
        Long maxId = this.loginRepository.getMaxLoginId();
        String user = "test%s@test.com";
        String password = "test%s";
        if (maxId == null) {
            maxId = 0L;
        }
        maxId++;
        Login login = this.loginRepository.save(createLogin(
                String.format(user, maxId), String.format(password, maxId)));
        return login;
    }

    private Login createLogin(String userid, String password) {
        Login login = new Login();
        login.setUserid(userid);
        login.setPassword(password);
        login.setCreatedBy("I-Am");
        login.setModifiedBy("I-Am");
        login.setBirthday(LocalDate.of(1981, 12, 10));
        login.setCreatedDate(LocalDateTime.parse("2023-01-01T00:00:00"));
        login.setModifiedDate(LocalDateTime.of(2023, 5, 1,
                8, 0, 0));

        return login;
    }


}
