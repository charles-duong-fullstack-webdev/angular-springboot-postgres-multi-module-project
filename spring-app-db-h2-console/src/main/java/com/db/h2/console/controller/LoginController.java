package com.db.h2.console.controller;

import com.db.h2.console.DTO.LoginDTO;
import com.db.h2.console.domain.Login;
import com.db.h2.console.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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


    @RequestMapping("/defaultlogin")
    public Login buildDefaultLogin() {
        return loginService.buildDefaultLogin();
    }

    @PostMapping("/signup")
    public LoginDTO signupWithLogin(@Valid @RequestBody LoginDTO loginDTO) {
        //System.err.println("signupWithLogin: " + loginDTO);
        return loginService.sigupLogin(loginDTO);
    }


}
