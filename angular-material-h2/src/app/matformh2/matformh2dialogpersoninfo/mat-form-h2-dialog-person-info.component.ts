import {Component, Injectable, Input, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {MatNgtableH2Service} from '../../mattableh2/service/mat-ngtable-h2.service';
import {PersonExerciseDTO} from '../../mattableh2/models/person-exercise-DTO';
import {ExerciseDTO} from '../../mattableh2/models/exerciseDTO';

@Injectable({
  providedIn: 'root'
})
@Component({
  selector: 'app-mat-form-h2-dialog-person-info',
  templateUrl: './mat-form-h2-dialog-person-info.component.html',
  styleUrls: ['./mat-form-h2-dialog-person-info.component.css']
})
export class MatFormH2DialogPersonInfoComponent implements OnInit {

  @Input() selectedPersonExerciseH2Child = new PersonExerciseDTO();

  private exercisePersonInfo =
    {
      name: 'Charles', email: 'chares@gmail.com', dob: '30.01.1995',
      address: '80 dbdbdb', country: 'Swiss', gender: 'Man'
    };

  form: FormGroup = new FormGroup({});

  constructor(private fb: FormBuilder, private matNgtableH2Service: MatNgtableH2Service) {
  }

  ngOnInit(): void {
    console.log('<<<<<< ngOnInit .this.form = this.fb.group(');
    this.form = this.fb.group({
      name: [null, [Validators.required, Validators.minLength(10)]],
      email: [null, [Validators.required, Validators.pattern('^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$')]],
      dob: [null, [Validators.required]],
      address: [this.exercisePersonInfo.address],
      country: [null],
      gender: [null]
    });

    console.log('1 <<<<<< <<<<<< ngOnInit this.matNgtableH2Service.personExerciseH2Subject$.subscribe(val): ');
    this.matNgtableH2Service.personExerciseH2Subject$.subscribe(val => {
      console.log('2 <<<<<< this.matNgtableH2Service.personExerciseH2Subject$.subscribe(val): ' + val);
      // window.alert('<<<<<< this.matNgtableH2Service.personExerciseH2Subject$.subscribe(val): ' + val);
      const editExerciseH2 = new ExerciseDTO();
      Object.assign(editExerciseH2, val);
      console.log('3 <<<<<< subscribe(val.toString()): ' + val.toString());
      console.log('4 <<<<<< subscribe(editExerciseH2.name): ' + editExerciseH2.name);
      this.form.get('name').setValue('persExerciseH2.exercise.name');
      // this.form.get('email').setValue(persExerciseH2.exercise.email);
      // this.form.get('address').setValue(persExerciseH2.exercise.address);
      // this.form.get('country').setValue(persExerciseH2.exercise.country);
      // this.form.get('gender').setValue(persExerciseH2.exercise.gender);
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

  // setSelectedPersonExerciseH2Child(element: ExerciseDTO) {
  //   window.alert('-------------> setSelectedPersonExerciseH2Child....');
  //
  //   this.selectedPersonExerciseH2Child.name = element.name;
  //   this.selectedPersonExerciseH2Child.id = element.id;
  //   this.selectedPersonExerciseH2Child.calories = element.calories;
  //   this.selectedPersonExerciseH2Child.duration = element.duration;
  //   this.selectedPersonExerciseH2Child.exercise = new ExerciseDTO();
  //   this.selectedPersonExerciseH2Child.exercise.name = this.exercisePersonInfo.name;
  //   this.selectedPersonExerciseH2Child.exercise.dob = this.exercisePersonInfo.dob;
  //   this.selectedPersonExerciseH2Child.exercise.address = this.exercisePersonInfo.address;
  //   this.selectedPersonExerciseH2Child.exercise.email = this.exercisePersonInfo.email;
  //   this.selectedPersonExerciseH2Child.exercise.country = this.exercisePersonInfo.country;
  //   this.selectedPersonExerciseH2Child.exercise.gender = this.exercisePersonInfo.gender;
  //   window.alert('----- setSelectedPersonExerciseH2Child email: ' + this.selectedPersonExerciseH2Child.exercise.email);
  //   window.alert('----- setSelectedPersonExerciseH2Child dob: ' + this.selectedPersonExerciseH2Child.exercise.dob);
  //
  //   // this.form.get('email').setValue(this.selectedPersonExerciseH2Child.personH2.email);
  //   // this.form.get('dob').setValue(this.selectedPersonExerciseH2Child.personH2.dob);
  //
  // }

  setFormDetails(form: any) {
    this.matNgtableH2Service.personExerciseH2Subject$.subscribe(val => {
      window.alert('this.matNgtableH2Service.personExerciseH2Subject$.subscribe(val): ' + val);
    });
  }

  saveDetails(form: any) {
    alert('SUCCESS!! :-)\n\n' + JSON.stringify(form.value, null, 4));
  }
}
