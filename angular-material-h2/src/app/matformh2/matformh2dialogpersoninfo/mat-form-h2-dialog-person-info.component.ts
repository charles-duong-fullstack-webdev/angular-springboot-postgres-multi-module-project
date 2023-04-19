import {Component, Injectable, Input, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {MatNgtableH2Service} from '../../mattableh2/service/mat-ngtable-h2.service';
import {PersonExerciseH2} from '../../mattableh2/models/person-exercise-h2';
import {PersonH2} from '../../mattableh2/models/person-h2';

@Injectable({
  providedIn: 'root'
})
@Component({
  selector: 'app-mat-form-h2-dialog-person-info',
  templateUrl: './mat-form-h2-dialog-person-info.component.html',
  styleUrls: ['./mat-form-h2-dialog-person-info.component.css']
})
export class MatFormH2DialogPersonInfoComponent implements OnInit {

  @Input() selectedPersonExerciseH2Child = new PersonExerciseH2();

  private exercisePersonInfo =
    {
      name: 'Charles', email: 'chares@gmail.com', dob: '30.01.1995',
      address: '80 dbdbdb', country: 'Swiss', gender: 'Man'
    };

  form: FormGroup = new FormGroup({});

  constructor(private fb: FormBuilder, private matNgtableH2Service: MatNgtableH2Service) {
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
    // this.form.get('name').setValue(this.exercisePersonInfo.name);
    // alert('MatFormH2DialogPersonInfoComponent name: ' + this.matNgtableH2Service.getPersonExerciseH2().personH2.name);
    // TODO how to passing data to dialg person info - personH2 is null
    // this.form.get('name').setValue(this.matNgtableH2Service.getPersonExerciseH2().personH2.name);
    // this.form.get('name').setValue(this.selectedPersonExerciseH2Child.name);
    //
    // window.alert('<<<<<< MatFormH2DialogPersonInfoComponent this.selectedPersonExerciseH2Child:' + this.selectedPersonExerciseH2Child);
    //
    // if (this.selectedPersonExerciseH2Child.personH2 != null) {
    //   window.alert('<<<<<< MatFormH2DialogPersonInfoComponent email:' + this.selectedPersonExerciseH2Child.personH2.email);
    //   window.alert('<<<<<< MatFormH2DialogPersonInfoComponent dob:' + this.selectedPersonExerciseH2Child.personH2.dob);
    //
    //   this.form.get('email').setValue(this.selectedPersonExerciseH2Child.personH2.email);
    //   this.form.get('dob').setValue(this.selectedPersonExerciseH2Child.personH2.dob);
    //   // this.form.get('address').setValue(this.selectedPersonExerciseH2Child.personH2.address);
    // }


  }

  setSelectedPersonExerciseH2Child(element: PersonExerciseH2) {
    window.alert('-------------> setSelectedPersonExerciseH2Child....');

    this.selectedPersonExerciseH2Child.name = element.name;
    this.selectedPersonExerciseH2Child.id = element.id;
    this.selectedPersonExerciseH2Child.calories = element.calories;
    this.selectedPersonExerciseH2Child.duration = element.duration;
    this.selectedPersonExerciseH2Child.personH2 = new PersonH2();
    this.selectedPersonExerciseH2Child.personH2.name = this.exercisePersonInfo.name;
    this.selectedPersonExerciseH2Child.personH2.dob = this.exercisePersonInfo.dob;
    this.selectedPersonExerciseH2Child.personH2.address = this.exercisePersonInfo.address;
    this.selectedPersonExerciseH2Child.personH2.email = this.exercisePersonInfo.email;
    this.selectedPersonExerciseH2Child.personH2.country = this.exercisePersonInfo.country;
    this.selectedPersonExerciseH2Child.personH2.gender = this.exercisePersonInfo.gender;
    window.alert('----- setSelectedPersonExerciseH2Child email: ' + this.selectedPersonExerciseH2Child.personH2.email);
    window.alert('----- setSelectedPersonExerciseH2Child dob: ' + this.selectedPersonExerciseH2Child.personH2.dob);

    // this.form.get('email').setValue(this.selectedPersonExerciseH2Child.personH2.email);
    // this.form.get('dob').setValue(this.selectedPersonExerciseH2Child.personH2.dob);

  }

  setFormDetails(form: any) {
    this.matNgtableH2Service.personExerciseH2Subject$.subscribe(val => {
      window.alert('this.matNgtableH2Service.personExerciseH2Subject$.subscribe(val): ' + val);
    });
  }

  saveDetails(form: any) {
    alert('SUCCESS!! :-)\n\n' + JSON.stringify(form.value, null, 4));
  }
}
