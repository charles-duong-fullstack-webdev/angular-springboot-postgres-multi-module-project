package com.db.h2.console.controller;

import com.db.h2.console.domain.Login;
import com.db.h2.console.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
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

    @PostMapping("/signupError")
    public Login signupWithLoginOkNull(Login login){
        System.err.println("signupWithLogin: "+login);
        //signupWithLogin: Login{id=null, userid='null', password='null', birthday='null', createdBy='null', createdDate='null', modifiedBy='null', modifiedDate='null'}
        //sigupLogin: Login{id=null, userid='null', password='null', birthday='null', createdBy='null', createdDate='null', modifiedBy='null', modifiedDate='null'}
        return loginService.sigupLogin(login);
    }

    @PostMapping("/signup")
    public Login signupWithLogin(@Valid @RequestBody Login login){
        System.err.println("signupWithLogin: "+login);
        //signupWithLogin: Login{id=null, userid='null', password='null', birthday='null', createdBy='null', createdDate='null', modifiedBy='null', modifiedDate='null'}
        //sigupLogin: Login{id=null, userid='null', password='null', birthday='null', createdBy='null', createdDate='null', modifiedBy='null', modifiedDate='null'}
        return loginService.sigupLogin(login);
    }

//    @PostMapping("/response")
//    @ResponseBody
//    public ResponseTransfer postResponseController(
//            @RequestBody LoginForm loginForm) {
//        return new ResponseTransfer("Thanks For Posting!!!");
//    }

//    @PostMapping(value = "/posts")
//    public ResponseEntity<Post> createPost(HttpServletRequest request,
//                                           UriComponentsBuilder uriComponentsBuilder) {
//    }

}
