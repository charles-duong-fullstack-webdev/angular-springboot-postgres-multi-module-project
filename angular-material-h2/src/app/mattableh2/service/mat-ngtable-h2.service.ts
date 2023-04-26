import {HttpClient} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {map} from 'rxjs/operators';
import {Observable} from 'rxjs-compat/Observable';
import {PersonExerciseH2} from '../models/person-exercise-h2';
import {BehaviorSubject} from 'rxjs/BehaviorSubject';
import {ExerciseH2} from '../models/exerciseH2';

/**
 * see training.service.ts
 */
@Injectable({
  providedIn: 'root'
})
export class MatNgtableH2Service {
  private exercisePersonInfo =
    {
      name: 'MatNgtableH2Service Charles', email: 'chares@gmail.com', dob: '30.01.1995',
      address: 'MatNgtableH2Service 1', country: 'Swiss', gender: 'Man'
    };

  private messageSource = new BehaviorSubject('MatNgtableH2Service define BehaviorSubject message');
  public personExerciseH2Subject$ = new Observable();

  currentMessage = this.messageSource.asObservable();

  private getUrl = 'http://localhost:8084/api/mattableh2/exercise';
  private personExerciseH2: PersonExerciseH2;
  // private personExerciseH2ForDialog: PersonExerciseH2;

  constructor(private httpClient: HttpClient) {
  }

  getExercise(): Observable<PersonExerciseH2> {
    return this.httpClient.get<PersonExerciseH2>(this.getUrl).pipe(
      map((response) => response)
    );
  }

  changeMessage(message: string) {
    this.messageSource.next(message);
  }

  // TODO how to passing data to dialg person info - personH2 is null
  getPersonExerciseH2(): PersonExerciseH2 {
    // this.personExerciseH2.personH2.name = this.exercisePersonInfo.name;
    // alert('this.personExerciseH2.personH2.name: ' + this.personExerciseH2.personH2.name);
    return this.personExerciseH2;
  }

  setEditExercise(value: PersonExerciseH2) {
    this.personExerciseH2 = value;
  }

  setPersonExerciseH2ForDialog(exercise: ExerciseH2) {
    console.log('%%%%%%%%% setPersonExerciseH2ForDialog(element: ExerciseH2) element.name: ' + exercise.name);
    window.alert('this.personExerciseH2Subject$.next(element)): ' + exercise);
    this.personExerciseH2Subject$ = new Observable((observer) => {
      console.log('Starting observable');
      // element.exercise = new Exercise();
      // element.exercise.id = 1;
      // element.exercise.name = this.exercisePersonInfo.name;
      // element.exercise.dob = this.exercisePersonInfo.dob;
      // element.exercise.address = this.exercisePersonInfo.address;
      // element.exercise.email = this.exercisePersonInfo.email;
      // element.exercise.country = this.exercisePersonInfo.country;
      // element.exercise.gender = this.exercisePersonInfo.gender;
      observer.next(exercise);
    });
  }
}
