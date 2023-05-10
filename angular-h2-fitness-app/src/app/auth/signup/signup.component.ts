import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';

import { AuthService } from '../auth.service';
import {RestApiService} from "../../service/rest-api-service";

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
  maxDate;

  constructor(private authService: AuthService, private restApiService: RestApiService) { }


  ngOnInit() {
     this.restApiService.getPersonExerciseDTO().subscribe((getPersonExcerciseDTO: Login) => {
      console.log('ngOnInit >> getPersonExcerciseDTO id >>' + getPersonExcerciseDTO.id);
      console.log('ngOnInit >> getPersonExcerciseDTO firstName >>' + getPersonExcerciseDTO.firstName);
      this.setupTableDataSource(getPersonExcerciseDTO);
    });
  }

  ngOnInit() {
    this.maxDate = new Date();
    this.maxDate.setFullYear(this.maxDate.getFullYear() - 18);
  }

  onSubmit(form: NgForm) {
    this.authService.registerUser({
      email: form.value.email,
      password: form.value.password
    });
  }

  onSetDefaultLogin() {
    // email: form.value.email,
    //   password: form.value.password
  }

}
