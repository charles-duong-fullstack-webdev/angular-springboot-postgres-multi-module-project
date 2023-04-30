import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {catchError, retry} from 'rxjs/operators';
import {Observable} from 'rxjs-compat/Observable';
import {PersonExerciseDTO} from '../mattableh2/models/person-exercise-DTO';
import {throwError} from 'rxjs/internal/observable/throwError';

/**
 * see training.service.ts
 */
@Injectable({
  providedIn: 'root'
})
export class RestApiService {
  // Define API
  apiURL = 'http://localhost:3000';

  constructor(private http: HttpClient) {
  }

  /*========================================
    CRUD Methods for consuming RESTful API
  =========================================*/
  // Http Options
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
    }),
  };

  // HttpClient API get() method => Fetch PersonExersiceDTOs list
  getPersonExersiceDTOs(): Observable<PersonExerciseDTO> {
    return this.http
      .get<PersonExerciseDTO>(this.apiURL + '/PersonExerciseDTO')
      .pipe(retry(1), catchError(this.handleError));
  }

  // HttpClient API get() method => Fetch PersonExersiceDTO
  getPersonExersiceDTO(id: any): Observable<PersonExerciseDTO> {
    return this.http
      .get<PersonExerciseDTO>(this.apiURL + '/PersonExersiceDTOs/' + id)
      .pipe(retry(1), catchError(this.handleError));
  }

  // HttpClient API post() method => Create PersonExersiceDTO
  createPersonExersiceDTO(PersonExersiceDTO: any): Observable<PersonExerciseDTO> {
    return this.http
      .post<PersonExerciseDTO>(
        this.apiURL + '/PersonExerciseDTO',
        JSON.stringify(PersonExerciseDTO),
        this.httpOptions
      )
      .pipe(retry(1), catchError(this.handleError));
  }

  // HttpClient API put() method => Update PersonExersiceDTO
  updatePersonExersiceDTO(id: any, PersonExersiceDTO: any): Observable<PersonExerciseDTO> {
    return this.http
      .put<PersonExerciseDTO>(
        this.apiURL + '/PersonExersiceDTOs/' + id,
        JSON.stringify(PersonExersiceDTO),
        this.httpOptions
      )
      .pipe(retry(1), catchError(this.handleError));
  }

  // HttpClient API delete() method => Delete PersonExersiceDTO
  deletePersonExersiceDTO(id: any) {
    return this.http
      .delete<PersonExerciseDTO>(this.apiURL + '/PersonExerciseDTO/' + id, this.httpOptions)
      .pipe(retry(1), catchError(this.handleError));
  }

  // Error handling
  handleError(error: any) {
    let errorMessage = '';
    if (error.error instanceof ErrorEvent) {
      // Get client-side error
      errorMessage = error.error.message;
    } else {
      // Get server-side error
      errorMessage = `Error Code: ${error.status}\nMessage: ${error.message}`;
    }
    window.alert(errorMessage);
    return throwError(() => {
      return errorMessage;
    });
  }
}
