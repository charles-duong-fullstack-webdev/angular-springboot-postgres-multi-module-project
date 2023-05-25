import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';

import {AuthService} from '../../service/auth.service';
import {LoginDTO} from "../../models/loginDTO";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginForm: FormGroup;

  constructor(private authService: AuthService) {
  }

  ngOnInit() {
    this.loginForm = new FormGroup({
      email: new FormControl('', {
        validators: [Validators.required, Validators.email]
      }),
      password: new FormControl('', {validators: [Validators.required]})
    });
  }

  onSubmit() {
    const email = this.loginForm.get('email').value;
    const password = this.loginForm.get('password').value;
    console.log('onSubmit email >>' + email);
    console.log('onSubmit password >>' + password);
    this.authService.login(email, password).subscribe((isExist: Boolean) => {
      console.log('login >>' + isExist);
    });
  }

  onGetDefaultLogin() {
    this.authService.getDefaultLoginDTO().subscribe((loginDTO: LoginDTO) => {
      console.log('getDefaultLoginDTO id >>' + loginDTO.id);
      console.log('getDefaultLoginDTO userid >>' + loginDTO.userid);
      console.log('getDefaultLoginDTO password >>' + loginDTO.password);
      this.loginForm.get('email').setValue(loginDTO.userid);
      this.loginForm.get('password').setValue(loginDTO.password);
    });
  }
}

