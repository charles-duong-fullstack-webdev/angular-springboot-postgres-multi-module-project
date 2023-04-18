import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {PersonExerciseH2} from "../mattableh2/models/person-exercise-h2";

@Component({
  selector: 'app-ngformh2-detail-event-emitter',
  templateUrl: './ngformh2-detail-event-emitter.component.html',
  styleUrls: ['./ngformh2-detail-event-emitter.component.css']
})
export class Ngformh2DetailEventEmitterComponent implements OnInit {

  @Input() personExerciseH2: PersonExerciseH2 = new PersonExerciseH2();
  @Output() personExerciseH2Change: EventEmitter<PersonExerciseH2> = new EventEmitter<PersonExerciseH2>();

  constructor() {}
  ngOnInit() {
  }

  update() {
    this.personExerciseH2Change.emit(this.personExerciseH2);
  }

}
