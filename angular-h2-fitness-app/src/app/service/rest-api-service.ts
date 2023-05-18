import {Injectable} from '@angular/core';
import {catchError, map, retry} from 'rxjs/operators';
import {Observable} from 'rxjs-compat/Observable';
import {throwError} from 'rxjs/internal/observable/throwError';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {LoginDTO} from "../models/loginDTO";
import {Subject} from "rxjs/Subject";
import {Router} from "@angular/router";
import {TrainingService} from "../training/training.service";

/**
 * see training.service.ts
 */
@Injectable({
  providedIn: 'root'
})
export class RestApiService {
  authChange = new Subject<boolean>();

  // Define API
  private apiURL = 'http://localhost:8084/api/fitness';

  constructor(
    private httpClient: HttpClient,
    private router: Router,
    private trainingService: TrainingService) {
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

  getDefaultLoginDTO(): Observable<LoginDTO> {
    return this.httpClient.get<LoginDTO>(this.apiURL + '/defaultlogin').pipe(
      map((response) => response), catchError(this.handleError)
    );
  }


  // TODO Other possibility -> This method works as well
  // public registerUser(loginDTO: LoginDTO): Observable<LoginDTO> {
  //   console.log("loginDTO.userid: " + loginDTO.userid);
  //   return this.httpClient.post<LoginDTO>(this.apiURL + '/signup', loginDTO);
  // }

  // httpClientClient API post() method => Create LoginDTO
  registerUser(loginDTO: LoginDTO): Observable<LoginDTO> {
    return this.httpClient
      .post<LoginDTO>(
        this.apiURL + '/signup',
        loginDTO,
        this.httpClientOptions
      )
      .pipe(retry(1), catchError(
        this.handleError
      ));
  }


  //
  // getPersonExerciseDTO(): Observable<PersonExerciseDTO> {
  //   return this.httpClient.get<PersonExerciseDTO>(this.apiURL).pipe(
  //     map((response) => response), catchError(this.handleError)
  //   );
  // }
  //
  // // httpClientClient API get() method => Fetch LoginDTOs list
  // getLoginDTOs(): Observable<PersonExerciseDTO> {
  //   return this.httpClient
  //     .get<PersonExerciseDTO>(this.apiURL + '/PersonExerciseDTO')
  //     .pipe(retry(1), catchError(this.handleError));
  // }
  //
  // // httpClientClient API get() method => Fetch LoginDTO
  // getLoginDTO(id: any): Observable<PersonExerciseDTO> {
  //   return this.httpClient
  //     .get<PersonExerciseDTO>(this.apiURL + '/LoginDTOs/' + id)
  //     .pipe(retry(1), catchError(this.handleError));
  // }
  //
  // // httpClientClient API post() method => Create LoginDTO
  // createLoginDTO(LoginDTO: any): Observable<PersonExerciseDTO> {
  //   return this.httpClient
  //     .post<PersonExerciseDTO>(
  //       this.apiURL + '/PersonExerciseDTO',
  //       JSON.stringify(PersonExerciseDTO),
  //       this.httpClientOptions
  //     )
  //     .pipe(retry(1), catchError(this.handleError));
  // }
  //
  // // httpClientClient API put() method => Update LoginDTO
  // updateLoginDTOById(id: any, LoginDTO: any): Observable<PersonExerciseDTO> {
  //   return this.httpClient
  //     .put<PersonExerciseDTO>(
  //       this.apiURL + '/LoginDTOs/' + id,
  //       JSON.stringify(LoginDTO),
  //       this.httpClientOptions
  //     )
  //     .pipe(retry(1), catchError(this.handleError));
  // }
  //
  // // httpClientClient API put() method => Update LoginDTO
  // updateLogin(LoginDTO: any): Observable<PersonExerciseDTO> {
  //   return this.httpClient
  //     .put<PersonExerciseDTO>(
  //       this.apiURL + '/updateLogin',
  //       JSON.stringify(LoginDTO),
  //       this.httpClientOptions
  //     )
  //     .pipe(retry(1), catchError(this.handleError));
  // }
  //
  // // httpClientClient API delete() method => Delete LoginDTO
  // deleteExersice(perId: any, exId: any) {
  //   return this.httpClient
  //     .delete<PersonExerciseDTO>(this.apiURL + '/delete/personId/' + perId + /exserciseId/ + exId,
  //       this.httpClientOptions
  //     )
  //     .pipe(retry(1), catchError(this.handleError));
  // }

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
    console.log("handleError >> " + errorMessage);
    window.alert(errorMessage);
    return throwError(() => {
      return errorMessage;
    });
  }
}
