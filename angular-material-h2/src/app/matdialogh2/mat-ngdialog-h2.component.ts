import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material/dialog';
import {FormBuilder, FormGroup} from '@angular/forms';

@Component({
  selector: 'app-matdialogh2',
  templateUrl: './mat-ngdialog-h2.component.html',
  styleUrls: ['./mat-ngdialog-h2.component.css']
})
export class MatNgdialogH2Component implements OnInit {
  form: FormGroup;
  description: string;

  constructor(
    private fb: FormBuilder,
    private dialogRef: MatDialogRef<MatNgdialogH2Component>,
    @Inject(MAT_DIALOG_DATA) data) {

    this.description = data.description;
  }

  ngOnInit() {
    this.form = this.fb.group({
      description: [this.description, []],
      // ...
    });
  }

  save() {
    window.alert('save this.form.value:' + this.form.value);
    this.dialogRef.close(this.form.value);
  }

  close() {
    window.alert('close this.form.value:' + this.form.value);
    this.dialogRef.close();
  }

}
