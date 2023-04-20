import {HttpClient} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {map} from 'rxjs/operators';
import {Observable} from 'rxjs-compat/Observable';
import {PersonExerciseH2} from '../models/person-exercise-h2';
import {BehaviorSubject} from 'rxjs/BehaviorSubject';
import {PersonH2} from "../models/person-h2";

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

  private getUrl = 'http://localhost:8084/api/mattableh2/exercises';
  private personExerciseH2: PersonExerciseH2;
  private personExerciseH2ForDialog: PersonExerciseH2;

  constructor(private httpClient: HttpClient) {
  }

  getExercise(): Observable<PersonExerciseH2[]> {
    return this.httpClient.get<PersonExerciseH2[]>(this.getUrl).pipe(
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

  setPersonExerciseH2ForDialog(element: PersonExerciseH2) {
    console.log('%%%%%%%%% setPersonExerciseH2ForDialog(element: PersonExerciseH2) element.name: ' + element.name);
    window.alert('this.personExerciseH2Subject$.next(element)): ' + element);
    this.personExerciseH2Subject$ = new Observable((observer) => {
      console.log('Starting observable');
      element.personH2 = new PersonH2();
      element.personH2.id = 1;
      element.personH2.name = this.exercisePersonInfo.name;
      element.personH2.dob = this.exercisePersonInfo.dob;
      element.personH2.address = this.exercisePersonInfo.address;
      element.personH2.email = this.exercisePersonInfo.email;
      element.personH2.country = this.exercisePersonInfo.country;
      element.personH2.gender = this.exercisePersonInfo.gender;
      observer.next(element);
    });
  }
}
