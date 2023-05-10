package com.db.h2.console.controller;

import com.db.h2.console.domain.Login;
import com.db.h2.console.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/")
public class LoginController {

    private LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        super();
        this.loginService = loginService;
    }


    @RequestMapping("/fitness/default-login")
    public Login buildDefaultLogin(Model model) {
        return this.loginService.buildDefaultLogin();
    }

}
