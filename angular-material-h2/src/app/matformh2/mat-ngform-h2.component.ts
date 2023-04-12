import { Component, OnInit } from '@angular/core';
import {Exercise} from "../training/exercise.model";
import {TrainingService} from "../training/training.service";
import {NgForm} from "@angular/forms";
import {MatNgtableH2Service} from "../mattableh2/mat-ngtable-h2.service";

@Component({
  selector: 'app-mat-ngform-h2',
  templateUrl: './mat-ngform-h2.component.html',
  styleUrls: ['./mat-ngform-h2.component.css']
})
export class MatNgformH2Component implements OnInit {

  exercises: Exercise[] = [];

  constructor(private trainingService: TrainingService) { }

  ngOnInit() {
    this.exercises = this.trainingService.getAvailableExercises();
  }

  onStartTraining(form: NgForm) {
    this.trainingService.startExercise(form.value.exercise);
  }

}
