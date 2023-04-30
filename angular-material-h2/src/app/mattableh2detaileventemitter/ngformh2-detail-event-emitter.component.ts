import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {PersonExerciseDTO} from "../mattableh2/models/person-exercise-DTO";
import {ExerciseDTO} from "../mattableh2/models/exerciseDTO";

@Component({
  selector: 'app-ngformh2-detail-event-emitter',
  templateUrl: './ngformh2-detail-event-emitter.component.html',
  styleUrls: ['./ngformh2-detail-event-emitter.component.css']
})
export class Ngformh2DetailEventEmitterComponent implements OnInit {

  @Input() selectedPersonExerciseDTO: PersonExerciseDTO = new PersonExerciseDTO();
  @Input() selectedExerciseDTO: ExerciseDTO = new ExerciseDTO();
  @Output() personExerciseH2Change: EventEmitter<PersonExerciseDTO> = new EventEmitter<PersonExerciseDTO>();

  constructor() {
  }

  ngOnInit() {
  }

  update() {
    this.personExerciseH2Change.emit(this.selectedPersonExerciseDTO);
  }

}
