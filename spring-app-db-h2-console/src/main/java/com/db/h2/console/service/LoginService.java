package com.db.h2.console.service;

import com.db.h2.console.domain.Exercise;
import com.db.h2.console.domain.Login;
import com.db.h2.console.repository.ExerciseRepository;
import com.db.h2.console.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


}
