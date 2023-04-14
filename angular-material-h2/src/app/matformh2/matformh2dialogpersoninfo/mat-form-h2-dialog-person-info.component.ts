import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-mat-form-h2-dialog-person-info',
  templateUrl: './mat-form-h2-dialog-person-info.component.html',
  styleUrls: ['./mat-form-h2-dialog-person-info.component.css']
})
export class MatFormH2DialogPersonInfoComponent implements OnInit {

  private exercisePersonInfo =
    {
      name: 'Charles', email: 'chares@gmail.com', dob: '30.01.1995',
      address: '8 dbdbdb', country: 'Swiss', gender: 'Man'
    };

  form: FormGroup = new FormGroup({});

  constructor(private fb: FormBuilder) {
  }

  ngOnInit(): void {
    this.form = this.fb.group({
      name: [null, [Validators.required, Validators.minLength(10)]],
      email: [null, [Validators.required, Validators.pattern('^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$')]],
      dob: [null, [Validators.required]],
      address: [this.exercisePersonInfo.address],
      country: [null],
      gender: [null]
    });
    this.form.get('name').setValue(this.exercisePersonInfo.name);
    this.form.get('email').setValue(this.exercisePersonInfo.email);
    this.form.get('dob').setValue(this.exercisePersonInfo.dob);
  }

  saveDetails(form: any) {
    alert('SUCCESS!! :-)\n\n' + JSON.stringify(form.value, null, 4));
  }
}
