package com.radinfodesign.fboace04a.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping ("/")
public class FBOAceController {

  @GetMapping("")
  public String welcome() {
    return "Welcome to the FBOAce04a Webservice!";
  }

}
