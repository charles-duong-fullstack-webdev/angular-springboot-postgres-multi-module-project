package com.db.h2.console.service;

import com.db.h2.console.domain.Login;
import com.db.h2.console.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        String password = "test%s@test.com";
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
        login.setCreatedDate(LocalDateTime.parse("2019-01-01T00:00:00"));
        login.setModifiedDate(LocalDateTime.parse("2019-01-01T00:00:00"));

        return login;
    }


}
