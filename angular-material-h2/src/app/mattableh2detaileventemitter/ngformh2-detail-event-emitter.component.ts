import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {PersonExerciseDTO} from "../mattableh2/models/person-exercise-DTO";

@Component({
  selector: 'app-ngformh2-detail-event-emitter',
  templateUrl: './ngformh2-detail-event-emitter.component.html',
  styleUrls: ['./ngformh2-detail-event-emitter.component.css']
})
export class Ngformh2DetailEventEmitterComponent implements OnInit {

  @Input() personExerciseH2: PersonExerciseDTO = new PersonExerciseDTO();
  @Output() personExerciseH2Change: EventEmitter<PersonExerciseDTO> = new EventEmitter<PersonExerciseDTO>();

  constructor() {}
  ngOnInit() {
  }

  update() {
    this.personExerciseH2Change.emit(this.personExerciseH2);
  }

}
