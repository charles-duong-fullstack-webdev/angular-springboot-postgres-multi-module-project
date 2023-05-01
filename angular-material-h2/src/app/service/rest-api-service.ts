import {Injectable} from '@angular/core';
import {catchError, map, retry} from 'rxjs/operators';
import {Observable} from 'rxjs-compat/Observable';
import {PersonExerciseDTO} from '../mattableh2/models/person-exercise-DTO';
import {throwError} from 'rxjs/internal/observable/throwError';
import {HttpClient, HttpHeaders} from '@angular/common/http';

/**
 * see training.service.ts
 */
@Injectable({
  providedIn: 'root'
})
export class RestApiService {
  // Define API
  private apiURL = 'http://localhost:8084/api/mattableh2/exercise';

  constructor(private httpClient: HttpClient) {
  }

  /*========================================
    CRUD Methods for consuming RESTful API
  =========================================*/
  // httpClient Options
  httpClientOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
    }),
  };

  // httpClientClient API get() method => Fetch PersonExersiceDTO
  getPersonExerciseDTO(): Observable<PersonExerciseDTO> {
    return this.httpClient.get<PersonExerciseDTO>(this.apiURL).pipe(
      map((response) => response), catchError(this.handleError)
    );
  }

  // httpClientClient API get() method => Fetch PersonExersiceDTOs list
  getPersonExersiceDTOs(): Observable<PersonExerciseDTO> {
    return this.httpClient
      .get<PersonExerciseDTO>(this.apiURL + '/PersonExerciseDTO')
      .pipe(retry(1), catchError(this.handleError));
  }

  // httpClientClient API get() method => Fetch PersonExersiceDTO
  getPersonExersiceDTO(id: any): Observable<PersonExerciseDTO> {
    return this.httpClient
      .get<PersonExerciseDTO>(this.apiURL + '/PersonExersiceDTOs/' + id)
      .pipe(retry(1), catchError(this.handleError));
  }

  // httpClientClient API post() method => Create PersonExersiceDTO
  createPersonExersiceDTO(PersonExersiceDTO: any): Observable<PersonExerciseDTO> {
    return this.httpClient
      .post<PersonExerciseDTO>(
        this.apiURL + '/PersonExerciseDTO',
        JSON.stringify(PersonExerciseDTO),
        this.httpClientOptions
      )
      .pipe(retry(1), catchError(this.handleError));
  }

  // httpClientClient API put() method => Update PersonExersiceDTO
  updatePersonExersiceDTOById(id: any, PersonExersiceDTO: any): Observable<PersonExerciseDTO> {
    return this.httpClient
      .put<PersonExerciseDTO>(
        this.apiURL + '/PersonExersiceDTOs/' + id,
        JSON.stringify(PersonExersiceDTO),
        this.httpClientOptions
      )
      .pipe(retry(1), catchError(this.handleError));
  }

  // httpClientClient API put() method => Update PersonExersiceDTO
  updatePersonExersice(PersonExersiceDTO: any): Observable<PersonExerciseDTO> {
    return this.httpClient
      .put<PersonExerciseDTO>(
        this.apiURL + '/updatePersonExersice',
        JSON.stringify(PersonExersiceDTO),
        this.httpClientOptions
      )
      .pipe(retry(1), catchError(this.handleError));
  }

  // httpClientClient API delete() method => Delete PersonExersiceDTO
  deleteExersice(perId: any, exId: any) {
    return this.httpClient
      .delete<PersonExerciseDTO>(this.apiURL + '/delete/personId/' + perId + /exserciseId/ + exId,
        this.httpClientOptions
      )
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
