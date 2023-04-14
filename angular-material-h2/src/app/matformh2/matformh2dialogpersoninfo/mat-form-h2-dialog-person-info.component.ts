import {Component, Input, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {MatNgtableH2Service} from '../../mattableh2/mat-ngtable-h2.service';


@Component({
  selector: 'app-mat-form-h2-dialog-person-info',
  templateUrl: './mat-form-h2-dialog-person-info.component.html',
  styleUrls: ['./mat-form-h2-dialog-person-info.component.css']
})
export class MatFormH2DialogPersonInfoComponent implements OnInit {

  @Input() selectedPersonExerciseH2Child: any;

  private exercisePersonInfo =
    {
      name: 'Charles', email: 'chares@gmail.com', dob: '30.01.1995',
      address: '8 dbdbdb', country: 'Swiss', gender: 'Man'
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
    this.form.get('name').setValue(this.selectedPersonExerciseH2Child.name);
    this.form.get('email').setValue(this.selectedPersonExerciseH2Child.email);
    this.form.get('dob').setValue(this.selectedPersonExerciseH2Child.dob);
    this.form.get('address').setValue(this.selectedPersonExerciseH2Child.address);
  }

  saveDetails(form: any) {
    alert('SUCCESS!! :-)\n\n' + JSON.stringify(form.value, null, 4));
  }
}
