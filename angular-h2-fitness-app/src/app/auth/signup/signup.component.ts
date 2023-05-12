import {Component, OnInit} from '@angular/core';
import {NgForm} from '@angular/forms';

import {AuthService} from '../auth.service';
import {RestApiService} from '../../service/rest-api-service';
import {LoginDTO} from '../../models/loginDTO';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
  maxDate;

  constructor(private authService: AuthService, private restApiService: RestApiService) {
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

  onGetDefaultLogin(form: NgForm) {
    this.restApiService.getDefaultLoginDTO().subscribe((loginDTO: LoginDTO) => {
      console.log('ngOnInit >> getDefaultLoginDTO id >>' + loginDTO.id);
      console.log('ngOnInit >> getDefaultLoginDTO userid >>' + loginDTO.userid);
      console.log('form.value.userid: ' + form.value.email);
      form.controls['email'].setValue(loginDTO.userid);
      form.controls['password'].setValue(loginDTO.password);
      form.controls['birthday'].setValue(loginDTO.birthday);
    });
  }

}
