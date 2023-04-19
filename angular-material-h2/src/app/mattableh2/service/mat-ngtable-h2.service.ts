import {HttpClient} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {map} from 'rxjs/operators';
import {Observable} from 'rxjs-compat/Observable';
import {PersonExerciseH2} from '../models/person-exercise-h2';
import {BehaviorSubject} from "rxjs";
import {Subject} from "rxjs/Subject";

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
      address: '8 dbdbdb', country: 'Swiss', gender: 'Man'
    };

  private messageSource = new BehaviorSubject('MatNgtableH2Service define BehaviorSubject message');
  public personExerciseH2Subject$ = new Subject();

  currentMessage = this.messageSource.asObservable();
  currentPersonExerciseH2 = this.messageSource.asObservable();

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
    window.alert('this.personExerciseH2Subject$.next(element)): ' + element);
    this.personExerciseH2Subject$.next(element);
  }

}
