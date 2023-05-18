import {Component, OnInit} from '@angular/core';
import {NgForm} from '@angular/forms';

import {AuthService} from '../../service/auth.service';
import {RestApiService} from '../../service/rest-api-service';
import {LoginDTO} from '../../models/loginDTO';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
  maxDate;
  signupLoginDTO: LoginDTO = new LoginDTO();

  constructor(private authService: AuthService, private restApiService: RestApiService) {
  }

  ngOnInit() {
    this.maxDate = new Date();
    this.maxDate.setFullYear(this.maxDate.getFullYear() - 18);

  }

  onSubmit(form: NgForm) {
    // this.authService.registerUser({
    //   email: form.value.email,
    //   password: form.value.password
    // });
    this.signupLoginDTO.userid = form.value.email;
    this.signupLoginDTO.password = form.value.password;
    this.signupLoginDTO.birthday = form.value.birthday;
    console.log('onSubmit id >>' + this.signupLoginDTO.id);
    console.log('onSubmit userid >>' + this.signupLoginDTO.userid);
    console.log('onSubmit form.value.email: ' + this.signupLoginDTO.userid);
    this.restApiService.registerUser(this.signupLoginDTO).subscribe((loginDTO: LoginDTO) => {
      console.log('onSubmit this.restApiService.signupByLoginInfo id >>' + loginDTO.id);
      console.log('onSubmit this.restApiService.signupByLoginInfo userid >>' + loginDTO.userid);
      console.log('onSubmit this.restApiService.signupByLoginInfo form.value.email: ' + form.value.email);
      form.controls['email'].setValue(loginDTO.userid);
      form.controls['password'].setValue(loginDTO.password);
      form.controls['birthday'].setValue(loginDTO.birthday);
    });
  }

  onGetDefaultLogin(form: NgForm) {
    this.restApiService.getDefaultLoginDTO().subscribe((loginDTO: LoginDTO) => {
      console.log('onGetDefaultLogin id >>' + loginDTO.id);
      console.log('onGetDefaultLogin userid >>' + loginDTO.userid);
      console.log('onGetDefaultLogin form.value.email: ' + form.value.email);
      form.controls['email'].setValue(loginDTO.userid);
      form.controls['password'].setValue(loginDTO.password);
      form.controls['birthday'].setValue(loginDTO.birthday);
    });
  }

}
