package com.db.h2.console.controller;

import com.db.h2.console.domain.Login;
import com.db.h2.console.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/fitness")
//@Controller
public class LoginController {

    private LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        super();
        this.loginService = loginService;
    }


//    @RequestMapping("/mattableh2/exercise")
//    public PersonExerciseDTO getPersonExercise(Model model) {
//
//        return personExerciseService.getPersonExercise();
//
//    }

    @RequestMapping("/defaultlogin")
    public Login buildDefaultLogin() {
        return loginService.buildDefaultLogin();
    }

}
